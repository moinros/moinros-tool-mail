package com.moinros.project.tool.email;

import com.moinros.project.tool.email.fns.Callback;
import com.moinros.project.tool.email.smtp.Recipient;
import com.moinros.project.tool.email.smtp.Sender;

import javax.mail.MessagingException;

/**
 * 类注释: 发送邮件的顶级接口
 *
 * @Author moinros
 * @Date 2020/2/8 19:46
 * @Version 1.0
 */
public interface RosSenderEmail {

    /**
     * 静态方法获取RosSenderEmail的实例对象
     *
     * @return RosSenderEmail实例
     */
    public static RosSenderEmail getRosSenderEmail() {
        return null;
    }

    /**
     * 发送邮件
     *
     * @return boolean 成功返回true, 失败返回false
     */
    boolean send() throws MessagingException;

    /**
     * 发送邮件
     *
     * @param success 回调函数-邮件发送成功时调用
     * @param error   回调函数-邮件发送失败时调用
     * @return boolean 成功返回true, 失败返回false
     */
    boolean send(Callback success, Callback error) throws MessagingException;

    /**
     * 开启新的线程发送邮件
     *
     * @param run 多线程发送邮件接口实现
     */
    void send(RunnableEmail run);

    /**
     * 设置发件人信息
     *
     * @param sender 发件人信息
     */
    void setSender(Sender sender);

    /**
     * 设置收件人信息
     *
     * @param recipient 收件人信息
     */
    void setRecipient(Recipient recipient);

    /**
     * 注释: 设置邮件信息
     *
     * @param subject 邮件标题
     * @param email   收件人邮箱
     * @param content 邮件内容
     */
    void setRecipient(String subject, String email, String content);

    /**
     * 注释: 设置 邮件标题
     *
     * @param subject 邮件标题
     */
    void setSubject(String subject);

    /**
     * 注释: 设置 收件人邮箱
     *
     * @param email 收件人邮箱
     */
    void setEmail(String email);

    /**
     * 注释: 设置 邮件内容
     *
     * @param content 邮件内容
     */
    void setContent(String content);

    /**
     * 注释: 是否开启debug模式?默认true,开启debug
     *
     * @param debug 是否开启debug
     */
    void isDebug(boolean debug);

    /**
     * 注释: 设置是否自动打印日志
     *
     * @param auto 默认为true, 当指定了日志文件路径后,会根据日志打印级别自动打印日志
     */
    void isAutoPrintLog(boolean auto);

    /**
     * 注释: 设置日志文件路径
     *
     * @param path 文件路径
     */
    void setLogPath(String path);

    /**
     * 注释: 打印日志
     */
    void printLog();

}
