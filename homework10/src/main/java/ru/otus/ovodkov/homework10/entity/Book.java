package ru.otus.ovodkov.homework10.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 * Модель книги
 *
 * @author Ovodkov Sergey
 * created on 11.08.2020
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "Books")
@NamedEntityGraph(name = "bookEntityGraph", attributeNodes = {
        @NamedAttributeNode("comments"),
        @NamedAttributeNode("authors"),
        @NamedAttributeNode("genres")
})
public class Book {

    /**
     * Идентификатор книги
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idBook")
    private long idBook;

    /**
     * Название книги
     */
    @Column(name = "titleBook")
    private String titleBook;

    /**
     * Издание книги
     */
    @Column(name = "edition")
    private int edition;

    /**
     * Год издания книги
     */
    @Column(name = "yearPublishing")
    private int yearPublishing;

    /**
     * Комментарии к книги
     */
    @JsonBackReference
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private Set<Comment> comments;

    /**
     * Авторы книги
     */
    @JsonBackReference
    @ManyToMany(targetEntity = Author.class, cascade = CascadeType.ALL)
    @JoinTable(name = "AuthorsBooks",
            joinColumns = @JoinColumn(name = "idBook", referencedColumnName = "idBook"),
            inverseJoinColumns = @JoinColumn(name = "idAuthor", referencedColumnName = "idAuthor"))
    private Set<Author> authors;

    /**
     * Жанры книги
     */
    @JsonBackReference
    @ManyToMany(targetEntity = Genre.class, cascade = CascadeType.ALL)
    @JoinTable(name = "GenresBooks",
            joinColumns = @JoinColumn(name = "idBook", referencedColumnName = "idBook"),
            inverseJoinColumns = @JoinColumn(name = "idGenre", referencedColumnName = "idGenre"))
    private Set<Genre> genres;
}
