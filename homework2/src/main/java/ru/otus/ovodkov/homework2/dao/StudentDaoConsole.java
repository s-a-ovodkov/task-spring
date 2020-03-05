package ru.otus.ovodkov.homework2.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Repository;
import ru.otus.ovodkov.homework2.domain.Student;

import java.util.Locale;
import java.util.Scanner;

/**
 * Получение данных студента посредством консоли.
 *
 * @author Sergey Ovodkov
 * @project homework2
 * @created 2020-03-05
 */
@Repository
public class StudentDaoConsole implements StudentDao {

    @Autowired
    private MessageSource messageSource;

    /**
     * @see StudentDao#getStudentPersonalData()
     */
    public Student getStudentPersonalData() {
        Scanner in = new Scanner(System.in);
        System.out.print(messageSource.getMessage("student.firstName", null, Locale.ENGLISH));
        String firstName = in.nextLine();
        System.out.print(messageSource.getMessage("student.lastName", null, Locale.ENGLISH));
        String lastName = in.nextLine();
        return new Student(firstName, lastName);
    }
}
