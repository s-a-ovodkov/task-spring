package ru.otus.ovodkov.homework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.otus.ovodkov.homework.services.StudentTestingService;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        StudentTestingService service = context.getBean(StudentTestingService.class);
        service.studentTesting();
    }
}
