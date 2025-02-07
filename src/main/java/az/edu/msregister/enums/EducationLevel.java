package az.edu.msregister.enums;

public enum EducationLevel {
    BACHELOR("Bachelor"),
    MASTER("Master"),
    PHD("PhD");

    private final String level;

    EducationLevel(String level) {
        this.level = level;
    }

    public String getLevel() {
        return level;
    }
}
