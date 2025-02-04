package az.edu.msregister.enums;

public enum UserRole {

    SUPER_ADMIN("Has full access to manage the system, can create STAFF and USERS"),
    STAFF("Can create TEACHER and STUDENT accounts"),
    TEACHER("Can access and manage courses and student records"),
    STUDENT("Can access educational materials and submit assignments");

    private final String description;

    UserRole(String description) {
        this.description = description;
    }

}
