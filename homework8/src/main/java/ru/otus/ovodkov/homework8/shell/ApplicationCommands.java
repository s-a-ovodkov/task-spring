package ru.otus.ovodkov.homework8.shell;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.ovodkov.homework8.document.Author;
import ru.otus.ovodkov.homework8.document.Book;
import ru.otus.ovodkov.homework8.document.Comment;
import ru.otus.ovodkov.homework8.document.Genre;
import ru.otus.ovodkov.homework8.dto.AuthorDto;
import ru.otus.ovodkov.homework8.dto.BookDto;
import ru.otus.ovodkov.homework8.exceptions.NoDocumentException;
import ru.otus.ovodkov.homework8.service.AuthorService;
import ru.otus.ovodkov.homework8.service.BookService;
import ru.otus.ovodkov.homework8.service.GenreService;

import static java.util.stream.Collectors.joining;

/**
 * Shell команды приложения
 *
 * @author Ovodkov Sergey on 11.08.2020
 */
@RequiredArgsConstructor
@ShellComponent
public class ApplicationCommands {

    private final BookService bookService;
    private final AuthorService authorService;
    private final GenreService genreService;

    /**
     * Получить список всех книг
     *
     * @return Список книг в хранилище
     */
    @ShellMethod(value = "Get all Books", key = {"books"})
    public String getAllBooks() {
        return bookService.getBooks().stream()
                .map(Book::toString)
                .collect(joining("\n"));
    }

    /**
     * Найти книгу по идентификатору
     *
     * @param id Идентификатор книги
     * @return Найденная книга
     */
    @SneakyThrows(NoDocumentException.class)
    @ShellMethod(value = "Get book by id", key = {"book"})
    public String getBookById(String id) {
        return bookService.getBookById(id).toString();
    }

    /**
     * Удалить указанную книгу
     *
     * @param id Идентификатор книги
     * @return Результат удаления
     */
    @SneakyThrows(NoDocumentException.class)
    @ShellMethod(value = "Delete book", key = {"deleteBook"})
    public String deleteBook(String id) {
        bookService.delete(id);
        return "success";
    }

    /**
     * Получить авторов указанной книги
     *
     * @param id Идентификатор книги
     * @return Автора книги
     */
    @SneakyThrows(NoDocumentException.class)
    @ShellMethod(value = "Get authors to the book", key = {"authorsBook"})
    public String getAuthorsBook(String id) {
        return bookService.getAuthorsBook(id).stream()
                .map(AuthorDto::toString)
                .collect(joining("\n"));
    }

    /**
     * Получить жанры указанной книги
     *
     * @param id Идентификатор книги
     * @return Жанры книги
     */
    @SneakyThrows(NoDocumentException.class)
    @ShellMethod(value = "Get genres to the book", key = {"genresBook"})
    public String getGenresBook(String id) {
        return String.join("\n", bookService.getGenresBook(id));
    }

    /**
     * Получить комментарии к указанной книге
     *
     * @param id Идентификатор книги
     * @return Комментарии книги
     */
    @SneakyThrows(NoDocumentException.class)
    @ShellMethod(value = "Get comments to the book", key = {"commentsBook"})
    public String getCommentsBook(String id) {
        return bookService.getCommentsBook(id).stream()
                .map(Comment::toString)
                .collect(joining("\n"));
    }

    /**
     * Получить список книг указанного жанра
     *
     * @param genre Жанр искомых книг
     * @return Список книг указанного жанра
     */
    @ShellMethod(value = "Get books by genre", key = {"booksGenre"})
    public String getBooksByGenre(String genre) {
        return bookService.getBooksByGenre(genre).stream()
                .map(Book::toString)
                .collect(joining("\n"));
    }

    /**
     * Получить список всех авторов книг в БД
     *
     * @return Все авторы книг
     */
    @ShellMethod(value = "Get all authors", key = {"authors"})
    public String getAuthors() {
        return authorService.getAuthors().stream()
                .map(Author::toString)
                .collect(joining("\n"));
    }

    /**
     * Получить список книг указанного автора
     *
     * @param id Идентификатор автора
     * @return Все книги указанного автора
     */
    @SneakyThrows(NoDocumentException.class)
    @ShellMethod(value = "Get books to author", key = {"booksAuthor"})
    public String getBooksAuthor(String id) {
        return authorService.getBooksAuthor(id).stream()
                .map(BookDto::toString)
                .collect(joining("\n"));
    }

    /**
     * Получить список жанров
     *
     * @return Список жанров
     */
    @ShellMethod(value = "Get all genres", key = {"genres"})
    public String getGenres() {
        return genreService.getGenres().stream()
                .map(Genre::toString)
                .collect(joining("\n"));
    }

    /**
     * Добавление жанра
     *
     * @param name Название добавляемого жанра
     * @return Результат добавления
     */
    @ShellMethod(value = "Create genre", key = {"addGenre"})
    public String addGenre(String name) {
        genreService.addGenres(name);
        return "success";
    }
}
