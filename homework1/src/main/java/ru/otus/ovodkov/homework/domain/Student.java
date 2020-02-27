package ru.otus.ovodkov.homework.domain;

/**
 * Данные тестируемого студента
 *
 * @author ovodkov.s
 */
public class Student {

    private String FirstName;
    private String LastName;

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    /**
     * .ctor
     *
     * @param firstName Имя студента.
     * @param lastName  Фамилия студента.
     */
    public Student(String firstName, String lastName) {
        FirstName = firstName;
        LastName = lastName;
    }
}
