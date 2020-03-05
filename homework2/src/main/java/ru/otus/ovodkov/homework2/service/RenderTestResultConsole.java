package ru.otus.ovodkov.homework2.service;

import ru.otus.ovodkov.homework2.domain.TestResult;

/**
 * @see RenderTestResult
 *
 * @author Sergey Ovodkov
 * @project homework2
 * @created 2020-03-05
 */
public class RenderTestResultConsole implements RenderTestResult {
    /**
     * @see RenderTestResult#showTestResult(TestResult)
     */
    public void showTestResult(TestResult testResult) {
        System.out.println("\nРезультаты тестирования:");
        System.out.println("Студент:\t" + testResult.getStudent().toString());
        System.out.println("Результат:\t" + testResult.getCountCorrectAnswers());
    }
}
