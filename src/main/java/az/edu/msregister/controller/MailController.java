package az.edu.msregister.controller;

import az.edu.msregister.entity.EmailEntity;
import az.edu.msregister.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MailController {

    private final EmailService mailService;

    @PostMapping("/send-email")
    public String sendEmail(@RequestBody EmailEntity emailRequest) {
        mailService.sendEmail(emailRequest.getTo(), emailRequest.getSubject(), emailRequest.getText());
        return "Email sent successfully!";
    }

}