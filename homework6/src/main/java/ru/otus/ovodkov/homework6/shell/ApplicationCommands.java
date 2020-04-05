package ru.otus.ovodkov.homework6.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.ovodkov.homework6.dao.BookDaoJpa;
import ru.otus.ovodkov.homework6.dao.GenreDaoJpa;
import ru.otus.ovodkov.homework6.domain.Book;
import ru.otus.ovodkov.homework6.domain.Comment;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@ShellComponent
public class ApplicationCommands {

    private final BookDaoJpa bookRepository;
    private final GenreDaoJpa genreRepository;

    /**
     * Получить список всех книг
     *
     * @return Список книг в хранилище
     */
    @ShellMethod(value = "Get all Books", key = {"books"})
    public String getAllBooks() {
        List<Book> books = bookRepository.getAllBooks();
        return books.stream()
                .map(Book::toString)
                .collect(Collectors.joining("\n"));
    }

    /**
     * Найти книгу по идентификатору
     *
     * @param id Идентификатор книги
     * @return Найденная книга
     */
    @ShellMethod(value = "Get book by id", key = {"book", "b"})
    public String getBookById(long id) {
        Optional<Book> bookOptional = bookRepository.getByBookId(id);
        return bookOptional.isPresent()
                ? bookOptional.get().toString()
                : "Указанная книга не найдена";
    }

    /**
     * Получить список книг указаного жанра
     *
     * @param id Идентификатор жанра
     * @return Списко книг указаного жанра
     */
    @ShellMethod(value = "Get books by id genre", key = {"bookByGenre", "bg"})
    public String getBookByGenre(long id) {
        Set<Book> books = genreRepository.getBooksByIdGenre(id);
        return books.size() == 0
                ? "Не найдено книг указаного жанра"
                : books.stream()
                .map(Book::toString)
                .collect(Collectors.joining("\r"));
    }

    /**
     * Добавление комментария к укажанной книги
     *
     * @param id   Идентификатор книги
     * @param text Тест комментария
     * @return Обновленная книга с добавленным комментарием
     */
    @ShellMethod(value = "Add comment by book", key = {"addComment", "addcb"})
    public String addComment(long id, String text) {
        Comment comment = new Comment();
        comment.setCommentBook(text);
        Optional<Book> book = bookRepository.addComment(id, comment);
        return book.isPresent()
                ? book.get().toString()
                : "Не удалось добавить комментарий";
    }
}
