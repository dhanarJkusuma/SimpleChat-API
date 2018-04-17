package id.dhanarjkusuma.springsocket.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "message")
public class MessageStream {

    @Id
    private String id;
    private String name;
    private String content;
    private Date createdAt;

    public MessageStream() {
        this.createdAt = new Date();
    }

    public MessageStream(String name, String content) {
        this.name = name;
        this.content = content;
        this.createdAt = new Date();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
