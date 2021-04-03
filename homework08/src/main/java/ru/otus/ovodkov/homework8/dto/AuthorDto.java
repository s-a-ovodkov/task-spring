package ru.otus.ovodkov.homework8.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Ovodkov Sergey
 * created on 19.08.2020
 */
@Getter
@Setter
public class AuthorDto {
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
        return firstName + " " + lastName;
    }
}
