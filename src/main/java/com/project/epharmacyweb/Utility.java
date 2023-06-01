package com.project.epharmacyweb;

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
        message.setSubject("Email Confirmation");
        message.setText("Please confirm your email address by clicking the link:\n\n" +
                "http://127.0.0.1:8085/confirm-registration/" + confirmationToken);
        mailSender.send(message);
    }
}
