package ru.otus.ovodkov.homework5.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Доменная модель автор книги
 *
 * @author Sergey Ovodkov
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Author {
    /**
     * Идентификатор автора книги
     */
    private long idAuthor;

    /**
     * Имя автора
     */
    private String firstName;

    /**
     * Фамилия автора
     */
    private String lastName;

    @Override
    public String toString() {
        return "Author{" +
                "idAuthor=" + idAuthor +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
