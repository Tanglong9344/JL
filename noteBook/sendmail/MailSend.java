import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;

/** jar地址：https://mvnrepository.com/artifact/javax.mail/mail/1.5.0-b01 */
public class MailSend {
    private String from     = ""; // 发件人地址
    private String to       = ""; // 收件人地址
    private String subject  = ""; // 邮件标题

    /**  设置邮件地址 */
    public void setAddress(String from,String to,String subject) {
        this.from = from;
        this.to   = to;
        this.subject = subject;
    }

    /** 发送邮件 */
    public void send(String host, String user,String authCode) {
        Properties props = new Properties();
        props.put("mail.smtp.host", host);  //邮箱服务器
        props.put("mail.smtp.auth", "true");//授权
        // 显示信息

        Session session = Session.getDefaultInstance(props);
        session.setDebug(true);

        MimeMessage message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            //邮件正文
            Multipart multipart = new MimeMultipart();
            BodyPart contentPart = new MimeBodyPart();
            contentPart.setText("邮件正文：Hello Mail.");
            multipart.addBodyPart(contentPart);
            message.setContent(multipart);
            message.saveChanges();

            //发送
            Transport transport = session.getTransport("smtp");
            transport.connect(host,user,authCode);//使用授权码登录
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
