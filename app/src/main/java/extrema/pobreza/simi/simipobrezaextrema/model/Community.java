package extrema.pobreza.simi.simipobrezaextrema.model;

public class Community {
    private String name;
    private int totalBeneficiarios;
    private int TotalDonaciones;
    private int status;

    public Community(String name, int totalBeneficiarios, int totalDonaciones, int status) {
        this.name = name;
        this.totalBeneficiarios = totalBeneficiarios;
        TotalDonaciones = totalDonaciones;
        this.status = status;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}