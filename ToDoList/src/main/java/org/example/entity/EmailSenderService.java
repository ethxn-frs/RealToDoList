package org.example.entity;

public class EmailSenderService {

    public void sendEmail(String to, String subject, String content) {
        // Logique d'envoi d'e-mail
        System.out.println("E-mail envoyé à " + to + " avec le sujet : " + subject + "\nContenu : " + content);
    }
}
