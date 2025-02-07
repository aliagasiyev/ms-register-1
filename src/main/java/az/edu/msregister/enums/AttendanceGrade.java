package az.edu.msregister.enums;

public enum AttendanceGrade {
    EXCELLENT("Excellent"),
    GOOD("Good"),
    SATISFACTORY("Satisfactory"),
    NEEDS_IMPROVEMENT("Needs Improvement"),
    FAIL("Fail");

    private final String grade;

    AttendanceGrade(String grade) {
        this.grade = grade;
    }

    public String getGrade() {
        return grade;
    }
}
