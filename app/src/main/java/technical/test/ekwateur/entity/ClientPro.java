package technical.test.ekwateur.entity;

public class ClientPro extends Client {

    private String siret;
    private String raisonSociale;
    private double cA;

    public ClientPro(String reference, String siret, String raisonSociale, double cA) {
        super(reference);
        this.siret = siret;
        this.raisonSociale = raisonSociale;
        this.cA = cA;
    }

    public String getSiret() {
        return siret;
    }

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public double getcA() {
        return cA;
    }

    public boolean isCaGreatherThanOneM() {
        return this.cA >= 1_000_000;
    }

}
