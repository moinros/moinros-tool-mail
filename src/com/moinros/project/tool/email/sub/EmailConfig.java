package com.moinros.project.tool.email.sub;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

/**
 * 邮件的配置文件类
 */
public class EmailConfig {

    private EmailConfig() {
    }

    private static final EmailConfig CONFIG = new EmailConfig();

    public static EmailConfig getConfig() {
        return CONFIG;
    }

    private boolean flag = true;

    /**
     * CONFIG_FILE_NAME : 配置文件路径
     */
    private String configPath = "moinros-config.properties";
    private int port;
    private String host;
    private String senderFrom;
    private String senderName;
    private String loginName;
    private String password;
    private boolean debug;

    /**
     * 注释: 初始化配置参数
     */
    public void init() {
        if (flag) {
            flag = false;
            // 读取自定义的全局配置文件;获取项目的全局配置信息
            InputStream is = EmailConfig.class.getClassLoader().getResourceAsStream(configPath);
            if (is != null) {
                try {
                    Properties config = new Properties();
                    config.load(new InputStreamReader(is, "UTF-8"));
                    port = (Integer.parseInt(config.getProperty("email.port")));
                    host = config.getProperty("email.host");
                    senderFrom = (config.getProperty("email.sender.from"));
                    senderName = (config.getProperty("email.sender.name"));
                    loginName = (config.getProperty("email.login.name"));
                    password = (config.getProperty("email.login.password"));
                    String de = config.getProperty("email.debug");
                    debug = de == null ? false : Boolean.parseBoolean(de);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    if (is != null) {
                        is.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                throw new RuntimeException("没有找到配置文件！请在项目根目录下创建名为[" + configPath + "]的文件");
            }
        }
    }

    public String getConfigPath() {
        return configPath;
    }

    public void setConfigPath(String configPath) {
        this.configPath = configPath;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getSenderFrom() {
        return senderFrom;
    }

    public void setSenderFrom(String senderFrom) {
        this.senderFrom = senderFrom;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getDebug() {
        return debug;
    }

    public void isDebug(boolean debug) {
        this.debug = debug;
    }
}
