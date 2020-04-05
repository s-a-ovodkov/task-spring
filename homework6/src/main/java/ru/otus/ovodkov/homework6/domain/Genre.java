package ru.otus.ovodkov.homework6.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

/**
 * Доменная модель описывающая жанр книги
 *
 * @author Ovodkov Sergey
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Genres")
@NamedEntityGraph(name = "genreEntityGraph", attributeNodes = {
        @NamedAttributeNode("books")
})
public class Genre {
    /**
     * Идентификатор жанра
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idGenre")
    private long idGenre;

    /**
     * Название жанра
     */
    @Column(name = "nameGenre")
    private String nameGenre;

    /**
     * Описание жанра
     */
    @Column(name = "descriptionGenre")
    private String descriptionGenre;

    /**
     * Книги данного жанра
     */
    @ManyToMany(mappedBy = "genres", fetch = FetchType.EAGER)
    private Set<Book> books;

    @Override
    public String toString() {
        return "Genre{" +
                "idGenre=" + idGenre +
                ", nameGenre='" + nameGenre + '\'' +
                ", descriptionGenre='" + descriptionGenre + '\'' +
                '}';
    }
}
