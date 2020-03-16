package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.ovodkov.homework4.domain.Student;
import ru.otus.ovodkov.homework4.domain.TestResult;

@DisplayName("Доменная модель TestResult")
public class TestResultTest {

    private final int countCorrectAnswers = 4;
    private final Student student = new Student("Ivan", "Petrov");

    @DisplayName("модель корректно создается конструктором")
    @Test
    void shouldHaveCorrectConstructor() {
        TestResult testResult = new TestResult(student, countCorrectAnswers);

        Assertions.assertEquals(countCorrectAnswers, testResult.getCountCorrectAnswers());
        Assertions.assertSame(student, testResult.getStudent());
    }
}
