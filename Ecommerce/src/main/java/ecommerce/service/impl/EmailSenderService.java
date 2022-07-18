package ecommerce.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;

@Slf4j
@Async
@Service
@RequiredArgsConstructor
public class EmailSenderService {

    private final JavaMailSender emailSender;
    private final SpringTemplateEngine templateEngine;

    public void registerEmail(String toEmail,
                              String body,
                              String subject) {

        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper;
        String html = null;

        try {
            helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());

            Context context = new Context();
            context.setVariable("message", body);

            helper.setTo(toEmail);
            helper.setSubject(subject);
            helper.setFrom("ecommerce@gmail.com");

            html = templateEngine.process("email.html", context);
            helper.setText(html, true);

        } catch (MessagingException e) {
            e.printStackTrace();
        }

        log.info("Sending email: {} with html body: {}", body, html);
        emailSender.send(message);

    }
}
