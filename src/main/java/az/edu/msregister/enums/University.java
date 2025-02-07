package az.edu.msregister.enums;

public enum University {
    BAKU_UNIVERSITY("Baku University", "Baku, Azerbaijan"),
    ADA_UNIVERSITY("ADA University", "Baku, Azerbaijan"),
    GAZI_UNIVERSITY("Gazi University", "Ankara, Turkey");

    private final String name;
    private final String location;

    University(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }
}
