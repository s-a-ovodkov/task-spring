package ru.otus.ovodkov.homework4.services;

import ru.otus.ovodkov.homework4.domain.TestResult;

/**
 * Отображение результатов тестирования.
 *
 * @author Sergey Ovodkov
 */
public interface RenderTestResult {
    /**
     * Отображение результатов тестирования.
     *
     * @param testResult   Результат пройденного теста.
     */
    void showTestResult(TestResult testResult);
}
