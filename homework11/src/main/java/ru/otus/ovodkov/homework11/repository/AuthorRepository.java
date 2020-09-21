package ru.otus.ovodkov.homework11.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import ru.otus.ovodkov.homework11.document.Author;

/**
 * @author Ovodkov Sergey
 * created on 15.09.2020
 */
public interface AuthorRepository extends ReactiveMongoRepository<Author, String> {
}
