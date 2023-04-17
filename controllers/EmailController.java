package controllers;
import data.models.User;
import dtos.requests.ComposeMailRequest;
import dtos.requests.InboxRequest;
import dtos.requests.OutboxRequest;
import services.EmailService;
import services.EmailServiceImpl;

public class EmailController {
    EmailService emailService = new EmailServiceImpl();

    public Object composeMail(ComposeMailRequest composeMailRequest) {
        try {
            return emailService.composeMail(composeMailRequest);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public Object searchMail(String senderName) {
        try {
            return emailService.searchMail(senderName);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public Object viewAllInbox() {
        try {
            return emailService.viewInbox();
        } catch (NullPointerException e) {
           return e.getMessage();
        }

    }

    public void deleteMail(String mailSubject) {
        try {
            emailService.deleteMailBySubject(mailSubject);
            //System.out.println("Successfully deleted...");
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    public Object getSenderInbox() {
        try {
            return emailService.userInbox();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public Object getRecipientOutbox() {
        try {
            return emailService.userOutbox();
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
