package ru.otus.ovodkov.homework2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.otus.ovodkov.homework2.service.StudentTestingService;

@Configuration
@ComponentScan
public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Application.class);

        StudentTestingService service = context.getBean(StudentTestingService.class);
        service.studentTesting();
    }
}
