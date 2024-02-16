package technical.test.ekwateur.entity;

import technical.test.ekwateur.utils.Validator;

public abstract class Client {

    private String reference;

    public Client(String reference) {
        Validator.validateReference(reference);
        this.reference = reference;
    }

    public String getReference() {
        return reference;
    }
    
}
