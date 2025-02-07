package az.edu.msregister.exceptions;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@Hidden
@ControllerAdvice
public class GlobalExceptionHandler {

    private ResponseEntity<Object> buildResponse(String error, String message, HttpStatus status) {
        Map<String, String> response = new HashMap<>();
        response.put("error", error);
        response.put("message", message);
        return new ResponseEntity<>(response, status);
    }

    @ExceptionHandler(RoleNotFoundException.class)
    public ResponseEntity<Object> handleRoleNotFoundException(RoleNotFoundException ex) {
        return buildResponse("Role Not Found", ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RolePermissionException.class)
    public ResponseEntity<Object> handleRolePermissionException(RolePermissionException ex) {
        return buildResponse("Permission Denied", ex.getMessage(), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(InvalidRoleAssignmentException.class)
    public ResponseEntity<Object> handleInvalidRoleAssignmentException(InvalidRoleAssignmentException ex) {
        return buildResponse("Invalid Role Assignment", ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex) {
        return buildResponse("User Not Found", ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<Object> handleUserAlreadyExistsException(UserAlreadyExistsException ex) {
        return buildResponse("User Already Exists", ex.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(InvalidRequestException.class)
    public ResponseEntity<Object> handleInvalidRequestException(InvalidRequestException ex) {
        return buildResponse("Invalid Request", ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<Object> handleDatabaseException(DatabaseException ex) {
        return buildResponse("Database Error", ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(TokenExpiredException.class)
    public ResponseEntity<Object> handleTokenExpiredException(TokenExpiredException ex) {
        return buildResponse("Token Expired", ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SamePasswordException.class)
    public ResponseEntity<Object> handleSamePasswordException(SamePasswordException ex) {
        return buildResponse("Invalid Password", ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGenericException(Exception ex) {
        return buildResponse("Internal Server Error", ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
