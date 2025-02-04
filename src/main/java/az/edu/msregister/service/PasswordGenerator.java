package az.edu.msregister.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "adminPassword"; // Your desired password
        System.out.println(encoder.encode(rawPassword));
    }
}
