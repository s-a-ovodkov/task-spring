package ru.otus.ovodkov.homework2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.otus.ovodkov.homework2.dao.StudentDao;
import ru.otus.ovodkov.homework2.domain.Student;

@Configuration
@ComponentScan
public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Application.class);

        StudentDao studentDao = context.getBean(StudentDao.class);
        Student result = studentDao.getStudentPersonalData();
        System.out.println(result);
    }
}
