package com.myitconfig.gitdemo.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
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
    private static final Logger log = LoggerFactory.getLogger(JavaMailComponent.class);
    private @Value("${email.model.name}")
    String template; //绑定一个ftl模板
    private final FreeMarkerConfigurer freeMarkerConfigurer;
    private final JavaMailSender javaMailSender;
    private final MailProperties mailProperties;

    public JavaMailComponent(FreeMarkerConfigurer freeMarkerConfigurer, JavaMailSender javaMailSender, MailProperties mailProperties) {
        this.freeMarkerConfigurer = freeMarkerConfigurer;
        this.javaMailSender = javaMailSender;
        this.mailProperties = mailProperties;
    }

    /**
     * @param email 传入一个邮箱地址
     */
    public void sendMail(String email) {
        Map<String, Object> map = new HashMap<>();
        map.put("email", email);
        try {
            String text = this.getTextByTemplate(template, map); // 获取.ftl模板
            this.send(email, text); // 将信息和模板传入send方法处理
            log.warn("发送成功!");
        } catch (Exception e) {
            e.printStackTrace();
            log.warn("发送失败!");
        }
    }

    /**
     * @param template 这是邮件模板.ftl
     * @param model    这是要给model
     * @return 返回的模板
     * @throws Exception 抛出异常
     */
    private String getTextByTemplate(String template, Map<String, Object> model) throws Exception {
        return FreeMarkerTemplateUtils.processTemplateIntoString(this.freeMarkerConfigurer.getConfiguration().getTemplate(template), model);
    }

    /**
     * @param email email地址
     * @param text  模板
     * @throws MessagingException           异常
     * @throws UnsupportedEncodingException 异常
     */
    private void send(String email, String text) throws MessagingException, UnsupportedEncodingException {
        MimeMessage message = this.javaMailSender.createMimeMessage();//创建信息
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");//格式化信息
        InternetAddress from = new InternetAddress();  //设置发件人标签
        from.setAddress(this.mailProperties.getUsername());//发件人邮箱地址
        from.setPersonal("少不经事", "UTF-8");//发件人昵称
        helper.setFrom(from); //添加标签
        helper.setTo(email); //添加收件人
        helper.setSubject("你好耿志"); //添加主题
        helper.setText(text, true); //添加模板
        this.javaMailSender.send(message); //发送信息
    }
}
