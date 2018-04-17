package id.dhanarjkusuma.springsocket.service;

import id.dhanarjkusuma.springsocket.domain.MessageStream;

import java.util.List;

public interface MessageService {
    MessageStream saveMessage(MessageStream messageStream);
    List<MessageStream> retrieveMessage(Integer page, Integer size);
}
