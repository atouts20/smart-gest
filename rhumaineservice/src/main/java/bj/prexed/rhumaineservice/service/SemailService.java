package bj.prexed.rhumaineservice.service;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;

import java.util.Date;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;
@Service
public class SemailService {
    @Autowired
    private Environment env; //@Value("${spring.mail.username}") private String propertieMail;

    @Autowired
    private JavaMailSender sender;

    private ExecutorService executor = Executors.newSingleThreadExecutor();

    private static final String HTML_TAG_PATTERN = ".*\\<[^>]+>.*"; //"<(\"[^\"]*\"|'[^']*'|[^'\">])*>";

    public void sendText(String to, String subject, String content) throws MailException {
        final SimpleMailMessage message = constructEmailSimple(to,subject, content, env.getProperty("spring.mail.username")); //final MimeMessagePreparator message = constructEmailMessage(to, subject, content);
        executor.submit(() -> sender.send(message));
    }

    public void sendText(String to, String subject, String content, Optional<String> from) throws MailException {
        final SimpleMailMessage message = constructEmailSimple(to,subject, content, from.orElse(env.getProperty("spring.mail.username"))); //final MimeMessagePreparator message = constructEmailMessage(to, subject, content);
        executor.submit(() -> sender.send(message));
    }

    public void sendHtml(String to, String subject, String content) {
        final MimeMessagePreparator message = constructEmailMessage(to, subject, content, env.getProperty("spring.mail.username"), "L'équipe technique de SYM GESTION");
        executor.submit(() -> sender.send(message));
    }

    public void sendHtml(String to, String subject, String content, String from, String personal) {
        final MimeMessagePreparator message = constructEmailMessage(to, subject, content, from, personal);
        executor.submit(() -> sender.send(message));
    }

    private MimeMessagePreparator constructEmailMessage(String to, final String subject, String content, String from, String personal) {
        Pattern pattern = Pattern.compile(HTML_TAG_PATTERN, Pattern.DOTALL);
        return mimeMessage -> {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "utf-8");//helper.addAttachment("my_photo.png", new ClassPathResource("android.png"));//FileSystemResource file = new FileSystemResource(new File("path/android.png"));
            helper.setFrom(from, personal);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, pattern.matcher(content).matches());
            helper.setSentDate(new Date());
        };
    }

    private SimpleMailMessage constructEmailSimple(String to, String subject, String content, String from) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(from);
        message.setSubject(subject);
        message.setText(content);
        message.setTo(to);
        return message;
    }
}

