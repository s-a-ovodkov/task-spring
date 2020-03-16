package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.ovodkov.homework4.domain.Question;

@DisplayName("Доменная модель Question")
public class QuestionTest {

    private final String questionText = "question";
    private final String possibleAnswer1 = "possibleAnswer1";
    private final String possibleAnswer2 = "possibleAnswer2";
    private final String possibleAnswer3 = "possibleAnswer3";
    private final String possibleAnswer4 = "possibleAnswer4";
    private final int correctAnswer = 3;

    @DisplayName("модель корректно создается конструктором")
    @Test
    void shouldHaveCorrectConstructor() {
        Question question = new Question(questionText,
                possibleAnswer1,
                possibleAnswer2,
                possibleAnswer3,
                possibleAnswer4,
                correctAnswer);

        Assertions.assertEquals(questionText, question.getQuestion());
        Assertions.assertEquals(possibleAnswer1, question.getPossibleAnswer1());
        Assertions.assertEquals(possibleAnswer2, question.getPossibleAnswer2());
        Assertions.assertEquals(possibleAnswer3, question.getPossibleAnswer3());
        Assertions.assertEquals(possibleAnswer4, question.getPossibleAnswer4());
        Assertions.assertEquals(correctAnswer, question.getCorrectAnswer());
    }
}
