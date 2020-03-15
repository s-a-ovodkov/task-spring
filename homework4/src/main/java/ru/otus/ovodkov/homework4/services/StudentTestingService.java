package ru.otus.ovodkov.homework4.services;

import ru.otus.ovodkov.homework4.domain.Student;
import ru.otus.ovodkov.homework4.domain.TestResult;

/**
 * Сервис тестирования студентов
 *
 * @author Sergey Ovodkov
 */
public interface StudentTestingService {
    /**
     * Запуск процесса тестирования студента.
     */
    TestResult studentTesting(Student student);
}
