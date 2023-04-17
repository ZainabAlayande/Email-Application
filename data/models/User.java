package data.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class User {
    private int userId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String dateOfBirth;
    private String password;
    private String emailAddress;
    private String country;

    private static List<Email> inbox = new ArrayList<>();
    private static List<Email> outbox = new ArrayList<>();

    private static List<Email> trashBox = new ArrayList<>();

    public List<Email> getTrashBox() {
        return trashBox;
    }

    public void setTrashBox(List<Email> trashBox) {
        User.trashBox = trashBox;
    }

    public List<Email> getInbox() {
        return inbox;
    }

    public void setInbox(List<Email> inbox) {
        User.inbox = inbox;
    }

    public List<Email> getOutbox() {
        return outbox;
    }

    public void setOutbox(List<Email> outbox) {
        User.outbox = outbox;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", fullName='" + firstName + " " + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", emailAddress='" + emailAddress + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    public LocalDateTime getTimeCreated() {
        return null;
    }

}


