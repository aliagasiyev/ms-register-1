package az.edu.msregister.service;

public interface EmailService {

    void sendEmail(String to, String subject, String text);
}