package ru.otus.ovodkov.homework8.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.ovodkov.homework8.document.Book;

import java.util.List;

/**
 * @author Ovodkov Sergey on 11.08.2020
 */
public interface BookRepository extends MongoRepository<Book, String> {

    /**
     * Получение книг указанных жанров
     * @param genres Жанры искомых книг
     * @return Список книг указанных жанров
     */
    List<Book> findByGenresIn(List<String> genres);
}
