package ru.otus.ovodkov.homework4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Доменная модель TestResult")
public class TestResultTest {

    private final int countCorrectAnswers = 4;
    private final Student student = new Student("Ivan", "Petrov");

    @DisplayName("модель корректно создается конструктором")
    @Test
    void shouldHaveCorrectConstructor() {
        TestResult testResult = new TestResult(student, countCorrectAnswers);

        assertAll("testResult",
                () -> assertEquals(countCorrectAnswers, testResult.getCountCorrectAnswers()),
                () -> assertSame(student, testResult.getStudent()));
    }
}
