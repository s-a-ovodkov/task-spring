package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.ovodkov.homework4.domain.Student;

@DisplayName("Доменная модель Student")
public class StudentTest {

    private final String firstName = "Ivan";
    private final String lastName = "Petrov";

    @DisplayName("модель корректно создается конструктором")
    @Test
    void shouldHaveCorrectConstructor() {
        Student student = new Student(firstName, lastName);

        Assertions.assertEquals(firstName, student.getFirstName());
        Assertions.assertEquals(lastName, student.getLastName());
    }

    @DisplayName("корректно создается строковое представление модели")
    @Test
    void shouldHaveCorrectToString() {
        Student student = new Student(firstName, lastName);
        String expected = firstName + " " + lastName;

        Assertions.assertEquals(expected, student.toString());
    }
}
