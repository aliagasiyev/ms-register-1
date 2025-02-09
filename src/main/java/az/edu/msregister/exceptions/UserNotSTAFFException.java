package az.edu.msregister.exceptions;

public class UserNotSTAFFException extends RuntimeException {
    public UserNotSTAFFException(String message) {
        super(message);
    }
}
