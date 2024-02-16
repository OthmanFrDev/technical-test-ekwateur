package technical.test.ekwateur.utils;

import technical.test.ekwateur.entity.Client;
import technical.test.ekwateur.entity.ClientPro;
import technical.test.ekwateur.entity.EnergyPrice;

public abstract class EnergyPriceHelper {
    public static EnergyPrice getEnergyPrice(Client client) {
        double electricityPrice = 0, gazPrice = 0;
        if (client instanceof ClientPro) {
            electricityPrice = ((ClientPro) client).isCaGreatherThanOneM() ? Constants.CLIENT_PRO_ELECTRICITY_PRICE_GT_1_M
                    : Constants.CLIENT_PRO_ELECTRICITY_PRICE_LT_1_M;
            gazPrice = ((ClientPro) client).isCaGreatherThanOneM() ? Constants.CLIENT_PRO_GAZ_PRICE_GT_1_M
                    : Constants.CLIENT_PRO_GAZ_PRICE_LT_1_M;
        } else {
            electricityPrice = Constants.PARTICULIER_ELECTRICITY_PRICE;
            gazPrice = Constants.PARTICULIER_GAZ_PRICE;
        }
        return new EnergyPrice(electricityPrice, gazPrice);
    }
}
