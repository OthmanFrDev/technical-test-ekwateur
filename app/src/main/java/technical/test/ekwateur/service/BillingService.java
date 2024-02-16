package technical.test.ekwateur.service;

import java.util.List;

import technical.test.ekwateur.entity.Client;
import technical.test.ekwateur.entity.EnergyConsumption;

public interface BillingService {
    double calculateMonthlyAmount(Client client,List<EnergyConsumption> energyConsumptions);
}
