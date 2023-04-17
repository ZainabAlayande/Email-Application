package utils;

import data.models.Email;
import data.models.User;
import dtos.requests.ComposeMailRequest;
import dtos.requests.InboxRequest;
import dtos.requests.OutboxRequest;
import dtos.requests.RegisterRequest;
import dtos.responses.SignUpResponse;

public class Mapper {


    public static User map(RegisterRequest registerRequest) {
        User user = new User();
        user.setFirstName(registerRequest.getFirstName());
        user.setLastName(registerRequest.getLastName());
        user.setPhoneNumber(registerRequest.getPhoneNumber());
        user.setDateOfBirth(registerRequest.getDateOfBirth());
        user.setPassword(registerRequest.getPassword());
        user.setEmailAddress(registerRequest.getEmailAddress());
        user.setCountry(registerRequest.getCountry());
        return user;
    }

    public static void map(User foundUser, SignUpResponse signUpResponse) {
        signUpResponse.setFullName(foundUser.getFirstName() + " " + foundUser.getLastName());
        signUpResponse.setEmailAddress(foundUser.getEmailAddress());
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, dd/MM/yyy, hh:mm a");
        //signUpResponse.setDatePosted(formatter.format(foundUser.getTimeCreated()));
    }

    public static Email map(SignUpResponse signUpRequest) {
        Email email = new Email();
        //email.setPassword(signUpRequest.getPassword());
        //email.setEmailAddress(signUpRequest.getEmailAddress());
        return email;
    }

    public static Email map(ComposeMailRequest composeMailRequest) {
        Email email = new Email();
        email.setSenderEmail(composeMailRequest.getSendersMail());
        email.setReceiverEmail(composeMailRequest.getReceiversMail());
        email.setSubject(composeMailRequest.getTitle());
        email.setBody(composeMailRequest.getBody());
        //SimpleDateFormat formatter = new SimpleDateFormat("EEE dd-MM-yyyy hh:mm:ss a");
        //email.setDateAndTimeSent(formatter.format(composeMailRequest.getDateTime()));
        return email;
    }

    public static InboxRequest map(Email email, InboxRequest inboxRequest) {
        inboxRequest.setRecipientEmailAddress(email.getReceiverEmail());
        return inboxRequest;
    }

    public static OutboxRequest map(Email email, OutboxRequest outboxRequest) {
        outboxRequest.setSenderEmailAddress(email.getSenderEmail());
        return outboxRequest;
    }
}
