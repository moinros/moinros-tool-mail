package com.moinros.project.tool.email.smtp;

import com.moinros.project.tool.email.bean.Recipient;
import com.moinros.project.tool.email.bean.Sender;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.*;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class SmtpEmail {

	private Sender sender;
	private Recipient recipient;
	private boolean debug;

	private static final String CONTENT_TYPE = "text/html;charset=utf-8";
	private static final String PRO_HOST = "mail.smtp.host";
	private static final String PRO_PORT = "mail.smtp.port";
	private static final String PRO_AUTH = "mail.smtp.auth";
	private static final String PRO_SOCKET_FACTORY = "mail.smtp.socketFactory.class";
	private static final String PRO_SSL_SOCKET_FACTORY = "javax.net.ssl.SSLSocketFactory";

	public boolean send() throws MessagingException {
		// 创建 Properties 对象;设置发送邮件的邮件服务器属性
		Properties props = new Properties();
		// 设置发送邮件的端口号;默认为25
		props.put(PRO_PORT, sender.getPort());
		props.put(PRO_HOST, sender.getHost());
		props.put(PRO_AUTH, true);
		props.put(PRO_SOCKET_FACTORY, PRO_SSL_SOCKET_FACTORY);

		// 使用 Properties 对象构建一个 Session
		Session session = Session.getDefaultInstance(props);
		// 是否开启调试模式
		session.setDebug(debug);
		// 将 Session 作为参数 定义消息对象
		MimeMessage me = new MimeMessage(session);
		try {
			// 对于非us - ascii字符，将检查给定的Unicode字符串。如果字符串只包含US-ASCII字符，则按原样返回。
			sender.setSenderName(javax.mail.internet.MimeUtility.encodeText(sender.getSenderName()));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return false;
		}

		// 加载发件人昵称和地址
		me.setFrom(new InternetAddress(sender.getSenderName() + "<" + sender.getSenderFrom() + ">"));
		// 加载收件人地址
		try {
			me.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient.getRecipient()));
		} catch (MessagingException e) {
			e.printStackTrace();
			return false;
		}
		// 加载邮件标题
		me.setSubject(recipient.getSubject());

		// 向 Multipart 对象中添加邮件的配置信息;包括文本内容
		Multipart multipart = new MimeMultipart();
		// 设置邮件的文本内容
		BodyPart contentPart = new MimeBodyPart();
		// 设定邮件内容的类型为 text/plain 或 text/html
		contentPart.setContent(recipient.getContent(), CONTENT_TYPE);
		multipart.addBodyPart(contentPart);
		// 将 Multipart 对象放入 MimeMessage
		me.setContent(multipart);
		// 保存邮件
		me.saveChanges();

		// 开始发送邮件
		Transport.send(me, sender.getLoginName(), sender.getPassword());
		return true;
	}

	public Sender getSender() {
		return sender;
	}

	public void setSender(Sender sender) {
		this.sender = sender;
	}

	public Recipient getRecipient() {
		return recipient;
	}

	public void setRecipient(Recipient recipient) {
		this.recipient = recipient;
	}

	public void isDebug(boolean debug) {
		this.debug = debug;
	}

}
