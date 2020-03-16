package ru.otus.ovodkov.homework.services;

import ru.otus.ovodkov.homework.domain.TestResult;

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
     * @param isPassedTest Признак того, что тест сдан.
     */
    void showTestResult(TestResult testResult, boolean isPassedTest);
}

