package com.moinros.test;

import com.moinros.project.tool.email.RosSenderEmail;
import com.moinros.project.tool.email.bean.Recipient;
import com.moinros.project.tool.email.sub.EmailConfig;

import javax.mail.MessagingException;

public class EmailTest {

	public static void main(String[] args) throws MessagingException {
		EmailConfig conf = EmailConfig.getConfig();
		conf.init();

		RosSenderEmail rse = RosSenderEmail.getRosSenderEmail();

		Recipient recipient = new Recipient();
		recipient.setSubject("测试邮件标题");
		recipient.setRecipient("1959026813@qq.com");
		recipient.setContent("测试邮件的文本内容");
		rse.setRecipient(recipient);

		rse.threadSend(() -> {
			System.out.println("邮件发送成功时调用");
		}, () -> {
			System.out.println("邮件发送失败时调用");
		});

	}

}
