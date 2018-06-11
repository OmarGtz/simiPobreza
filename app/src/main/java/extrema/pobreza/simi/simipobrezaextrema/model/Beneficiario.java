package extrema.pobreza.simi.simipobrezaextrema.model;

public class Beneficiario {


    private String name;
    private boolean status;
    private String folio;

    public Beneficiario(String name, boolean status, String folio) {
        this.name = name;
        this.status = status;
        this.folio = folio;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }
}
