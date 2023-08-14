package com.web.Portfolio.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.Portfolio.Model.Message;
import com.web.Portfolio.Service.EmailService;
import com.web.Portfolio.Service.UserService;

@RestController
public class MessageController {

    @Autowired
    private EmailService emailService;

    @Autowired
    private UserService usuarioService;

    @PostMapping("/message")
    public void sendMessage(@RequestBody Message message) {
        message.setUsuario(usuarioService.getUser((long) 151297)); 
        emailService.sendSimpleMessage(message.getPara(), message.getAsunto(), message.getMensaje()); // (to, subject, text)
    }

}
