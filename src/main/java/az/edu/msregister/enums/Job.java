package az.edu.msregister.enums;

public enum Job {
    PROFESSOR("Professor", "Senior academic position"),
    LECTURER("Lecturer", "Teaches students in a university"),
    RESEARCHER("Researcher", "Focuses on academic research"),
    ADMINISTRATIVE("Administrative", "Works in the administrative department");

    private final String title;
    private final String description;

    Job(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
