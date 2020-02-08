package com.moinros.project.tool.email;

import com.moinros.project.tool.email.fns.Callback;

import javax.mail.MessagingException;

/**
 * 注释: 使用多线程的方式发送邮件
 *
 * @Author moinros
 * @WebSite www.moinros.com
 * @Date 2020/2/8 19:51
 * @Verison 1.0
 */
public class RunnableEmail implements Runnable {

	private Callback success = null;
	private Callback error = null;
	private RosSenderEmail sm = null;

	@Override
	public void run() {
	//	System.out.println(">> 开启新的线程  => 开始发送邮件···");
		if (success != null && error != null) {
			try {
				sm.send(success, error);
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		} else {
			try {
				sm.send();
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		}
	}

	public void setSuccess(Callback success) {
		this.success = success;
	}

	public void setError(Callback error) {
		this.error = error;
	}

	public void setRosSenderEmail(RosSenderEmail sm) {
		this.sm = sm;
	}
}
