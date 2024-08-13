package com.yezebi.pinpin.kaizoku.service;

import com.google.firebase.auth.FirebaseAuth;
import com.yezebi.pinpin.kaizoku.config.AppProperties;
import com.yezebi.pinpin.kaizoku.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import templates.PasswordReset;

@Slf4j
@Service
@RequiredArgsConstructor
public class MailingService {
    private final AppProperties properties;
    private final FirebaseAuth firebaseAuth;
    private final JavaMailSender mailSender;

    public void sendEmailVerification(final User user) {
        final var content = PasswordReset.render();

        send(content, "", user.getEmail());
    }

    public void sendPasswordReset(final User user) {
        final var content = PasswordReset.render();

        send(content, "", user.getEmail());
    }

    private void send(final String content, final String subject, final String email) {
        try {
            final var message = new SimpleMailMessage();
            message.setTo(email);
            message.setSubject("${properties.email.name} - $subject");
            message.setText(content);

            mailSender.send(message);
        } catch (MailException e) {
            log.error("Cannot send email", e);
        }
    }
}
