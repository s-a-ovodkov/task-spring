package ru.otus.ovodkov.homework.domain;

/**
 * Данные тестируемого студента
 *
 * @author Sergey Ovodkov
 */
public class Student {

    private final String firstName;
    private final String lastName;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
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

    public String toString(){
        return firstName + " " + lastName;
    }
}
