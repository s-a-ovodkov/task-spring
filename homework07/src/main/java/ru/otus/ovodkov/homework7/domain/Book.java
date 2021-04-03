package ru.otus.ovodkov.homework7.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 * Доменная модель книги
 *
 * @author Ovodkov Sergey on 10.04.2020
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
     * Номер издания
     */
    @Column(name = "edition")
    private int edition;

    /**
     * Год издания книги
     */
    @Column(name = "yearPublishing")
    private int yearPublishing;

    /**
     * Список комментариев к книги
     */
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private Set<Comment> comments;

    /**
     * Список авторов книги
     */
    @ManyToMany(targetEntity = Author.class, cascade = CascadeType.ALL)
    @JoinTable(name = "AuthorsBooks",
            joinColumns = @JoinColumn(name = "idBook", referencedColumnName = "idBook"),
            inverseJoinColumns = @JoinColumn(name = "idAuthor", referencedColumnName = "idAuthor"))
    private Set<Author> authors;

    /**
     * Список жанров книги
     */
    @ManyToMany(targetEntity = Genre.class, cascade = CascadeType.ALL)
    @JoinTable(name = "GenresBooks",
            joinColumns = @JoinColumn(name = "idBook", referencedColumnName = "idBook"),
            inverseJoinColumns = @JoinColumn(name = "idGenre", referencedColumnName = "idGenre"))
    private Set<Genre> genres;

    @Override
    public String toString() {
        return "Book{" +
                " idBook=" + idBook +
                ", titleBook='" + titleBook + '\'' +
                ", edition=" + edition +
                ", yearPublishing=" + yearPublishing +
                " }";
    }
}
