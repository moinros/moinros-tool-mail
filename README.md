晓默 - Java 发送邮件的工具包
==========
### 外部调用 - API ###
* #### 包结构 ####
>       com.moinros.project.tool.email.RosSenderEmail
>       com.moinros.project.tool.email.RunnableEmail
>       com.moinros.project.tool.email.fns.Callback
>       com.moinros.project.tool.email.sub.EmailConfig
>       com.moinros.project.tool.email.sub.ReadHtmlFile
>       com.moinros.project.tool.email.smtp.DefineEmail
>       com.moinros.project.tool.email.smtp.SmtpEmail
>       com.moinros.project.tool.email.bean.Sender
>       com.moinros.project.tool.email.bean.Recipient 
* #### 初始化 - 配置信息 ####
>       EmailConfig conf = EmailConfig.getConfig();
>    
>       // 自定义配置文件路径,默认[moinros-config.properties],
>       conf.setConfigPath("文件路径");
>
>       // 通过读取本地配置文件初始化参数
>       conf.init();
>
>       // 也可以直接通过代码配置
>       conf.setPort(25);
>       conf.setHost("smtp.qq.com");
>       conf.setLoginName("账号");
>       conf.setPassword("密码");
>       conf.setSenderFrom("邮箱");
>       conf.setSenderName("晓默的博客");     
* #### 设置参数 ####
>       // 通过静态方法创建 RosSenderEmail 的实例
>       RosSenderEmail rse = RosSenderEmail.getRosSenderEmail();
>
>       // 设置邮件参数 - 方式一
>       Recipient recipient = new Recipient();
>       recipient.setSubject("测试邮件标题");
>       recipient.setRecipient("1959026813@qq.com");
>       recipient.setContent("测试邮件的文本内容");
>       rse.setRecipient(recipient);
>   
>       // 设置邮件参数 - 方式二
>       rse.setRecipient(subject, email, content);
* #### 发送邮件 ####
>       // 邮件参数设置完成后调用send方法发送邮件
>    
>       // 单线程发送邮件,成功返回true,失败返回false;不推荐使用
>       rse.send();
>    
>       // 单线程发送邮件,成功返回true,失败返回false;不推荐使用
>       rse.send(success, error);
>    
>       // 开启新的线程发送邮件,无返回值
>       rse.threadSend();
>    
>       // 开启新的线程发送邮件,无返回值
>       rse.threadSend(success, error);
>    
>       // success 和 error 为回调函数,无参数,无返回值;推荐使用lambda表达式
>       // 示例
>       rse.send(
>           () -> { System.out.println("邮件发送成功时调用"); },
>           () -> { System.out.println("邮件发送失败时调用"); }
>       ); 
* #### 测试示例 ####
>       EmailConfig conf = EmailConfig.getConfig();
>       conf.init();
>
>       RosSenderEmail rse = RosSenderEmail.getRosSenderEmail();
>       Recipient recipient = new Recipient();
>       recipient.setSubject("邮件标题");
>       recipient.setRecipient("收件人邮箱");
>       recipient.setContent("邮件文本");
>       rse.setRecipient(recipient);
>        
>       rse.threadSend(() -> {
>           System.out.println("邮件发送成功时调用");
>       }, () -> {
>           System.out.println("邮件发送失败时调用");
>       });	
* #### 配置文件 ####
    *   在项目根目录下创建名为 moinros-config.properties 的配置文件
>       email.host: smtp.qq.com
>       email.port: 25
>       email.sender.from: moinros@qq.com
>       email.sender.name: Project of moinros
>       email.login.name: moinros@qq.com
>       email.login.password: jtybtqrwxruubgih
* #### 依赖的jar包 ####
>       javax.mail-1.6.2.ajr 
>       commons-email-1.5.jar
>       activation-1.1.1.jar
> + [javax.mail-1.6.2.ajr - 传送门](https://mvnrepository.com/artifact/com.sun.mail/javax.mail)
> + [commons-email-1.5.jar - 传送门](https://mvnrepository.com/artifact/org.apache.commons/commons-email)
> + [activation-1.1.1.jar - 传送门](https://mvnrepository.com/artifact/javax.activation/activation)
* #### 其他功能详解 ####
>       // ReadHtmlFile // 读取HTML文件模板工具类
>       // 指定HTML模板路径读取HTML模板
>       ReadHtmlFile.getHtmlTemplate("htmlPath");
>
>       // 私有方法,读取HTML实现 
>       ReadHtmlFile.readHtmlFile("htmlPath");
>
>       // 指定HTML模板路径读取HTML模板,并替换其中的动态参数
>       ReadHtmlFile.readHtmlFile(htmlPath, params);
>
>       // 替换指定HTML模板的动态参数
>       ReadHtmlFile.replaceHtmlTemplate(html, params);
>
>       // params 为Map类型
>       // 通过指定 key, value 的形式指定动态参数
>       // 例: HTML模板占位符为: ${code}
>       params.put("${code}", "666666");
>       params.put("${id}", "2333");
----------