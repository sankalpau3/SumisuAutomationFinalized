/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Email;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 *
 * @author Deshan
 */
public class Mail {
    
    public void sendMail(String receiver, String sbj, String mes){
        final String from = "sumisupvtltd@gmail.com";
        String to = receiver;
        final String password = new String("sumisu@#123");
        String subject = sbj;
        String body = mes;
        InternetAddress emailFrom = null;
        InternetAddress emailTo = null;
        try {
            emailFrom = new InternetAddress(from);
            emailTo = new InternetAddress(to);
            emailFrom.validate();            
            emailTo.validate();
            if(from.contains("gmail")){
                Properties props = new Properties();
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.starttls.enable", "true");
                props.put("mail.smtp.host", "smtp.gmail.com");
                props.put("mail.smtp.port", "587");
                Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(from, password);
                    }
                });
                final Message message = new MimeMessage(session);
                message.setFrom(emailFrom);
                message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to));
                message.setSubject(subject);
                message.setText(body);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Transport.send(message);
                            JOptionPane.showMessageDialog(null, "Email sent sucessfully");
                        } catch (MessagingException ex) {
                            JOptionPane.showMessageDialog(null, "Failed to send. Check Your Internet Connection");
                        }
                    }
                }).start();
                
                
            }else if(from.contains("yahoo")){
                Properties props = new Properties();
                props.put("mail.smtp.host", "smtp.mail.yahoo.com");
                props.put("mail.stmp.user", from);
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.starttls.enable", "true");
                props.put("mail.smtp.password", password);
                Session session = Session.getDefaultInstance(props, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(from, password);
                }
                });
                MimeMessage msg = new MimeMessage(session);
                msg.setFrom(new InternetAddress(from));
                msg.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(to));
                msg.setSubject(subject);
                msg.setText("yahoo program working...!");
                Transport transport = session.getTransport("smtp");
                transport.send(msg);
                JOptionPane.showMessageDialog(null, "Email Successfully Sent");
            }
        } catch (MessagingException ex) {
            JOptionPane.showMessageDialog(null, "Sending Failed. Check Entered Email Correctly or Your Internet Connection");
        }
    }
}
