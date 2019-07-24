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
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        Multipart multipart = new MimeMultipart();

        DataSource source = new FileDataSource(file);
        MimeBodyPart textBodyPart = new MimeBodyPart();
        try {
            textBodyPart.setText(text);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(file.getName());
            multipart.addBodyPart(messageBodyPart);
            multipart.addBodyPart(textBodyPart);  // add the text part
            this.setContent(multipart);


            this.setFrom(new InternetAddress(settings.get("eMailFrom")));
            this.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(settings.get("eMailTo")));
            this.setSubject("Сообщение об ошибке");

            Transport.send(this);
        } catch (MessagingException e) {

            JFrame myWindow = new FrameException(" Отсутствует файл  отправки сообщения!!!");
            Settings.writeError(e);
            e.printStackTrace();
        }



    }
}
