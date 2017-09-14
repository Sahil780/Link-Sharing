package com.ttn.model.service.ServiceClass;

import com.ttn.model.service.ServiceInterface.SendInvitationOfTopicService;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Random;

/**
 * Created by user on 7/19/2017.
 */
@Service
public class SendInvitationOfTopicServiceImp implements SendInvitationOfTopicService {
    public String sendInvitation(String email, String topicname) {
        String host = "localhost";
        final String user = "vermasahil269@gmail.com";//change accordingly
        final String password = "sahil@21";//change accordingly

        String to = email;//change accordingly

        String topicName= topicname.substring(13, topicname.indexOf(","));
        String creatorOfTopic= topicname.substring(topicname.indexOf(",")+15);

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
            message.setSubject("Link Sharing");
            message.setContent("<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "<head>\n" +
                    "    <style>\n" +
                    "        a:link, a:visited {\n" +
                    "            background-color: white;\n" +
                    "            color: black;\n" +
                    "            border: 2px solid green;\n" +
                    "            padding: 10px 20px;\n" +
                    "            text-align: center;\n" +
                    "            text-decoration: none;\n" +
                    "            display: inline-block;\n" +
                    "        }\n" +
                    "\n" +
                    "        a:hover, a:active {\n" +
                    "            background-color: blue;\n" +
                    "            color: white;\n" +
                    "        }\n" +
                    "    </style>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "<div style=\"border:1px solid black;border-radius: 3px;height: 300px;width: 50%;text-align: center;margin-left: 350px;margin-right: 100px;margin-top: 50px; background-color:#6495ed;color: white;\">\n" +
                    "<b style=\"font-size: 30px;\">Link Sharing</b>\n" +
                    "<div style=\"font-size: 20px;padding-top: 30px; \">\n" +
                    "Topic Name : '\'"+topicName+"'\n" +
                    "<br><br>\n" +
                    "Creater Name : '\'"+creatorOfTopic+"'\n" +
                    "<br>\n" +
                    "<hr>\n" +
                    "<a href='http://192.168.43.48:8080/subscribetotopicbyinvitation?topicname="+topicName+"&creatorname="+creatorOfTopic+"&useremail="+email+"' style='text-align: center;width: 200px;'>Click To Subscribe</a>\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "</body>\n" +
                    "</html>\n","text/html");

            //send the message
            Transport.send(message);

            return "Invitation Sent Successfully...";

        } catch (MessagingException e) {
            e.printStackTrace();
            return "error";
        }
    }
}
