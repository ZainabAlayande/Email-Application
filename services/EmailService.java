package services;

import data.models.Email;
import data.models.User;
import dtos.requests.ComposeMailRequest;
import dtos.requests.InboxRequest;
import dtos.requests.OutboxRequest;

import java.util.List;

public interface EmailService {
    Email composeMail(ComposeMailRequest composeMailRequest);
    Email searchMail(String sendersName);
    String viewInbox();
    List<Email> userInbox();
    List<Email> userOutbox();

    List<Email> outbox();
    void deleteMailBySubject(String mailSubject);
}
