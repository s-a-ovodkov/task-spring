package ru.otus.ovodkov.homework8.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.ovodkov.homework8.document.Author;

/**
 * @author Ovodkov Sergey on 11.08.2020
 */
public interface AuthorRepository extends MongoRepository<Author, String> {
}
