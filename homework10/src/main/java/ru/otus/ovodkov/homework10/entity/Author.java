package ru.otus.ovodkov.homework10.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 * Модель автора книг
 *
 * @author Ovodkov Sergey
 * created on 11.08.2020
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "Authors")
@NamedEntityGraph(name = "authorEntityGraph", attributeNodes = {@NamedAttributeNode("books")})
public class Author {

    /**
     * Идентификатор автора
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
     * Книги автора
     */
    @JsonBackReference
    @ManyToMany(mappedBy = "authors", fetch = FetchType.LAZY)
    private Set<Book> books;
}
