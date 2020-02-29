package ru.otus.ovodkov.homework;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.ovodkov.homework.services.StudentTestingService;

/**
 * @author Sergey Ovodkov
 */
public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        StudentTestingService studentTestingService = context.getBean(StudentTestingService.class);
        studentTestingService.studentTesting();
    }
}
