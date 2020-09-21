package ru.otus.ovodkov.homework11.document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import ru.otus.ovodkov.homework11.dto.AuthorDto;

import java.util.List;

/**
 * Документ описывающий книгу
 *
 * @author Ovodkov Sergey
 * created on 15.09.2020
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Document(collection = "books")
public class Book {

    @Id
    private ObjectId id;

    /**
     * Название книги
     */
    private String title;

    /**
     * Номер издания
     */
    private int edition;

    /**
     * Год издания книги
     */
    private int yearPublishing;

    /**
     * Список жанров книги
     */
    private List<String> genres;

    /**
     * Список авторов книг
     */
    private List<AuthorDto> authors;

    /**
     * Список комментариев к книге
     */
    @DBRef
    private List<Comment> comments;
}
