package services;

import data.models.Email;
import data.models.User;
import data.repositories.EmailRepository;
import data.repositories.EmailRepositoryImpl;
import dtos.requests.ComposeMailRequest;
import utils.Mapper;

import java.util.List;

public class EmailServiceImpl implements EmailService {

    EmailRepository emailRepository = new EmailRepositoryImpl();
    static User user = new User();
    boolean theSending = false;

    @Override
    public Email composeMail(ComposeMailRequest composeMailRequest) {
        if (composeMailRequest.getReceiversMail().equals(user.getEmailAddress()))
            theSending = true;

        return emailRepository.create(Mapper.map(composeMailRequest));
    }
    @Override
    public Email searchMail(String sendersName) {
        return emailRepository.findBySenderEmail(sendersName);
    }

    @Override
    public String viewInbox() {
        List<Email> allEmails = emailRepository.findAll();
        return allEmails.toString();
    }

    @Override
    public List<Email> userInbox() {
        if (theSending)
            return user.getInbox();

        return user.getInbox();
    }


    @Override
    public List<Email> userOutbox() {
        return user.getOutbox();

    }

    @Override
    public List<Email> outbox() {

        return null;
    }


    @Override
    public void deleteMailBySubject(String mailSubject) {
        emailRepository.delete(mailSubject);
        successMessage();
    }

    private void successMessage() {
        System.out.println("Deleted Successfully.....");
    }
}
