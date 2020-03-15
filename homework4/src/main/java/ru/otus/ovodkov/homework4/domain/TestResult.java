package ru.otus.ovodkov.homework4.domain;

/**
 * Модель данных результата тестирования
 *
 * @author Sergey Ovodkov
 */
public class TestResult {

    private final Student student;
    private final int countCorrectAnswers;

    public Student getStudent() {
        return student;
    }

    public int getCountCorrectAnswers() {
        return countCorrectAnswers;
    }

    /**
     * .ctor
     *
     * @param student             Данные тестируемого студента.
     * @param countCorrectAnswers Количество правильных ответов.
     */
    public TestResult(Student student, int countCorrectAnswers) {
        this.student = student;
        this.countCorrectAnswers = countCorrectAnswers;
    }
}