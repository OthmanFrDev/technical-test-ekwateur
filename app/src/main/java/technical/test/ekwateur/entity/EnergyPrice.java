package technical.test.ekwateur.entity;

import technical.test.ekwateur.exception.UnknownEnergyTypeException;

public class EnergyPrice {

    private double electricityPrice;
    private double gazPrice;

    public EnergyPrice(double electricityPrice, double gazPrice) {
        this.electricityPrice = electricityPrice;
        this.gazPrice = gazPrice;
    }

    public double getEnergyPrice(EnergyType energyType) {
        switch (energyType) {
            case ELECTRICITY:
                return electricityPrice;
            case GAZ:
                return gazPrice;
            default:
                throw new UnknownEnergyTypeException(
                        String.format("EnergyType must be %s or %s.", EnergyType.ELECTRICITY, EnergyType.GAZ));
        }
    }
}
