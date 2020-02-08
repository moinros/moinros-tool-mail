package com.moinros.project.tool.email.smtp;

/**
 * 注释: 收件人信息
 *
 * @Author moinros
 * @WebSite www.moinros.com
 * @Date 2020/2/8 20:00
 * @Verison 1.0
 */
public class Recipient {
    /**
     * 注释: 收件人邮箱
     */
    private String recipient;

    /**
     * 注释: 邮件标题
     */
    private String subject;

    /**
     * 注释: 要发送的邮件文本内容
     */
    private String content;

    public Recipient() {
    }

    /**
     * 注释: 获取 收件人邮箱
     */
    public String getRecipient() {
        return recipient;
    }

    /**
     * 注释: 设置 收件人邮箱
     */
    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    /**
     * 注释: 获取 邮件标题
     */
    public String getSubject() {
        return subject;
    }

    /**
     * 注释: 设置 邮件标题
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * 注释: 获取 要发送的邮件文本内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 注释: 设置 要发送的邮件文本内容
     */
    public void setContent(String content) {
        this.content = content;
    }

}
