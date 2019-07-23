package model;

import view.FrameException;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Transport;
import javax.mail.internet.*;
import javax.swing.*;
import java.io.File;
import java.util.Map;

public class MessageEMAIL extends MimeMessage {
    private  Map<String, String> settings = Settings.getSettings();
    public MessageEMAIL(String text, File file) {
        super(SessionEMAIL.getSession());
        System.out.println("text - "+ text);
       /* try {
            this.setFrom(new InternetAddress(settings.get("eMailFrom")));
            this.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(settings.get("eMailTo")));
            this.setSubject("Сообщение об ошибке");
            this.setText(text);
            Transport.send(this);
        } catch (MessagingException e) {
            e.printStackTrace();
            JFrame myWindow = new FrameException(" Ошибка отправки сообщения !!!");
            Settings.writeError(e);
        }
 */



     MimeBodyPart messageBodyPart = new MimeBodyPart();

        Multipart multipart = new MimeMultipart();

        messageBodyPart = new MimeBodyPart();
        DataSource source = new FileDataSource(file);
        try {
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(file.getName());
            messageBodyPart.setText(text);
            multipart.addBodyPart(messageBodyPart);
            this.setContent(multipart);


            this.setFrom(new InternetAddress(settings.get("eMailFrom")));
            this.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(settings.get("eMailTo")));
            this.setSubject("Сообщение об ошибке");
            //this.setText(text);
            Transport.send(this);
        } catch (MessagingException e) {
            e.printStackTrace();
        }



    }
}
