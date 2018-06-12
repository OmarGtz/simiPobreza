package extrema.pobreza.simi.simipobrezaextrema.model;

public class Community {
    private String name;
    private int totalBeneficiarios;
    private int TotalDonaciones;

    public Community(String name, int totalBeneficiarios, int totalDonaciones) {
        this.name = name;
        this.totalBeneficiarios = totalBeneficiarios;
        TotalDonaciones = totalDonaciones;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalBeneficiarios() {
        return totalBeneficiarios;
    }

    public void setTotalBeneficiarios(int totalBeneficiarios) {
        this.totalBeneficiarios = totalBeneficiarios;
    }

    public int getTotalDonaciones() {
        return TotalDonaciones;
    }

    public void setTotalDonaciones(int totalDonaciones) {
        TotalDonaciones = totalDonaciones;
    }
}