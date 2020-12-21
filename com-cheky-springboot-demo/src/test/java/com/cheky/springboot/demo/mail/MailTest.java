package com.cheky.springboot.demo.mail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @author Cheky
 * @date 2020-12-21
 */
@SpringBootTest
public class MailTest {
    @Autowired
    private JavaMailSenderImpl mailSender;

    @Test
    public void testSendMail() throws MessagingException {
        //简单邮件
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("chekyyao@aliyun.com");
        simpleMailMessage.setTo("13925568211@163.com");
        simpleMailMessage.setSubject("Mail Test");
        simpleMailMessage.setText("Just do it");
        mailSender.send(simpleMailMessage);
    }

    @Test
    public void testSendMailWithAttachment() throws MessagingException {
        //复杂邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
        messageHelper.setFrom("chekyyao@aliyun.com");
        messageHelper.setTo("13925568211@163.com");
        messageHelper.setSubject("Mail Test2");
        messageHelper.setText("Just do it！！！");
        messageHelper.addInline("sample.jpg", new File("demo/sample.jpg"));
        messageHelper.addAttachment("sample.xml", new File("demo/sample.xml"));
        mailSender.send(mimeMessage);
    }
}