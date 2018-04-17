package id.dhanarjkusuma.springsocket.repository;

import id.dhanarjkusuma.springsocket.domain.MessageStream;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MessageRepository extends MongoRepository<MessageStream, String> {
}
