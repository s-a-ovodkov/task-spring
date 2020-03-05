package ru.otus.ovodkov.homework2.domain;

/**
 * Модель данных результата тестирования
 *
 * @author Sergey Ovodkov
 * @project homework2
 * @created 2020-03-05
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
