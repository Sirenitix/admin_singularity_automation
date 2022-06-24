package com.example.firstcase.email_client.controller;

import com.example.firstcase.email_client.entity.Email;
import com.example.firstcase.email_client.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/email")
public class EmailController {

    @Autowired
    EmailSenderService emailSenderService;


    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
        public String sendEmails(@RequestBody List<Email> emails) {
        emails.forEach(email -> {
            try {
                emailSenderService.sendEmailWithAttachment(email);
            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
        });
        return "ok";
    }

}
