package ru.otus.ovodkov.homework4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

        assertAll("question",
                () -> assertEquals(questionText, question.getQuestion()),
                () -> assertEquals(possibleAnswer1, question.getPossibleAnswer1()),
                () -> assertEquals(possibleAnswer2, question.getPossibleAnswer2()),
                () -> assertEquals(possibleAnswer3, question.getPossibleAnswer3()),
                () -> assertEquals(possibleAnswer4, question.getPossibleAnswer4()),
                () -> assertEquals(correctAnswer, question.getCorrectAnswer()));
    }
}
