package extrema.pobreza.simi.simipobrezaextrema.model;

public class Community {
    private String name;
    private String state;
    private String city;

    public Community(String name, String state, String city) {
        this.name = name;
        this.state = state;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
