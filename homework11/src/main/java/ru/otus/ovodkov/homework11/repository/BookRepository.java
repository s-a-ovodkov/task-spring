package ru.otus.ovodkov.homework11.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import ru.otus.ovodkov.homework11.document.Book;

import java.util.List;

/**
 * @author Ovodkov Sergey
 * created on 15.09.2020
 */
public interface BookRepository extends ReactiveMongoRepository<Book, String> {

    /**
     * Получение книг указанных жанров
     * @param genres Жанры искомых книг
     * @return Список книг указанных жанров
     */
    Flux<Book> findByGenresIn(List<String> genres);
}
