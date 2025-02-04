package az.edu.msregister.controller;

import az.edu.msregister.config.JwtTokenProvider;
import az.edu.msregister.dto.request.LoginRequest;
import az.edu.msregister.dto.request.RefreshRequest;
import az.edu.msregister.dto.response.LoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    /**
     * Kullanıcı login olur: email + password
     * AccessToken + RefreshToken döner
     */
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        // 1) Kimlik doğrulama
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );

        // 2) Tokenları üret
        String accessToken = jwtTokenProvider.generateAccessToken(authentication);
        String refreshToken = jwtTokenProvider.generateRefreshToken(authentication);

        // 3) JSON olarak döndür
        LoginResponse loginResponse = LoginResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();

        return ResponseEntity.ok(loginResponse);
    }

    /**
     * Access token süresi bitince, valid refresh token ile yeni bir access token alınır.
     */
    @PostMapping("/refresh")
    public ResponseEntity<LoginResponse> refreshToken(@RequestBody RefreshRequest refreshRequest) {
        String refreshToken = refreshRequest.getRefreshToken();

        // 1) Refresh token geçerli mi kontrol et
        if (!jwtTokenProvider.validateToken(refreshToken)) {
            return ResponseEntity.badRequest().build(); // veya custom hata
        }

        // 2) Refresh token'dan username'i al
        String username = jwtTokenProvider.getUsernameFromToken(refreshToken);

        // 3) Yeni access token üret. İstersen tekrar DB’den userDetails al
        //    Basitçe bir authentication objesi oluşturabiliriz:
        UsernamePasswordAuthenticationToken auth =
                new UsernamePasswordAuthenticationToken(username, null, null);

        String newAccessToken = jwtTokenProvider.generateAccessToken(auth);

        // refresh token’ı her seferinde yenilemek istiyorsan burda generateRefreshToken(auth) çağırabilirsin.
        LoginResponse response = LoginResponse.builder()
                .accessToken(newAccessToken)
                .refreshToken(refreshToken) // ya da yeni refresh token
                .build();

        return ResponseEntity.ok(response);
    }
}
