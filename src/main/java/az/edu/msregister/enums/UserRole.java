package az.edu.msregister.enums;

/**
 * Defines different user roles and their categories in the system.
 */
public enum UserRole {

    SUPER_ADMIN("Has full access to manage the system, can create STAFF and USERS"),
    STAFF("Can create TEACHER and STUDENT accounts"),
    TEACHER("Can access and manage courses and student records"),
    STUDENT("Can access educational materials and submit assignments");

    private final String description;

    UserRole(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    /**
     * Checks if the role is SUPER_ADMIN.
     */
    public boolean isAdmin() {
        return this == SUPER_ADMIN;
    }

    /**
     * Checks if the role is STAFF.
     */
    public boolean isStaff() {
        return this == STAFF;
    }

    /**
     * Checks if the role is TEACHER or STUDENT.
     */
    public boolean isUser() {
        return this == TEACHER || this == STUDENT;
    }
}
