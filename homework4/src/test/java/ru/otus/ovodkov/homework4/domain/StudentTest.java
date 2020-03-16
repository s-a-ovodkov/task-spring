package ru.otus.ovodkov.homework4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Доменная модель Student")
public class StudentTest {

    private final String firstName = "Ivan";
    private final String lastName = "Petrov";

    @DisplayName("модель корректно создается конструктором")
    @Test
    void shouldHaveCorrectConstructor() {
        Student student = new Student(firstName, lastName);

        assertAll("student",
                () -> assertEquals(firstName, student.getFirstName()),
                () -> assertEquals(lastName, student.getLastName()));
    }

    @DisplayName("корректно создается строковое представление модели")
    @Test
    void shouldHaveCorrectToString() {
        Student student = new Student(firstName, lastName);
        String expected = firstName + " " + lastName;

        assertEquals(expected, student.toString());
    }
}
