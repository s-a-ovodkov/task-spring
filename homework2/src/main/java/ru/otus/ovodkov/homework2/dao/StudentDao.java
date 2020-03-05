package ru.otus.ovodkov.homework2.dao;

import ru.otus.ovodkov.homework2.domain.Student;

/**
 * Получение данных о студенте
 *
 * @author Sergey Ovodkov
 * @project homework2
 * @created 2020-03-05
 */
public interface StudentDao {

    /**
     * Получение данных студента.
     *
     * @return Данные студента.
     */
    Student getStudentPersonalData();
}
