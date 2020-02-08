晓默 - Java - 发送邮件的工具类
==========
#### 外部调用接口 ####
    RosSenderEmail
     
#### 初始化 - 配置信息 ####
    // 设置对应参数,也可以通过配置文件的方式自动配置
    RosSenderEmail rse = RosSenderEmail.getRosSenderEmail();
    Sender sender = new Sender();
    rse.setSender(sender);
        
#### 调用方式 #### 
    // 发送邮件时设置好收件人的邮箱,邮件标题，邮件文本即可
    RosSenderEmail rse = RosSenderEmail.getRosSenderEmail();
    rse.setRecipient(subject, email, content);
    // 单线程发送邮件,成功返回true,失败返回false;不推荐使用
    rse.send();
    
    // success 和 error 为回调函数,无参数,无返回值;推荐使用lambda表达式
    // success 邮件发送成功调用,error 邮件发送失败调用，
    rse.send(success, error);
    // 示例
    rse.send(
        () -> { System.out.println("邮件发送成功时调用"); },
        () -> { System.out.println("邮件发送失败时调用"); }
    );
#### 配置文件 ####
*   在项目根目录下创建名为 moinros-config.properties 的配置文件
>       email.host: smtp.qq.com
>       email.port: 443
>       email.sender.from: moinros@qq.com
>       email.sender.name: Project of moinros
>       email.login.name: moinros@qq.com
>       email.login.password: jtybtqrwxruubgih
>       email.debug: false   
    
#### 说明 ####
    RosSenderEmail采用了单例设计模式,
    所以在任何地方都可以使用RosSenderEmail.getRosSenderEmail();
    
#### 其他功能详解 ####
* 开启新的线程发送邮件
    