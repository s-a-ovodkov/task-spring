package ru.otus.ovodkov.homework4.domain;

import com.opencsv.bean.CsvBindByPosition;

/**
 * Доменная модель вопроса из теста
 *
 * @author Sergey Ovodkov
 */
public class Question {

    @CsvBindByPosition(position = 0)
    private String question;
    @CsvBindByPosition(position = 1)
    private String possibleAnswer1;
    @CsvBindByPosition(position = 2)
    private String possibleAnswer2;
    @CsvBindByPosition(position = 3)
    private String possibleAnswer3;
    @CsvBindByPosition(position = 4)
    private String possibleAnswer4;
    @CsvBindByPosition(position = 5)
    private int correctAnswer;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getPossibleAnswer1() {
        return possibleAnswer1;
    }

    public void setPossibleAnswer1(String possibleAnswer1) {
        this.possibleAnswer1 = possibleAnswer1;
    }

    public String getPossibleAnswer2() {
        return possibleAnswer2;
    }

    public void setPossibleAnswer2(String possibleAnswer2) {
        this.possibleAnswer2 = possibleAnswer2;
    }

    public String getPossibleAnswer3() {
        return possibleAnswer3;
    }

    public void setPossibleAnswer3(String possibleAnswer3) {
        this.possibleAnswer3 = possibleAnswer3;
    }

    public String getPossibleAnswer4() {
        return possibleAnswer4;
    }

    public void setPossibleAnswer4(String possibleAnswer4) {
        this.possibleAnswer4 = possibleAnswer4;
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
     * @see Question#Question(String, String, String, String, String, int)
     */
    public Question() {
    }

    /**
     * .ctor
     *
     * @param question        Вопрос теста.
     * @param possibleAnswer1 Первый вариант ответа на вопрос.
     * @param possibleAnswer2 Второй вариант ответа на вопрос.
     * @param possibleAnswer3 Третий вариант ответа на вопрос.
     * @param possibleAnswer4 Четвертый вариант ответа на вопрос.
     * @param correctAnswer   Номер правильного варианта ответа.
     * @see Question#Question()
     */
    public Question(String question, String possibleAnswer1, String possibleAnswer2, String possibleAnswer3, String possibleAnswer4, int correctAnswer) {
        this.question = question;
        this.possibleAnswer1 = possibleAnswer1;
        this.possibleAnswer2 = possibleAnswer2;
        this.possibleAnswer3 = possibleAnswer3;
        this.possibleAnswer4 = possibleAnswer4;
        this.correctAnswer = correctAnswer;
    }
}
