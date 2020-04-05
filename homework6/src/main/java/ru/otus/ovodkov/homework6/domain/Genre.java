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
    @ManyToMany(mappedBy = "genres")
    private Set<Book> books;
}
