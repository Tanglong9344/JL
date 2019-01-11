/**
 * POP3服务器: pop.163.com
 * SMTP服务器: smtp.163.com
 * IMAP服务器: imap.163.com
 */

public class Main {
    public static void main(String[] args) {
        String from = "";//发送的邮箱地址
        String to   = "";//接收的邮箱地址
        String subject = "第一封邮件";
        String host = "smtp.163.com";//网易smtp邮箱服务器
        String user = "";//登录名
        String authCode = "";//授权码

        MailSend ms = new MailSend();
        ms.setAddress(from,to,subject);
        ms.send(host,user,authCode);
    }
}
