package technical.test.ekwateur.service;

import java.util.List;

import technical.test.ekwateur.entity.Client;
import technical.test.ekwateur.entity.EnergyConsumption;

public interface InvoiceService {
    void sendInvoice(Client client, List<EnergyConsumption> energyConsumptions);
}
