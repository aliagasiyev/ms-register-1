package az.edu.msregister.exceptions;

public class RolePermissionException extends RuntimeException {
    public RolePermissionException(String message) {
        super(message);
    }
}
