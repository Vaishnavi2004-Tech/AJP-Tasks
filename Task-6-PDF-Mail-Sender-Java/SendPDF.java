import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class SendPDF {

    public static void main(String[] args) {

        String sender = "vaishnavimanju023@gmail.com";
        String password = "ebrm sqvc snmw veis";

        String receiver = "vaishnavisup@gmail.com";

        try {

            Properties prop = new Properties();

            prop.put(
                "mail.smtp.host",
                "smtp.gmail.com");

            prop.put(
                "mail.smtp.port",
                "587");

            prop.put(
                "mail.smtp.auth",
                "true");

            prop.put(
                "mail.smtp.starttls.enable",
                "true");

            Session session =
                Session.getInstance(
                    prop,
                    new Authenticator() {

                protected
                PasswordAuthentication
                getPasswordAuthentication() {

                    return new
                    PasswordAuthentication(
                        sender,
                        password);
                }
            });

            Message msg =
                new MimeMessage(session);

            msg.setFrom(
                new InternetAddress(sender));

            msg.setRecipients(
                Message.RecipientType.TO,
                InternetAddress.parse(
                    receiver));

            msg.setSubject(
                "PDF From Java");

            // Text Part
            MimeBodyPart textPart =
                new MimeBodyPart();

            textPart.setText(
                "Hello Sir, PDF Attached.");

            // PDF Attachment Part
            MimeBodyPart pdfPart =
                new MimeBodyPart();

            pdfPart.attachFile(
                "D:\\pdf_project\\MyPDF.pdf");

            // Combine
            Multipart multipart =
                new MimeMultipart();

            multipart.addBodyPart(
                textPart);

            multipart.addBodyPart(
                pdfPart);

            msg.setContent(
                multipart);

            Transport.send(msg);

            System.out.println(
                "PDF Email Sent!");

        }

        catch(Exception e) {

            System.out.println(e);
        }
    }
}