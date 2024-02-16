package technical.test.ekwateur.utils;

import java.util.Objects;
import java.util.regex.Pattern;

import technical.test.ekwateur.entity.EnergyConsumption;
import technical.test.ekwateur.exception.ClientReferenceException;
import technical.test.ekwateur.exception.EnergyConsumptionException;

public abstract class Validator {
    public static void validateReference(String reference) {
        if (Objects.isNull(reference))
            throw new ClientReferenceException("Client reference must not be null.");
        boolean isValidReference = Pattern.matches("EKW[0-9]{8}", reference);
        if (!isValidReference) {
            throw new ClientReferenceException("Client reference must start with EKW followed by 8 numbers.");
        }
    }

    public static void validateConsumption(EnergyConsumption energyConsumption) {
        if (Objects.isNull(energyConsumption))
            throw new EnergyConsumptionException("EnergyConsumption must not be null.");
        if (energyConsumption.getConsumption() < 0) {
            throw new EnergyConsumptionException(
                    String.format("%s quantity consumption must be greather than 0.",
                            energyConsumption.getEnergyType().name()));
        }
    }
}
