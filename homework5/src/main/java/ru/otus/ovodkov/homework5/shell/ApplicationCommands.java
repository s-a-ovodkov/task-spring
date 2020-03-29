package ru.otus.ovodkov.homework5.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.ovodkov.homework5.dao.AuthorDao;
import ru.otus.ovodkov.homework5.dao.BookDao;
import ru.otus.ovodkov.homework5.dao.GenreDao;
import ru.otus.ovodkov.homework5.domain.Author;
import ru.otus.ovodkov.homework5.domain.Book;
import ru.otus.ovodkov.homework5.domain.Genre;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@ShellComponent
public class ApplicationCommands {

    private final AuthorDao authorDao;
    private final BookDao bookDao;
    private final GenreDao genreDao;

    /**
     * Получить список всех книг
     *
     * @return Список книг в хранилище
     */
    @ShellMethod(value = "Get all books", key = {"books"})
    public String getAllBooks() {
        List<Book> books = bookDao.getAllBooks();
        return books.stream()
                .map(x -> x.toString())
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
        return bookDao.getByBookId(id).toString();
    }

    /**
     * Удаление указаной книги
     *
     * @param id Идентификатор книги
     */
    @ShellMethod(value = "Delete book", key = {"delete-book", "dBook", "delBook"})
    public void deleteBook(long id) {
        bookDao.delete(id);
    }

    /**
     * Обновить данные книги
     *
     * @param id      Идентификатор книги
     * @param title   Название книги
     * @param edition Номер редакции книги
     * @param year    Год издания книги
     * @return Обновленную информацию о книги
     */
    @ShellMethod(value = "Update Book", key = {"update-book", "updBook"})
    public String updateBook(long id, String title, int edition, int year) {
        bookDao.update(new Book(id, title, edition, year));
        return bookDao.getByBookId(id).toString();
    }

    /**
     * Добавление новой книги
     *
     * @param title   Название книги
     * @param edition Номер издания книги
     * @param year    Год  издания книги
     * @return Информация о добавленной книги
     */
    @ShellMethod(value = "Create book", key = {"create-book", "createBook", "addBook"})
    public String createBook(String title, int edition, int year) {
        Book book = new Book();
        book.setTitleBook(title);
        book.setEdition(edition);
        book.setYearPublishing(year);
        long idBook = bookDao.addBook(book);
        return bookDao.getByBookId(idBook).toString();
    }

    /**
     * Получить все жанры книг
     *
     * @return Список жанров книг
     */
    @ShellMethod(value = "Get all genres", key = {"genres"})
    public String getAllGenres() {
        List<Genre> genres = genreDao.getAllGenres();
        return genres.stream()
                .map(x -> x.toString())
                .collect(Collectors.joining("\n"));
    }

    /**
     * Найти жанр книги по индентификатору
     *
     * @param id Идентификатор жанра книги
     * @return Найденый жанр книги
     */
    @ShellMethod(value = "Get genre by id", key = {"genre", "g"})
    public String getGenreById(long id) {
        return genreDao.getByIdGenre(id).toString();
    }

    /**
     * Удалить указанный жанр книги
     *
     * @param id Идентификтор жанра книги
     */
    @ShellMethod(value = "Delete genre", key = {"delete-genre", "dGenre", "delGenre"})
    public void deleteGenre(long id) {
        genreDao.delete(id);
    }

    /**
     * Обновление данных о жанре
     *
     * @param id          Идентификатор жанра
     * @param name        Название жанра
     * @param description Описание жанра
     * @return Обновленая информация о жанре
     */
    @ShellMethod(value = "Update genre", key = {"update-genre", "updGenre"})
    public String updateGenre(long id, String name, String description) {
        genreDao.update(new Genre(id, name, description));
        return genreDao.getByIdGenre(id).toString();
    }

    /**
     * Обновление данных о жанре
     *
     * @param name        Название жанра
     * @param description Описание жанра
     * @return Информация о добавленном жанре
     */
    @ShellMethod(value = "Create genre", key = {"create-genre", "addGenre", "createGenre"})
    public String createGenre(String name, String description) {
        Genre genre = new Genre();
        genre.setNameGenre(name);
        genre.setDescriptionGenre(description);
        long idGenre = genreDao.addGenre(genre);
        return genreDao.getByIdGenre(idGenre).toString();
    }

    /**
     * Получить список всех авторов книг
     *
     * @return Список всех авторов книг
     */
    @ShellMethod(value = "Get all authors", key = {"authors"})
    public String getAllAuthors() {
        List<Author> authors = authorDao.getAllAuthors();
        return authors.stream()
                .map(x -> x.toString())
                .collect(Collectors.joining("\n"));
    }

    /**
     * Найти автора книги
     *
     * @param id Идентификатор автора книги
     * @return Автор книги
     */
    @ShellMethod(value = "Get author by id", key = {"author", "a"})
    public String getAuthorById(long id) {
        return authorDao.getByIdAuthor(id).toString();
    }

    /**
     * Удаление указанного автора книги
     *
     * @param id Идентификатор удаляемого автора книги
     */
    @ShellMethod(value = "Delete author", key = {"delete-author", "dAuthor", "delAuthor"})
    public void deleteAuthor(long id) {
        authorDao.delete(id);
    }

    /**
     * Обновить данные автора книг
     *
     * @param id        Идентификатор автора
     * @param firstName Имя автора книг
     * @param lastName  Фамилия автора книг
     * @return Обновленая информация о авторе
     */
    @ShellMethod(value = "Update authors", key = {"update-authors", "updAuthors"})
    public String updateAuthor(long id, String firstName, String lastName) {
        Author author = new Author(id, firstName, lastName);
        authorDao.update(author);
        return authorDao.getByIdAuthor(id).toString();
    }

    /**
     * Добавить автора книг
     *
     * @param firstName Имя автора книг
     * @param lastName  Фамилия автора книг
     * @return Обновленая информация о авторе
     */
    @ShellMethod(value = "Create author", key = {"create-author", "addAuthor", "createAuthor"})
    public String createAuthor(String firstName, String lastName) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);
        long idAuthor = authorDao.addAuthor(author);
        return authorDao.getByIdAuthor(idAuthor).toString();
    }
}
