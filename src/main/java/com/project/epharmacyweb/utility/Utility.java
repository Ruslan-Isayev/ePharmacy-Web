package com.project.epharmacyweb.utility;

import com.project.epharmacyweb.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Utility {

    private final JavaMailSender mailSender;

    public void sendConfirmationEmail(User user) {
        SimpleMailMessage message = new SimpleMailMessage();
        String confirmationToken = user.getConfirmationToken();
        message.setTo(user.getEmail());
        String link = "http://127.0.0.1:8085/confirm-registration/";
        message.setSubject("Email Confirmation");
        message.setText("Please confirm your email address by clicking the link:\n\n" +
                link + confirmationToken);
        mailSender.send(message);
    }
}
