package com.moinros.project.tool.email.smtp;

/**
 * 注释: 发件人信息
 *
 * @Author moinros
 * @WebSite www.moinros.com
 * @Date 2020/2/8 19:59
 * @Verison 1.0
 */
public class Sender {

    /**
     * 注释: 发送邮件使用的端口号
     */
    private Integer port;

    /**
     * 注释: 发送邮箱的服务器地址
     */
    private String host;

    /**
     * 注释: 发件人的邮箱地址
     */
    private String senderFrom;

    /**
     * 注释: 发件人的昵称
     */
    private String senderName;

    /**
     * 注释: 发件人的邮箱服务器登录名
     */
    private String loginName;

    /**
     * 注释: 邮箱登录密码
     */
    private String password;

    public Sender() {
    }

    /**
     * 注释: 获取 发送邮件使用的端口号
     */
    public Integer getPort() {
        return port;
    }

    /**
     * 注释: 设置 发送邮件使用的端口号
     */
    public void setPort(Integer port) {
        this.port = port;
    }

    /**
     * 注释: 获取 发送邮箱的服务器地址
     */
    public String getHost() {
        return host;
    }

    /**
     * 注释: 设置 发送邮箱的服务器地址
     */
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * 注释: 获取 发件人的邮箱地址
     */
    public String getSenderFrom() {
        return senderFrom;
    }

    /**
     * 注释: 设置 发件人的邮箱地址
     */
    public void setSenderFrom(String senderFrom) {
        this.senderFrom = senderFrom;
    }

    /**
     * 注释: 获取 发件人的昵称
     */
    public String getSenderName() {
        return senderName;
    }

    /**
     * 注释: 设置 发件人的昵称
     */
    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    /**
     * 注释: 获取 发件人的邮箱服务器登录名
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * 注释: 设置 发件人的邮箱服务器登录名
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    /**
     * 注释: 获取 邮箱登录密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 注释: 设置 邮箱登录密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
