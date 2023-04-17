package data.repositories;

import data.models.Email;
import data.models.User;
import dtos.requests.InboxRequest;
import dtos.requests.OutboxRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class EmailRepositoryImpl implements EmailRepository {
    static private int count;
    static List<Email> emailList = new ArrayList<>();
    static User user = new User();

    @Override
    public Email create(Email email) {
        emailList.add(email);
        user.setTrashBox(emailList);
        user.setInbox(emailList);
        user.setOutbox(emailList);
        count++;
        return email;
    }

    @Override
    public void delete(String mailSubject) {
        //appendToVariable(mailSubject);
        for (Email emails: emailList) {
            if (emails.getSubject().equalsIgnoreCase(mailSubject))
                emailList.remove(emails);
            break;

        }
        count--;
    }

    @Override
    public void delete(Email email) {
        for (int i = 0; i < emailList.size(); i++) {
            if (emailList.get(i).equals(email))
                emailList.remove(email);
        }
        count--;
    }

    @Override
    public long count() {
        return count;
    }

    @Override
    public void deleteAll() {
        for (int i = 0; i < emailList.size(); i++) {
            emailList.remove(emailList.get(i));
        }
        count = 0;
    }

    @Override
    public List<Email> findAll() {
        return emailList;
    }

    @Override
    public Email findBySenderEmail(String senderEmail) {

        if (!senderEmail.endsWith("@gmail.com"))
            senderEmail += "@gmail.com";

        //appendToVariable(senderEmail);

        for (Email emails: emailList) {
            if (emails.getSenderEmail().equalsIgnoreCase(senderEmail)) {
                return emails;
            }
        }

        throw new NoSuchElementException("Email not found..........");

    }

    @Override
    public List<Email> getInbox(InboxRequest inboxRequest) {
        for (Email emails: emailList) {
            if (inboxRequest.getRecipientEmailAddress().equals(emails.getReceiverEmail())) return emailList;
        }
        return null;
    }

    @Override
    public List<Email> getOutbox(OutboxRequest outboxRequest) {
        for (Email emails: emailList) {
            if (outboxRequest.getSenderEmailAddress().equals(emails.getSenderEmail())) return emailList;
        }
        return null;

    }

    private void appendToVariable(String variableName) {
        if (!variableName.endsWith("@gmail.com"))
            variableName += "@gmail.com";
    }
}
