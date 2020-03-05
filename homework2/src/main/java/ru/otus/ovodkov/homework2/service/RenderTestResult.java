package ru.otus.ovodkov.homework2.service;

import ru.otus.ovodkov.homework2.domain.TestResult;

/**
 * Отображение результатов тестирования.
 *
 * @author Sergey Ovodkov
 * @project homework2
 * @created 2020-03-05
 */
public interface RenderTestResult {
    /**
     * Отображение результатов тестирования.
     *
     * @param testResult Результат пройденного теста.
     */
    void showTestResult(TestResult testResult);
}
