package ru.otus.ovodkov.homework6.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.ovodkov.homework6.domain.Author;
import ru.otus.ovodkov.homework6.domain.Book;
import ru.otus.ovodkov.homework6.domain.Comment;
import ru.otus.ovodkov.homework6.domain.Genre;
import ru.otus.ovodkov.homework6.exceptions.NoEntityException;
import ru.otus.ovodkov.homework6.services.AuthorService;
import ru.otus.ovodkov.homework6.services.BookService;
import ru.otus.ovodkov.homework6.services.CommentService;
import ru.otus.ovodkov.homework6.services.GenreService;

import static java.util.stream.Collectors.joining;

@RequiredArgsConstructor
@ShellComponent
public class ApplicationCommands {

    private final BookService bookService;
    private final AuthorService authorService;
    private final GenreService genreService;
    private final CommentService commentService;

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
    @ShellMethod(value = "Get book by id", key = {"book", "b"})
    public String getBookById(long id) {
        try {
            return bookService.getBookById(id).toString();
        } catch (NoEntityException exc) {
            return exc.toString();
        }
    }

    /**
     * Получить авторов указанной книги
     *
     * @param id Идентификатор книги
     * @return Автора книги
     */
    @ShellMethod(value = "Get authors to the book", key = {"authorsBook"})
    public String getAuthorsBook(long id) {
        try {
            return bookService.getAuthorsBook(id).stream()
                    .map(Author::toString)
                    .collect(joining("\n"));
        } catch (NoEntityException exc) {
            return exc.toString();
        }
    }

    /**
     * Получить жанры указанной книги
     *
     * @param id Идентификатор книги
     * @return Жанры книги
     */
    @ShellMethod(value = "Get genres to the book", key = {"genresBook"})
    public String getGenresBook(long id) {
        try {
            return bookService.getGenresBook(id).stream()
                    .map(Genre::toString)
                    .collect(joining("\n"));
        } catch (NoEntityException exc) {
            return exc.toString();
        }
    }

    /**
     * Получить комментарии к указаной книге
     *
     * @param id Идентификатор книги
     * @return Комментарии книги
     */
    @ShellMethod(value = "Get comments to the book", key = {"commentsBook"})
    public String getCommentsBook(long id) {
        try {
            return bookService.getCommentsBook(id).stream()
                    .map(Comment::toString)
                    .collect(joining("\n"));
        } catch (NoEntityException exc) {
            return exc.toString();
        }
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
     * @return Все книги указаного автора
     */
    @ShellMethod(value = "Get books to author", key = {"booksAuthor"})
    public String getBooksAuthor(long id) {
        try {
            return authorService.getBooksAuthor(id).stream()
                    .map(Book::toString)
                    .collect(joining("\n"));
        } catch (NoEntityException exc) {
            return exc.toString();
        }
    }

    /**
     * Получить все жанры книг
     *
     * @return Все жанры книг
     */
    @ShellMethod(value = "Get all genres", key = {"genres"})
    public String getGenres() {
        return genreService.getGenres().stream()
                .map(Genre::toString)
                .collect(joining("\n"));
    }

    /**
     * Получить все книги указаного жанра
     *
     * @param id Идентификатор жанра
     * @return Книги указаного жанра
     */
    @ShellMethod(value = "Get books to genre", key = {"booksGenre"})
    public String getBooksGenre(long id) {
        try {
            return genreService.getBooksGenre(id).stream()
                    .map(Book::toString)
                    .collect(joining("\n"));
        } catch (NoEntityException exc) {
            return exc.toString();
        }
    }

    /**
     * Добавить комментарий к указанной книги
     *
     * @param id   Идентификатор книги
     * @param text Комментарий
     * @return Обновленный комментарий
     */
    @ShellMethod(value = "Add a comment to the book", key = {"addCommentBook"})
    public String addCommentBook(long id, String text) {
        try {
            return commentService.addCommentBook(id, text).toString();
        }catch (NoEntityException exc) {
            return exc.toString();
        }
    }
}
