package ru.otus.ovodkov.homework.domain;

import java.util.List;

/**
 * Вопрос тестирования
 *
 * @author ovodkov.s
 */
public class Question {

    private String question;
    private List<String> answerOptions;
    private int correctAnswer;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getAnswerOptions() {
        return answerOptions;
    }

    public void setAnswerOptions(List<String> answerOptions) {
        this.answerOptions = answerOptions;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    /**
     * .ctor
     *
     * @param question      Тело вопроса
     * @param answerOptions Список вариантов ответов.
     * @param correctAnswer Номер правильного варианта ответа.
     */
    public Question(String question, List<String> answerOptions, int correctAnswer) {
        this.question = question;
        this.answerOptions = answerOptions;
        this.correctAnswer = correctAnswer;
    }
}
