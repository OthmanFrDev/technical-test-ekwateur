package technical.test.ekwateur.entity;

public class EnergyConsumption {

    private EnergyType energyType;
    private double consumption;
    
    public EnergyConsumption(EnergyType energyType, double consumption) {
        this.energyType = energyType;
        this.consumption = consumption;
    }

    public EnergyType getEnergyType() {
        return energyType;
    }

    public double getConsumption() {
        return consumption;
    }
    
}
