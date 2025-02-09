package az.edu.msregister.exceptions;

public class StaffNotFoundException extends RuntimeException {
    public StaffNotFoundException(String message) {
        super(message);
    }
}
