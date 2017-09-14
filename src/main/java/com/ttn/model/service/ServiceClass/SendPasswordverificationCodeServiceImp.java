package com.ttn.model.service.ServiceClass;

import com.ttn.model.dao.ForgotPasswordDao;
import com.ttn.model.service.ServiceInterface.SendPasswordVerificationCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Random;

/**
 * Created by user on 7/13/2017.
 */
@Service
public class SendPasswordverificationCodeServiceImp implements SendPasswordVerificationCodeService {
    @Autowired
    ForgotPasswordDao forgotPasswordDao;

    public boolean checkemailid(String emailenteredbyuser) {
        return forgotPasswordDao.checkemailid(emailenteredbyuser);
    }

    public String sendVerificationCode(String useremail) {
        String host = "localhost";
        final String user = "vermasahil269@gmail.com";//change accordingly
        final String password = "sahil@21";//change accordingly

        String to = useremail;//change accordingly

        //Get the session object
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port","465");
        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port","465");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(user, password);
                    }
                });

        //Compose the message
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("verification code");
            String code=getRandomString();
            message.setText(code);

            //send the message
            Transport.send(message);


      forgotPasswordDao.insertVerificationCode(useremail,code);
            return "message sent successfully...";

        } catch (MessagingException e) {
            e.printStackTrace();
            return "error";
        }
    }
    protected String getRandomString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 5) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String randomStr = salt.toString();
        return randomStr;
    }
}

