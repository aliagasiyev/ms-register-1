package az.edu.msregister.service.impl;

import az.edu.msregister.dto.request.ForgotPasswordRequest;
import az.edu.msregister.dto.request.LoginRequest;
import az.edu.msregister.dto.request.RefreshRequest;
import az.edu.msregister.dto.request.ResetPasswordRequest;
import az.edu.msregister.dto.response.LoginResponse;
import az.edu.msregister.security.JwtTokenProvider;
import az.edu.msregister.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordResetTokenService passwordResetTokenService;

    @Override
    public LoginResponse login(LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        String accessToken = jwtTokenProvider.generateAccessToken(authentication);
        String refreshToken = jwtTokenProvider.generateRefreshToken(authentication);

        return LoginResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    @Override
    public LoginResponse refreshToken(RefreshRequest request) {
        String refreshToken = request.getRefreshToken();

        if (!jwtTokenProvider.validateToken(refreshToken)) {
            throw new IllegalArgumentException("Invalid refresh token");
        }

        String username = jwtTokenProvider.getUsernameFromToken(refreshToken);
        UsernamePasswordAuthenticationToken auth =
                new UsernamePasswordAuthenticationToken(username, null, null);

        String newAccessToken = jwtTokenProvider.generateAccessToken(auth);

        return LoginResponse.builder()
                .accessToken(newAccessToken)
                .refreshToken(refreshToken)
                .build();
    }

    @Override
    public void forgotPassword(ForgotPasswordRequest request) {
        passwordResetTokenService.createPasswordResetToken(request.getEmail());
    }

    @Override
    public void resetPassword(ResetPasswordRequest request) {
        passwordResetTokenService.resetPassword(request.getToken(), request.getNewPassword());
    }
}
