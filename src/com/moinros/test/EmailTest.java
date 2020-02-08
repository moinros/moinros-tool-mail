package com.moinros.test;

import com.moinros.project.tool.email.RosSenderEmail;
import com.moinros.project.tool.email.smtp.Recipient;
import com.moinros.project.tool.email.smtp.Sender;

import javax.mail.MessagingException;

/**
 * 注释:
 *
 * @Author moinros
 * @WebSite www.moinros.com
 * @Date 2020/2/8 20:36
 * @Verison 1.0
 */
public class EmailTest {

    public static void main(String[] args) throws MessagingException {
        RosSenderEmail rse = RosSenderEmail.getRosSenderEmail();

        Sender sender = new Sender();
        sender.setSenderName("晓默的博客");
        sender.setHost("smtp.qq.com");
        sender.setLoginName("moinros@qq.com");
        sender.setPassword("jtybtqrwxruubgih");
        sender.setPort(443);
        sender.setSenderFrom("moinros@qq.com");
        rse.setSender(sender);

        Recipient recipient = new Recipient();
        recipient.setSubject("测试邮件标题");
        recipient.setRecipient("1959026813@qq.com");
        recipient.setContent("测试邮件的文本内容");

        rse.setRecipient(recipient);

        rse.send(() -> {
            System.out.println("邮件发送成功时调用");
            }, () -> {
            System.out.println("邮件发送失败时调用");
        });
    }

}
