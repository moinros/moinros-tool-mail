package com.moinros.project.tool.email.smtp;

import com.moinros.project.tool.email.RosSenderEmail;
import com.moinros.project.tool.email.RunnableEmail;
import com.moinros.project.tool.email.fns.Callback;

import javax.mail.MessagingException;

/**
 * 注释:
 *
 * @Author moinros
 * @WebSite www.moinros.com
 * @Date 2020/2/8 19:58
 * @Verison 1.0
 */
public abstract class DefineEmail implements RosSenderEmail {

    protected Sender sender;
    protected Recipient recipient;
    protected boolean debug = true;
    protected boolean printLog = false;
    protected String logPath = null;

    @Override
    public boolean send() throws MessagingException {
        SmtpEmail sm = new SmtpEmail();
        sm.setSender(sender);
        sm.setRecipient(recipient);
        return sm.start();
    }

    @Override
    public boolean send(Callback success, Callback error) throws MessagingException {
        boolean f = send();
        if (f) {
            success.method();
        } else {
            error.method();
        }
        return f;
    }

    @Override
    public void send(RunnableEmail run) {

    }

    @Override
    public void setSender(Sender sender) {
        this.sender = sender;
    }

    @Override
    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }

    @Override
    public void setRecipient(String subject, String email, String content) {
        recipient = new Recipient();
        recipient.setSubject(subject);
        recipient.setRecipient(email);
        recipient.setContent(content);
    }

    @Override
    public void setSubject(String subject) {
        if (recipient == null) {
            recipient = new Recipient();
        }
        recipient.setSubject(subject);
    }

    @Override
    public void setEmail(String email) {
        if (recipient == null) {
            recipient = new Recipient();
        }
        recipient.setRecipient(email);
    }

    @Override
    public void setContent(String content) {
        if (recipient == null) {
            recipient = new Recipient();
        }
        recipient.setContent(content);
    }

    @Override
    public void isDebug(boolean debug) {
        this.debug = debug;
    }

    @Override
    public void isAutoPrintLog(boolean auto) {
        printLog = auto;
    }

    @Override
    public void setLogPath(String path) {
        logPath = path;
    }

    @Override
    public void printLog() {

    }
}
