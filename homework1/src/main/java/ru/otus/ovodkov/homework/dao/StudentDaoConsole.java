package ru.otus.ovodkov.homework.dao;

import ru.otus.ovodkov.homework.domain.Student;

import java.util.Scanner;

/**
 * Получение данных студента посредством консоли.
 *
 * @author Sergey Ovodkov
 */
public class StudentDaoConsole implements StudentDao {
    /**
     * @see StudentDao#getStudentPersonalData()
     */
    public Student getStudentPersonalData() {
        Scanner in = new Scanner(System.in);
        System.out.print("Укажите Ваше имя: ");
        String firstName = in.nextLine();
        System.out.print("Укажите Вашу фамилию: ");
        String lastName = in.nextLine();
        return new Student(firstName, lastName);
    }
}
