package az.edu.msregister.controller;

import az.edu.msregister.dto.request.ForgotPasswordRequest;
import az.edu.msregister.dto.request.LoginRequest;
import az.edu.msregister.dto.request.RefreshRequest;
import az.edu.msregister.dto.request.ResetPasswordRequest;
import az.edu.msregister.dto.response.LoginResponse;
import az.edu.msregister.service.AuthService;
import az.edu.msregister.service.impl.PasswordResetTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final PasswordResetTokenService passwordResetTokenService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/refresh")
    public ResponseEntity<LoginResponse> refreshToken(@RequestBody RefreshRequest request) {
        return ResponseEntity.ok(authService.refreshToken(request));
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<String> forgotPassword(@RequestBody ForgotPasswordRequest request) {
        passwordResetTokenService.createPasswordResetToken(request.getEmail());
        return ResponseEntity.ok("Password reset email has been sent.");
    }

    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(@RequestBody ResetPasswordRequest request) {
        passwordResetTokenService.resetPassword(request.getToken(), request.getNewPassword());
        return ResponseEntity.ok("Password has been successfully reset.");
    }
}
