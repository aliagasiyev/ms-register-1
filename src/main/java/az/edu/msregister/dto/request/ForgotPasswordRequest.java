package az.edu.msregister.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ForgotPasswordRequest {
    @NotBlank(message = "Email boş ola bilməz")
    @Email(message = "Düzgün email ünvanı daxil edin")
    private String email;
}
