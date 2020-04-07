package ru.otus.ovodkov.homework6.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Доменная модель книги
 *
 * @author Ovodkov Sergey
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
    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Comment> comments;

    /**
     * Список авторов книги
     */
    @ManyToMany(targetEntity = Author.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "AuthorsBooks",
            joinColumns = @JoinColumn(name = "idBook", referencedColumnName = "idBook"),
            inverseJoinColumns = @JoinColumn(name = "idAuthor", referencedColumnName = "idAuthor"))
    private Set<Author> authors;

    /**
     * Список жанров книги
     */
    @ManyToMany(targetEntity = Genre.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "GenresBooks",
            joinColumns = @JoinColumn(name = "idBook", referencedColumnName = "idBook"),
            inverseJoinColumns = @JoinColumn(name = "idGenre", referencedColumnName = "idGenre"))
    private Set<Genre> genres;

    @Override
    public String toString() {
        String commentsStr = comments.stream()
                .map(x -> x.toString())
                .collect(Collectors.joining(" "));
        String authorsStr = authors.stream()
                .map(x -> x.toString())
                .collect(Collectors.joining(" "));
        String genreStr = genres.stream()
                .map(x -> x.toString())
                .collect(Collectors.joining(" "));
        return "Book{" +
                "idBook=" + idBook + ",\n\t" +
                "titleBook='" + titleBook + '\'' + ",\n\t" +
                "edition=" + edition + ",\n\t" +
                "yearPublishing=" + yearPublishing + ",\n\t" +
                "comments=" + commentsStr + ",\n\t" +
                "authors=" + authorsStr + ",\n\t" +
                "genres=" + genreStr + ",\n" +
                '}';
    }
}
