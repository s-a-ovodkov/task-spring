package ru.otus.ovodkov.homework6.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 * Доменная модель автор книги
 *
 * @author Sergey Ovodkov
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Authors")
public class Author {
    /**
     * Идентификатор автора книги
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAuthor;

    /**
     * Имя автора
     */
    @Column(name = "firstName")
    private String firstName;

    /**
     * Фамилия автора
     */
    @Column(name = "lastName")
    private String lastName;

    /**
     * Книги выбраного автора
     */
    @ManyToMany(mappedBy = "authors")
    private Set<Book> books;
}
