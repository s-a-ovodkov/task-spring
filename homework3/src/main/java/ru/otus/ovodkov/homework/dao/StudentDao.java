package ru.otus.ovodkov.homework.dao;

import ru.otus.ovodkov.homework.domain.Student;

/**
 * Получение данных о студенте
 *
 * @author Sergey Ovodkov
 */
public interface StudentDao {

    /**
     * Получение данных студента.
     *
     * @return Данные студента.
     */
    Student getStudentPersonalData();
}