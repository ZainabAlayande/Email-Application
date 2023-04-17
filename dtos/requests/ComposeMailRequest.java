package dtos.requests;

import data.models.Email;

import java.time.LocalDateTime;

public class ComposeMailRequest extends Email {

    private String receiversMail;
    private String sendersMail;
    private String title;
    private String body;
    private String attachment;
    private LocalDateTime dateTime = LocalDateTime.now();

    public String getReceiversMail() {
        return receiversMail;
    }

    public void setReceiversMail(String receiversMail) {
        this.receiversMail = receiversMail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setSendersMail(String sendersMail) {
        this.sendersMail = sendersMail;
    }

    public String getSendersMail() {
        return sendersMail;
    }

    @Override
    public String toString() {
        return "ComposeMailRequest{" +
                "receiversMail='" + receiversMail + '\'' +
                ", sendersMail='" + sendersMail + '\'' +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", attachment='" + attachment + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }

    public Object getId() {
        return null;
    }
}
