package id.dhanarjkusuma.springsocket.api;

import id.dhanarjkusuma.springsocket.domain.MessagePushStream;
import id.dhanarjkusuma.springsocket.domain.MessageStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

@RestController
public class ChatApi {

    private final SimpMessagingTemplate template;

    @Autowired
    public ChatApi(SimpMessagingTemplate template) {
        this.template = template;
    }

    @MessageMapping("/chat")
    public void chatBroker(String messageStream) throws Exception {
        template.convertAndSend("/chat", messageStream);
    }

}
