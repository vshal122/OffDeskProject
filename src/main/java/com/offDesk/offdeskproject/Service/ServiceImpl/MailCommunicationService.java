package com.offDesk.offdeskproject.Service.ServiceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailCommunicationService {

    @Autowired
    private JavaMailSender javaMailSender;

    public  void mailSend(String toMail,String subject,String body)
    {

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("vishmalviya6@gmail.com");
        simpleMailMessage.setTo(toMail);
        simpleMailMessage.setText(body);
        simpleMailMessage.setSubject(subject);
        javaMailSender.send(simpleMailMessage);

        System.out.println("mail Sent SuccessFully");
    }
}
