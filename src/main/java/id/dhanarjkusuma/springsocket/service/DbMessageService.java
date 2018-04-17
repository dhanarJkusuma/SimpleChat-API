package id.dhanarjkusuma.springsocket.service;

import id.dhanarjkusuma.springsocket.domain.MessageStream;
import id.dhanarjkusuma.springsocket.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DbMessageService implements MessageService{

    private final MessageRepository repository;

    @Autowired
    public DbMessageService(MessageRepository repository) {
        this.repository = repository;
    }

    @Override
    public MessageStream saveMessage(MessageStream messageStream) {
        return repository.save(messageStream);
    }

    @Override
    public List<MessageStream> retrieveMessage(Integer page, Integer size) {
        if(page != null && size != null){
            Sort sort = new Sort(Sort.Direction.DESC, "createdAt");
            Pageable pageable = PageRequest.of(page, size, sort);
            return repository.findAll(pageable).getContent();
        }
        return repository.findAll();
    }
}
