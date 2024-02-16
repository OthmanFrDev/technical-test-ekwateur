package technical.test.ekwateur.service.impl;

import java.util.List;

import technical.test.ekwateur.entity.Client;
import technical.test.ekwateur.entity.ClientPro;
import technical.test.ekwateur.entity.EnergyConsumption;
import technical.test.ekwateur.entity.Particulier;
import technical.test.ekwateur.service.BillingService;
import technical.test.ekwateur.service.InvoiceService;

public class InvoiceConsoleServiceImpl implements InvoiceService {
    private BillingService billingService = new BillingServiceImpl();

    @Override
    public void sendInvoice(Client client, List<EnergyConsumption> energyConsumptions) {
        System.out.println("================================ Facture ================================");
        System.out.printf("===================== Client reference: %s =====================\n\n",
                client.getReference());
        if (client instanceof ClientPro) {
            System.out.printf("- Raison sociale : %s\n\n", ((ClientPro) client).getRaisonSociale());
            System.out.printf("- Siret : %s\n", ((ClientPro) client).getSiret());
        } else {
            System.out.printf("Nom complet : %s %s %s\n", ((Particulier) client).getCivility().name(),
                    ((Particulier) client).getFirstName(), ((Particulier) client).getLastName());
        }
        System.out.println("\nConsommation :\n");
        energyConsumptions.forEach(e -> {
            System.out.printf("\t- %-12s: %.2f\n\n", e.getEnergyType().name(), e.getConsumption());
        });
        System.out.printf("Montant à payer : %.2f\n",
                billingService.calculateMonthlyAmount(client, energyConsumptions));
        System.out.println("=========================================================================");

    }

}
