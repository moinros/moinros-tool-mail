package com.moinros.project.tool.email.smtp;

import com.moinros.project.tool.email.RosSenderEmail;
import com.moinros.project.tool.email.RunnableEmail;
import com.moinros.project.tool.email.bean.Recipient;
import com.moinros.project.tool.email.bean.Sender;
import com.moinros.project.tool.email.fns.Callback;
import com.moinros.project.tool.email.sub.EmailConfig;

import javax.mail.MessagingException;

public class DefineEmail implements RosSenderEmail {
    private SmtpEmail sm;
    private boolean debug = false;
    private boolean printLog = false;
    private String logPath = null;

    {
        sm = new SmtpEmail();
    }

    @Override
    public boolean send() throws MessagingException {
        if (sm.getSender() == null) {
            EmailConfig cof = EmailConfig.getConfig();
            Sender sender = new Sender();
            sender.setPort(cof.getPort());
            sender.setHost(cof.getHost());
            sender.setSenderFrom(cof.getSenderFrom());
            sender.setSenderName(cof.getSenderName());
            sender.setLoginName(cof.getLoginName());
            sender.setPassword(cof.getPassword());
            sm.isDebug(debug);
            sm.setSender(sender);
        }
        return sm.send();
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
    public void threadSend() {
        threadSend(null, null);
    }

    @Override
    public void threadSend(Callback success, Callback error) {
        RunnableEmail re = new RunnableEmail();
        re.setSuccess(success);
        re.setError(error);
        re.setRosSenderEmail(this);
        Thread thread = new Thread(re);
        thread.start();
    }

    @Override
    public void setSender(Sender sender) {
        sm.setSender(sender);
    }

    @Override
    public void setRecipient(Recipient recipient) {
        sm.setRecipient(recipient);
    }

    @Override
    public void setRecipient(String subject, String email, String content) {
        Recipient recipient = new Recipient();
        recipient.setSubject(subject);
        recipient.setRecipient(email);
        recipient.setContent(content);
        sm.setRecipient(recipient);
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
        System.out.println(printLog);
        System.out.println(logPath);
    }

}
