package ru.otus.ovodkov.homework.services;

import ru.otus.ovodkov.homework.domain.TestResult;

/**
 * Отображение результатов тестирования студента в консоль
 *
 * @author Sergey Ovodkov
 */
public class RenderTestResultConsole implements RenderTestResult {
    /**
     * Отображение результатов тестирования студента в консоль.
     *
     * @param testResult Результат пройденного теста.
     */
    public void showTestResult(TestResult testResult) {
        System.out.println("\nРезультаты тестирования:");
        System.out.println("Студент:\t" + testResult.getStudent().toString());
        System.out.println("Результат:\t" + testResult.getCountCorrectAnswers());
    }
}
