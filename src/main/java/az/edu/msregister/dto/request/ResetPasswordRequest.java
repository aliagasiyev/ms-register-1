package az.edu.msregister.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResetPasswordRequest {
    @NotBlank(message = "Token boş ola bilməz")
    private String token;

    @NotBlank(message = "Yeni şifrə boş ola bilməz")
    private String newPassword;
}
