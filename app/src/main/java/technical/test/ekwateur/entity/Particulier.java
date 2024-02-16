package technical.test.ekwateur.entity;

public class Particulier extends Client{

    private Civility civility;
    private String lastName;
    private String firstName;

    public Particulier(String reference, Civility civility, String lastName, String firstName) {
        super(reference);
        this.civility = civility;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public Civility getCivility() {
        return civility;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    } 
    
}
