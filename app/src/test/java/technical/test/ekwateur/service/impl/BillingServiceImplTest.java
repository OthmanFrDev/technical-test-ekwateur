package technical.test.ekwateur.service.impl;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import technical.test.ekwateur.entity.Civility;
import technical.test.ekwateur.entity.Client;
import technical.test.ekwateur.entity.ClientPro;
import technical.test.ekwateur.entity.EnergyConsumption;
import technical.test.ekwateur.entity.EnergyType;
import technical.test.ekwateur.entity.Particulier;
import technical.test.ekwateur.exception.ClientReferenceException;
import technical.test.ekwateur.exception.EnergyConsumptionException;

public class BillingServiceImplTest {

    private BillingServiceImpl billingServiceImpl;

    @BeforeEach
    public void setUp() {
        billingServiceImpl = new BillingServiceImpl();
    }

    @Test
    void shouldCalculateMonthlyAmountForClientProAndcaLtOneMillion() {
        double expectedResult = 48.05;
        Client client = new ClientPro("EKW00011122", "S3121324", "Test company", 120000);
        EnergyConsumption electricityConsumption = new EnergyConsumption(EnergyType.ELECTRICITY, 230);
        EnergyConsumption gazConsumption = new EnergyConsumption(EnergyType.GAZ, 185);
        double result = this.billingServiceImpl.calculateMonthlyAmount(client,
                List.of(electricityConsumption, gazConsumption));
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    void shouldCalculateMonthlyAmountForClientProAndcaGtOneMillion() {
        double expectedResult = 159.37;
        Client client = new ClientPro("EKW00011123", "S3121325", "Test company2", 1200000);
        EnergyConsumption electricityConsumption = new EnergyConsumption(EnergyType.ELECTRICITY, 950);
        EnergyConsumption gazConsumption = new EnergyConsumption(EnergyType.GAZ, 460);
        double result = this.billingServiceImpl.calculateMonthlyAmount(client,
                List.of(electricityConsumption, gazConsumption));
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    void shouldCalculateMonthlyAmountForParticulier() {
        double expectedResult = 15.76;
        Client client = new Particulier("EKW00011124", Civility.MR, "Fr", "Othman");
        EnergyConsumption electricityConsumption = new EnergyConsumption(EnergyType.ELECTRICITY, 96);
        EnergyConsumption gazConsumption = new EnergyConsumption(EnergyType.GAZ, 36);
        double result = this.billingServiceImpl.calculateMonthlyAmount(client,
                List.of(electricityConsumption, gazConsumption));
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    void shouldThrowWhenClientReferenceIncorrect() {
        Assertions.assertThrows(ClientReferenceException.class, () -> {
            Client client = new Particulier("10001", Civility.MR, "Fr", "Othman");
        });
    }

    @Test
    void shouldThrowWhenEnergyConsumptionValuesLtThanZero() {
        Assertions.assertThrows(EnergyConsumptionException.class, () -> {
            Client client = new Particulier("EKW00011124", Civility.MR, "Fr", "Othman");
            EnergyConsumption ec = new EnergyConsumption(EnergyType.ELECTRICITY, -87);
            this.billingServiceImpl.calculateMonthlyAmount(client, List.of(ec));
        });
    }
}
