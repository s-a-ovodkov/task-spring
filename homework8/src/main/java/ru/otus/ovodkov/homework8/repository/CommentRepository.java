package ru.otus.ovodkov.homework8.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.ovodkov.homework8.document.Comment;

/**
 * @author Ovodkov Sergey on 11.08.2020
 */
public interface CommentRepository extends MongoRepository<Comment, String> {
}
