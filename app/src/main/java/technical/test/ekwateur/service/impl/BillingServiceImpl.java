package technical.test.ekwateur.service.impl;

import java.util.List;

import technical.test.ekwateur.entity.Client;
import technical.test.ekwateur.entity.EnergyConsumption;
import technical.test.ekwateur.entity.EnergyPrice;
import technical.test.ekwateur.service.BillingService;
import technical.test.ekwateur.utils.EnergyPriceHelper;
import technical.test.ekwateur.utils.Validator;

public class BillingServiceImpl implements BillingService {

    @Override
    public double calculateMonthlyAmount(Client client, List<EnergyConsumption> energyConsumptions) {
        energyConsumptions.forEach(Validator::validateConsumption);
        EnergyPrice energyPrice = EnergyPriceHelper.getEnergyPrice(client);
        double result = energyConsumptions.stream()
                .map(e -> energyPrice.getEnergyPrice(e.getEnergyType()) * e.getConsumption())
                .reduce(0.0, Double::sum);
        return Math.ceil(result * 100) / 100;
    }

}
