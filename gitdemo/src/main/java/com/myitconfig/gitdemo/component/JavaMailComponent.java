package com.myitconfig.gitdemo.component;

import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

@Component
@EnableConfigurationProperties(MailProperties.class)
public class JavaMailComponent {
    //绑定一个ftl模板
    private static final String template = "mail.ftl";

    private final FreeMarkerConfigurer freeMarkerConfigurer;

    private final JavaMailSender javaMailSender;

    private final MailProperties mailProperties;

    public JavaMailComponent(FreeMarkerConfigurer freeMarkerConfigurer, JavaMailSender javaMailSender, MailProperties mailProperties) {
        this.freeMarkerConfigurer = freeMarkerConfigurer;
        this.javaMailSender = javaMailSender;
        this.mailProperties = mailProperties;
    }

    /**
     * 传入参数
     * @param email
     */
    public void sendMail(String email) {
        Map<String, Object> map = new HashMap<>();
        map.put("email", email);
        try {
            // 获取.ftl模板
            String text = this.getTextByTemplate(template, map);
            // 将信息和模板传入send方法处理
            this.send(email, text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取发送的模板
     * @param template
     * @param model
     * @return
     * @throws Exception
     */
    private String getTextByTemplate(String template, Map<String, Object> model) throws Exception {
        return FreeMarkerTemplateUtils
                .processTemplateIntoString(this.freeMarkerConfigurer.getConfiguration().getTemplate(template), model);
    }

    /**
     * 将模板和邮件信息存放并发送
     * @param email
     * @param text
     * @throws MessagingException
     * @throws UnsupportedEncodingException
     */
    private void send(String email, String text) throws MessagingException, UnsupportedEncodingException {
        //创建并格式化信息
        MimeMessage message = this.javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
        //设置发件人标签
        InternetAddress from = new InternetAddress();
        from.setAddress(this.mailProperties.getUsername());
        from.setPersonal("Java记", "UTF-8");
        //添加标签
        helper.setFrom(from);
        //添加收件人
        helper.setTo(email);
        //添加主题
        helper.setSubject("SpringBoot 发送的第二封邮件");
        //添加模板
        helper.setText(text, true);
        //发送信息
        this.javaMailSender.send(message);
    }
}
