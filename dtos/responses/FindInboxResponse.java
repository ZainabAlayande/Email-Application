package dtos.responses;

import java.time.LocalDateTime;

public class FindInboxResponse {

    private String sendersName;
    private String title;
    private String body;

    private LocalDateTime dateSent = LocalDateTime.now();

    public String getSendersName() {
        return sendersName;
    }

    public void setSendersName(String sendersName) {
        this.sendersName = sendersName;
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

    public LocalDateTime getDateSent() {
        return dateSent;
    }

    public void setDateSent(LocalDateTime dateSent) {
        this.dateSent = dateSent;
    }

    @Override
    public String toString() {
        return "sendersName = " + sendersName + '\'' +
                ", title = " + title + '\'' +
                ", body = " + body + '\'' +
                ", dateSent = " + dateSent;
    }
}
