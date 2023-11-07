package com.universal.system.service.impl;

import com.sun.mail.smtp.SMTPSendFailedException;
import com.universal.system.common.exception.UniversalException;
import com.universal.system.common.result.HttpStatus;
import com.universal.system.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @author 姓陈的
 * 2023/11/6 20:54
 */
@Service
public class EmailServiceImpl implements EmailService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private JavaMailSender javaMailSender;

    //注入配置文件中配置的信息——>from
    @Value("${spring.mail.username}")
    private String from;

    @Override
    public void sendSimpleMail(String to, String subject, String content) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            //发件人
            message.setFrom(from);
            //收件人
            message.setTo(to);
            //邮件主题
            message.setSubject(subject);
            //邮件内容
            message.setText(content);
            //发送邮件
            javaMailSender.send(message);
        } catch (MailException e) {
            logger.error("发送邮件时发生异常："+e);
            throw new UniversalException(HttpStatus.ERROR,"邮件发送异常，请检查您的邮箱格式");
        }
    }

    @Override
    public void sendHtmlMail(String to, String subject, String content) {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper;
        try {
            messageHelper = new MimeMessageHelper(message,true);
            messageHelper.setFrom(from);
            messageHelper.setTo(to);
            message.setSubject(subject);
            messageHelper.setText(content,true);
            javaMailSender.send(message);
            logger.info("邮件已经发送！");
        } catch (Exception e) {
            logger.error("异常："+e);
            System.out.println("--------------------------------------------------发生异常");
            if(e instanceof SMTPSendFailedException){
                System.out.println("-----------SMTPSendFailedException---------------------------------------发生异常");
                throw new UniversalException(HttpStatus.ERROR,"邮件发送异常，请检查您的邮箱格式");
            }else{
                throw new UniversalException(HttpStatus.ERROR,"邮件发送失败");
            }
        }
    }

    @Override
    public void sendAttachmentsMail(String to, String subject, String content, String filePath) {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper;
        try {
            messageHelper = new MimeMessageHelper(message,true);
            messageHelper.setFrom(from);
            messageHelper.setTo(to);
            messageHelper.setSubject(subject);
            messageHelper.setText(content,true);
            //携带附件
            FileSystemResource file = new FileSystemResource(filePath);
            String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
            messageHelper.addAttachment(fileName,file);

            javaMailSender.send(message);
            logger.info("邮件加附件发送成功！");
        } catch (MessagingException e) {
            logger.error("发送失败："+e);
        }
    }

}
