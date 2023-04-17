package data.models;

import java.time.LocalDateTime;

public class Email {
    private String senderEmail;
    private String receiverEmail;
    private String subject;
    private String body;

    private LocalDateTime dateAndTimeSent = LocalDateTime.now();

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    public String getReceiverEmail() {
        return receiverEmail;
    }

    public void setReceiverEmail(String receiverEmail) {
        this.receiverEmail = receiverEmail;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LocalDateTime getDateAndTimeSent() {
        return dateAndTimeSent;
    }

    @Override
    public String toString() {
        return "Email{" +
                ", senderEmail='" + senderEmail + '\'' +
                ", receiverEmail='" + receiverEmail + '\'' +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                ", dateAndTimeSent=" + dateAndTimeSent +
                '}';
    }

    public void setDateAndTimeSent(LocalDateTime dateAndTimeSent) {
        this.dateAndTimeSent = dateAndTimeSent;
    }



}