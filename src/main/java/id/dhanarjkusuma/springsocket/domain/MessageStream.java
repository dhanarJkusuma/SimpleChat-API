package id.dhanarjkusuma.springsocket.domain;

public class MessageStream {

    private String name;
    private String content;

    public MessageStream() {
    }

    public MessageStream(String name, String content) {
        this.name = name;
        this.content = content;
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
