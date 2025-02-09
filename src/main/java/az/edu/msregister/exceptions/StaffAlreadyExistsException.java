package az.edu.msregister.exceptions;

public class StaffAlreadyExistsException extends RuntimeException {
    public StaffAlreadyExistsException(String message) {
        super(message);
    }
}
