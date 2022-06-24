package com.example.firstcase.email_client.service;

import com.example.firstcase.email_client.entity.Email;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
@Service
public interface EmailSenderService {
    void sendEmailWithAttachment(Email toEmail) throws MessagingException;

}
