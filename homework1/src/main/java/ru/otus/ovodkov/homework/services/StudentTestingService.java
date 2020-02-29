package ru.otus.ovodkov.homework.services;

import ru.otus.ovodkov.homework.domain.TestResult;

/**
 * Сервис тестирования студентов
 *
 * @author Sergey Ovodkov
 */
public interface StudentTestingService {
    /**
     * Запуск процесса тестирования студента.
     *
     * @return Результат пройденного теста.
     */
    TestResult studentTesting();
}
