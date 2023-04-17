package data.repositories;

import data.models.Email;
import data.models.User;
import dtos.requests.InboxRequest;
import dtos.requests.OutboxRequest;

import java.util.List;

public interface EmailRepository {
    Email create(Email email);
    void delete(String mailSubject);
    void delete(Email email);
    long count();
    void deleteAll();
    List<Email> findAll();
    Email findBySenderEmail(String sendersEmail);

    List<Email> getInbox(InboxRequest inboxRequest);
    List<Email> getOutbox(OutboxRequest outboxRequest);
}
