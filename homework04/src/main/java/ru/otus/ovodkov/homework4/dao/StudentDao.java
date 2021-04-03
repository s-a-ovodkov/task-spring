package ru.otus.ovodkov.homework4.dao;

import ru.otus.ovodkov.homework4.domain.Student;

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