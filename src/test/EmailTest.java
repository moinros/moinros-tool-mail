package test;

import com.moinros.project.tool.email.RosSenderEmail;
import com.moinros.project.tool.email.sub.EmailConfig;

import javax.mail.MessagingException;

public class EmailTest {

    public static void main(String[] args) throws MessagingException {
        EmailConfig conf = EmailConfig.getConfig();
        conf.setConfigPath("D:/java/config/moinros-config.properties");
        conf.init();

        RosSenderEmail rse = RosSenderEmail.getRosSenderEmail();

        rse.setRecipient("邮件标题", "moinros@qq.com", "邮件的文本内容");
//        rse.isDebug(true);
        rse.threadSend(() -> {
            System.out.println("邮件发送成功时调用");
        }, () -> {
            System.out.println("邮件发送失败时调用");
        });

    }

}
