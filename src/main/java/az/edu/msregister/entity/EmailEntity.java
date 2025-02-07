package az.edu.msregister.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailEntity {
    private String to;
    private String subject;
    private String text;
    private String attachmentPath;

}