package ru.otus.ovodkov.homework8.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.annotation.DirtiesContext;
import ru.otus.ovodkov.homework8.document.Book;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Ovodkov Sergey
 * created on 19.08.2020
 */
@DisplayName("Репозиторий для работы с книгами")
@DataMongoTest
@DirtiesContext
public class BookRepositoryTest {

    private static final int COUNT_JAVA_BOOKS = 5;
    private static final int COUNT_SPRING_BOOKS = 2;
    private static final int COUNT_CSHARP_BOOKS = 0;

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void contextLoads() {}

    @Test
    @DisplayName("Получение книг у которых указан жанр Java")
    public void gettingJavaBooks() {
        List<Book> books = bookRepository.findByGenresIn(List.of("Java"));
        assertThat(books.size()).isEqualTo(COUNT_JAVA_BOOKS);
    }

    @Test
    @DisplayName("Получение книг у которых указан жанр Spring")
    public void gettingSpringBooks() {
        List<Book> books = bookRepository.findByGenresIn(List.of("Spring"));
        assertThat(books.size()).isEqualTo(COUNT_SPRING_BOOKS);
    }

    @Test
    @DisplayName("Получение книг у которых указан жанр C#")
    public void gettingCsharpBooks() {
        List<Book> books = bookRepository.findByGenresIn(List.of("C#"));
        assertThat(books.size()).isEqualTo(COUNT_CSHARP_BOOKS);
    }
}
