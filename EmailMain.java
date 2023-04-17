import controllers.EmailController;
import controllers.UserController;
import data.models.User;
import dtos.requests.ComposeMailRequest;
import dtos.requests.InboxRequest;
import dtos.requests.OutboxRequest;
import dtos.requests.RegisterRequest;
import dtos.responses.SignUpResponse;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.util.ArrayList;

public class EmailMain {

    static UserController userController = new UserController();
    static EmailController emailController = new EmailController();
    static User user = new User();



    public static void main(String[] args) {
        launchEmailApplication();
        //displayAfterLogIn();


    }


    private static void displayAfterLogIn() {
        String displayMessageAfterLogIn = input("""
                ------------------------------------
                |  1 ----- Compose Mail
                ------------------------------------
                |  2 ----- Inbox
                ------------------------------------
                |  3 ----- Outbox
                ------------------------------------
                |  4 ----- Search Mail
                ------------------------------------
                |  5 ----- Delete Mail
                ------------------------------------
                |  6 ----- Logout
                ------------------------------------
                |  7 ----- Home Page 
                ------------------------------------
                |  8 ----- Close App
                ------------------------------------
                """);

        try {
            validateEmptyStringCanNotBreakCode(displayMessageAfterLogIn);
        } catch (Exception e) {
            display(e.getMessage());
            launchEmailApplication();
        }

        switch (displayMessageAfterLogIn.charAt(0)) {
            case '1' -> composeMail();
            case '2' -> mailInbox();
            case '3' -> mailOutbox();
            case '4' -> searchMail();
            case '5' -> deleteMail();
            case '6', '7' -> launchEmailApplication();
            case '8' -> exitEmail();
            default -> displayAfterLogIn();
        }
    }

    private static void mailOutbox() {
        OutboxRequest outboxRequest = new OutboxRequest();
        display(String.valueOf(emailController.getRecipientOutbox()));
        displayAfterLogIn();
    }

    public static void validateEmptyStringCanNotBreakCode(String empty) {
        String emptyString = "";
        if (empty.equals(emptyString)) {
            throw new IllegalArgumentException("Invalid Argument");
        }
    }

    private static void deleteMail() {
        String mailSubject = input("Enter mail subject to delete mail:::: ");
        emailController.deleteMail(mailSubject);
       displayAfterLogIn();
    }

    private static void searchMail() {
        String sendersNameToSearch = input("Enter sender's name to search:::: ");
        display(String.valueOf(emailController.searchMail(sendersNameToSearch)));
        displayAfterLogIn();
    }

    private static void mailInbox() {
        InboxRequest inboxRequest = new InboxRequest();
        display(String.valueOf(emailController.getSenderInbox()));
        displayAfterLogIn();
//        display(emailController.viewAllInbox().toString());
//        displayAfterLogIn();
    }

    private static void composeMail() {
        ComposeMailRequest composeMailRequest = new ComposeMailRequest();
        composeMailRequest.setSendersMail(input("Sender's Mail Address:::: "));
        composeMailRequest.setReceiversMail(input("Recipient Mail Address:::: "));
        composeMailRequest.setTitle(input("Enter Mail Subject:::: "));
        composeMailRequest.setBody(input("Enter Body:::: "));
        var output = emailController.composeMail(composeMailRequest);
        display(output.toString());
        displayAfterLogIn();
    }

    private static void launchEmailApplication() {
        String emailFirstPage = input("""
                -------------------------------------------
                |          E    M    A    I    L          
                -------------------------------------------
                |  Press 1    >>>>>>> Register               
                -------------------------------------------
                |  Press 2    >>>>>>> Login                  
                -------------------------------------------
                |  Press 3    >>>>>>> Close App                                       
                -------------------------------------------
                """);
        try {
            validateEmptyStringCanNotBreakCode(emailFirstPage);

        } catch (Exception e) {
            display(e.getMessage());
            launchEmailApplication();
        }


        switch (emailFirstPage.charAt(0)) {
            case '1':
                registerNewUser();
                break;
            case '2':
                loginForExistingUser();
                break;
            case '3':
                exitEmail();
            default:
                launchEmailApplication();}}

    private static void exitEmail() {
        display("Bye.....");
        System.exit(0);
    }

    private static void loginForExistingUser() {
        SignUpResponse signUpRequest = new SignUpResponse();
        signUpRequest.setEmailAddress(input("Enter your mail address:::: "));
        signUpRequest.setPassword(input("Enter password:::: "));
        var result = userController.signUp(signUpRequest);
        display(result.toString());
        displayAfterLogIn();
    }

    private static void registerNewUser() {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setFirstName(input("Enter First Name::::"));
        registerRequest.setLastName(input("Enter Last Name:::: "));
        registerRequest.setEmailAddress(input("Choose a valid email address::::"));
        registerRequest.setPassword(input("Choose a valid password:::: "));
        registerRequest.setCountry(input("Enter your country:::: "));
        registerRequest.setPhoneNumber(input("Enter a valid phone number:::: "));
        registerRequest.setDateOfBirth(input("Enter Date Of Birth:::: "));
        //registerRequest.setDateOfBirth(input("Enter date of birth:::: "));
        var result = userController.register(registerRequest);
        display(result.toString());
        //display("Now login....");
        launchEmailApplication();

        }



    private static void display(String prompt) {
        JOptionPane.showMessageDialog(null, prompt);
    }

    private static String input(String prompt) {
        return JOptionPane.showInputDialog(prompt);
    }
}
