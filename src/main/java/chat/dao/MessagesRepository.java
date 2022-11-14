package chat.dao;

import chat.models.Messages;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessagesRepository extends CrudRepository<Messages, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM messages ORDER BY id desc LIMIT 5")
    List<Messages> findBy5OrderById();

}
