package az.edu.msregister.service;
import az.edu.msregister.dto.request.LoginRequest;
import az.edu.msregister.dto.request.RefreshRequest;
import az.edu.msregister.dto.response.LoginResponse;

public interface AuthService {

    LoginResponse login(LoginRequest request);

    LoginResponse refreshToken(RefreshRequest request);

}
