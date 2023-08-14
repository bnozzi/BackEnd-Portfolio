package com.web.Portfolio.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

// import com.web.Portfolio.Model.Usuario;

import org.springframework.mail.SimpleMailMessage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;

    public void sendSimpleMessageResponse(
            String to,
            String name
    ) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("b.pizzipe@gmail.com");
        message.setTo(to);
        message.setSubject("Respuesta automatica");
        message.setText("Hola "+ name + "! \n ¡Gracias por tu mensaje! Solo queria confirmarte que he recibido tu correo y estoy emocionado de que estes interesado/a en mi trabajo. Te responderé lo antes posible.\nSaludos! Bruno Pizzi");
        emailSender.send(message);
    }

    public void messageForMe(String from, String subject , String text){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("b.pizzipe@gmail.com");
        message.setTo("b.pizzipe@gmail.com");
        message.setSubject(subject);
        message.setText("from: " + from + "\n"+ "message: \n" + text);
        emailSender.send(message);


    }
}
