package id.dhanarjkusuma.springsocket.api;

import id.dhanarjkusuma.springsocket.domain.MessageStream;
import id.dhanarjkusuma.springsocket.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ChatApi {

    private final SimpMessagingTemplate template;
    private final MessageService messageService;

    @Autowired
    public ChatApi(SimpMessagingTemplate template, MessageService messageService) {
        this.template = template;
        this.messageService = messageService;
    }

    @MessageMapping("/chat")
    public void chatBroker(String messageStream) throws Exception {
        String[] fragmentString = messageStream.split("\\:");
        String sender = fragmentString[0];
        int messageIndexFrom = messageStream.indexOf(sender) + sender.length() + 1;
        String message = messageStream.substring(messageIndexFrom, messageStream.length());
        MessageStream messageSaved = new MessageStream(sender, message);
        messageService.saveMessage(messageSaved);
        template.convertAndSend("/chat", messageStream);
    }

    @GetMapping(path = "/chat/retrieve")
    public List<MessageStream> retrieveMessage(
            @RequestParam(name = "page", required = false) Integer page,
            @RequestParam(name = "size", required = false) Integer size
    ){
        return messageService.retrieveMessage(page, size);
    }

    @PostMapping(path = "/chat/send-rest")
    public MessageStream sendMessageRest(@Validated @RequestBody MessageStream messageStream){
        MessageStream savedMessage = messageService.saveMessage(messageStream);
        String broadcastMessage = String.join(":", messageStream.getName(), messageStream.getContent());
        template.convertAndSend("/chat", broadcastMessage);
        return savedMessage;
    }


}
