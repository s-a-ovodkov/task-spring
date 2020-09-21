package ru.otus.ovodkov.homework11.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import ru.otus.ovodkov.homework11.document.Comment;

/**
 * @author Ovodkov Sergey
 * created on 15.09.2020
 */
public interface CommentRepository extends ReactiveMongoRepository<Comment, String> {
}
