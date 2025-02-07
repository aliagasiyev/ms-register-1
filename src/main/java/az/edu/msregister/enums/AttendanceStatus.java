package az.edu.msregister.enums;

public enum AttendanceStatus {
    ATTENDED("Attended"),
    MISSED("Missed"),
    EXCUSED("Excused");

    private final String status;

    AttendanceStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
