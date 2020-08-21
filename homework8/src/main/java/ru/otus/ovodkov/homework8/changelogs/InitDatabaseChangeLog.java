package ru.otus.ovodkov.homework8.changelogs;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.github.cloudyrock.mongock.driver.mongodb.springdata.v3.decorator.impl.MongockTemplate;
import ru.otus.ovodkov.homework8.document.Author;
import ru.otus.ovodkov.homework8.document.Book;
import ru.otus.ovodkov.homework8.document.Comment;
import ru.otus.ovodkov.homework8.document.Genre;
import ru.otus.ovodkov.homework8.dto.AuthorDto;
import ru.otus.ovodkov.homework8.dto.BookDto;

import java.util.List;

/**
 * Инициализирующая миграция
 *
 * @author Ovodkov Sergey
 * created on 18.08.2020
 */
@ChangeLog(order = "001")
public class InitDatabaseChangeLog {

    private final static String GENRE_JAVA = "Java";
    private final static String GENRE_SPRING = "Spring";

    private Comment comment1, comment2, comment3, comment4, comment5, comment6;

    @ChangeSet(order = "001", id = "insert-genres-001", author = "s.ovodkov")
    public void genresInsertDb(MongockTemplate template) {
        Genre java = new Genre();
        java.setName(GENRE_JAVA);
        template.save(java);

        Genre spring = new Genre();
        spring.setName(GENRE_SPRING);
        template.save(spring);
    }

    @ChangeSet(order = "002", id = "insert-comments-002", author = "s.ovodkov")
    public void commentsInsertDb(MongockTemplate template) {
        comment1 = new Comment();
        comment1.setComment("Объемно и содержательно.");
        template.save(comment1);

        comment2 = new Comment();
        comment2.setComment("Жалко, что Spring Security плохо расписан");
        template.save(comment2);

        comment3 = new Comment();
        comment3.setComment("Рассмотрены нововведения в версии 8-11");
        template.save(comment3);

        comment4 = new Comment();
        comment4.setComment("Описаны внутренности JVM");
        template.save(comment4);

        comment5 = new Comment();
        comment5.setComment("Сборник рецептов.");
        template.save(comment5);

        comment6 = new Comment();
        comment6.setComment("Не плохая книга");
        template.save(comment6);
    }

    @ChangeSet(order = "003", id = "insert-authors-003", author = "s.ovodkov")
    public void authorsInsertDb(MongockTemplate template) {
        BookDto spring5 = new BookDto();
        spring5.setTitle("Spring 5. Для профессионалов");
        spring5.setEdition(5);
        spring5.setYearPublishing(2019);

        List<BookDto> books1 = List.of(spring5);

        Author kozmina = new Author();
        kozmina.setFirstName("Юлиана");
        kozmina.setLastName("Козмина");
        kozmina.setBooks(books1);
        template.save(kozmina);

        Author rob = new Author();
        rob.setFirstName("Роб");
        rob.setLastName("Харроп");
        rob.setBooks(books1);
        template.save(rob);

        Author shefer = new Author();
        shefer.setFirstName("Крис");
        shefer.setLastName("Шефер");
        shefer.setBooks(books1);
        template.save(shefer);

        Author ho = new Author();
        ho.setFirstName("Кларенс");
        ho.setLastName("Хо");
        ho.setBooks(books1);
        template.save(ho);

        BookDto modernJava = new BookDto();
        modernJava.setTitle("Современный язык Java");
        modernJava.setEdition(2);
        modernJava.setYearPublishing(2020);

        List<BookDto> books2 = List.of(modernJava);

        Author urma = new Author();
        urma.setFirstName("Рауль-Габриэль");
        urma.setLastName("Урма");
        urma.setBooks(books2);
        template.save(urma);

        Author fusko = new Author();
        fusko.setFirstName("Марио");
        fusko.setLastName("Фуско");
        fusko.setBooks(books2);
        template.save(fusko);

        Author alan = new Author();
        alan.setFirstName("Алан");
        alan.setLastName("Майкрофт");
        alan.setBooks(books2);
        template.save(alan);

        BookDto performanceJava = new BookDto();
        performanceJava.setTitle("Java: оптимизация программ");
        performanceJava.setEdition(1);
        performanceJava.setYearPublishing(2019);

        List<BookDto> books3 = List.of(performanceJava);

        Author evans = new Author();
        evans.setFirstName("Бенджамин");
        evans.setLastName("Эванс");
        evans.setBooks(books3);
        template.save(evans);

        Author gof = new Author();
        gof.setFirstName("Джеймс");
        gof.setLastName("Гоф");
        gof.setBooks(books3);
        template.save(gof);

        Author kris = new Author();
        kris.setFirstName("Крис");
        kris.setLastName("Ньюланд");
        kris.setBooks(books3);
        template.save(kris);

        BookDto effectJava = new BookDto();
        effectJava.setTitle("Java: эффективное программирование");
        effectJava.setEdition(3);
        effectJava.setYearPublishing(2019);

        Author bloh = new Author();
        bloh.setFirstName("Джошуа");
        bloh.setLastName("Блох");
        bloh.setBooks(List.of(effectJava));
        template.save(bloh);

        BookDto springPatterns = new BookDto();
        springPatterns.setTitle("Spring. Все паттерны проектирования");
        springPatterns.setEdition(1);
        springPatterns.setYearPublishing(2019);

        Author dinesh = new Author();
        dinesh.setFirstName("Динеш");
        dinesh.setLastName("Раджупт");
        dinesh.setBooks(List.of(springPatterns));
        template.save(dinesh);
    }

    @ChangeSet(order = "004", id = "insert-books-004", author = "s.ovodkov")
    public void booksInsertDb(MongockTemplate template) {
        AuthorDto kozmina = new AuthorDto();
        kozmina.setFirstName("Юлиана");
        kozmina.setLastName("Козмина");

        AuthorDto rob = new AuthorDto();
        rob.setFirstName("Роб");
        rob.setLastName("Харроп");

        AuthorDto shefer = new AuthorDto();
        shefer.setFirstName("Крис");
        shefer.setLastName("Шефер");

        AuthorDto ho = new AuthorDto();
        ho.setFirstName("Кларенс");
        ho.setLastName("Хо");

        Book spring5 = new Book();
        spring5.setTitle("Spring 5. Для профессионалов");
        spring5.setEdition(5);
        spring5.setYearPublishing(2019);
        spring5.setAuthors(List.of(kozmina, rob, shefer, ho));
        spring5.setGenres(List.of(GENRE_SPRING, GENRE_JAVA));
        spring5.setComments(List.of(comment1, comment2));
        template.save(spring5);

        AuthorDto urma = new AuthorDto();
        urma.setFirstName("Рауль-Габриэль");
        urma.setLastName("Урма");

        AuthorDto fusko = new AuthorDto();
        fusko.setFirstName("Марио");
        fusko.setLastName("Фуско");

        AuthorDto alan = new AuthorDto();
        alan.setFirstName("Алан");
        alan.setLastName("Майкрофт");

        Book modernJava = new Book();
        modernJava.setTitle("Современный язык Java");
        modernJava.setEdition(2);
        modernJava.setYearPublishing(2020);
        modernJava.setAuthors(List.of(urma, fusko, alan));
        modernJava.setGenres(List.of(GENRE_JAVA));
        modernJava.setComments(List.of(comment3));
        template.save(modernJava);

        AuthorDto evans = new AuthorDto();
        evans.setFirstName("Бенджамин");
        evans.setLastName("Эванс");

        AuthorDto gof = new AuthorDto();
        gof.setFirstName("Джеймс");
        gof.setLastName("Гоф");

        AuthorDto kris = new AuthorDto();
        kris.setFirstName("Крис");
        kris.setLastName("Ньюланд");

        Book performanceJava = new Book();
        performanceJava.setTitle("Java: оптимизация программ");
        performanceJava.setEdition(1);
        performanceJava.setYearPublishing(2019);
        performanceJava.setAuthors(List.of(evans, gof, kris));
        performanceJava.setGenres(List.of(GENRE_JAVA));
        performanceJava.setComments(List.of(comment4));
        template.save(performanceJava);

        AuthorDto bloh = new AuthorDto();
        bloh.setFirstName("Джошуа");
        bloh.setLastName("Блох");

        Book effectJava = new Book();
        effectJava.setTitle("Java: эффективное программирование");
        effectJava.setEdition(3);
        effectJava.setYearPublishing(2019);
        effectJava.setAuthors(List.of(bloh));
        effectJava.setGenres(List.of(GENRE_JAVA));
        effectJava.setComments(List.of(comment5));
        template.save(effectJava);

        AuthorDto dinesh = new AuthorDto();
        dinesh.setFirstName("Динеш");
        dinesh.setLastName("Раджупт");

        Book springPatterns = new Book();
        springPatterns.setTitle("Spring. Все паттерны проектирования");
        springPatterns.setEdition(1);
        springPatterns.setYearPublishing(2019);
        springPatterns.setAuthors(List.of(dinesh));
        springPatterns.setGenres(List.of(GENRE_SPRING, GENRE_JAVA));
        springPatterns.setComments(List.of(comment6));
        template.save(springPatterns);
    }
}
