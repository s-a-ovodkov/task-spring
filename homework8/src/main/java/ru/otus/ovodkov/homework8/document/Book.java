package ru.otus.ovodkov.homework8.document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Документ описывающий книгу
 *
 * @author Ovodkov Sergey on 11.08.2020
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
    private List<Author> authors;

    /**
     * Список комментариев к книге
     */
    @DBRef
    private List<Comment> comments;
}
