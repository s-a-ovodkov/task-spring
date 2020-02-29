package ru.otus.ovodkov.homework.domain;

/**
 * Результаты тестирования
 *
 * @author Sergey Ovodkov
 */
public class TestResult {
    private Student student;
    private int countCorrectAnswers;

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
