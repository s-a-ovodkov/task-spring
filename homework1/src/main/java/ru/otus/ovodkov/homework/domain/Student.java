package ru.otus.ovodkov.homework.domain;

/**
 * Данные тестируемого студента
 *
 * @author ovodkov.s
 */
public class Student {

    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * .ctor
     *
     * @param firstName Имя студента.
     * @param lastName  Фамилия студента.
     */
    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
