package id.dhanarjkusuma.springsocket.domain;

import java.util.Date;

public class MessagePushStream {
    private String name;
    private String message;
    private Date createdAt;

    public MessagePushStream() {
        this.createdAt = new Date();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
