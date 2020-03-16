package ru.otus.ovodkov.homework4.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;
import ru.otus.ovodkov.homework4.config.properties.LocaleProperty;
import ru.otus.ovodkov.homework4.dao.StudentDao;
import ru.otus.ovodkov.homework4.domain.Student;
import ru.otus.ovodkov.homework4.domain.TestResult;
import ru.otus.ovodkov.homework4.services.RenderTestResult;
import ru.otus.ovodkov.homework4.services.StudentTestingService;

import java.util.Locale;

@ShellComponent
public class ApplicationCommands {

    private Student student;
    private TestResult testResult;

    private final MessageSource messageSource;
    private final StudentDao studentDao;
    private final StudentTestingService testingService;
    private final RenderTestResult renderTestResult;
    private final LocaleProperty localeProperty;

    private final Locale useAppLocale;

    public ApplicationCommands(MessageSource messageSource,
                               StudentDao studentDao,
                               StudentTestingService testingService,
                               RenderTestResult renderTestResult,
                               LocaleProperty localeProperty) {
        this.messageSource = messageSource;
        this.studentDao = studentDao;
        this.testingService = testingService;
        this.renderTestResult = renderTestResult;
        this.localeProperty = localeProperty;

        useAppLocale = new Locale(localeProperty.getLanguage(), localeProperty.getCountry());
    }

    @ShellMethod(value = "Login command", key = {"l", "login"})
    public String login() {
        student = studentDao.getStudentPersonalData();
        return messageSource.getMessage("shell.login", new String[]{student.toString()}, useAppLocale);
    }

    @ShellMethod(value = "Start testing", key = {"s", "start"})
    @ShellMethodAvailability(value = "isLoggedStudentCommandAvailable")
    public String start() {
        testResult = testingService.studentTesting(student);
        return messageSource.getMessage("shell.testing", null, useAppLocale);
    }

    @ShellMethod(value = "Show test result", key = {"r", "result"})
    @ShellMethodAvailability(value = "isTestFinishedCommandAvailable")
    public void showResult() {
        renderTestResult.showTestResult(testResult);
    }

    private Availability isLoggedStudentCommandAvailable() {
        return student == null
                ? Availability.unavailable(messageSource.getMessage("shell.testing.unavailable", null, useAppLocale))
                : Availability.available();
    }

    private Availability isTestFinishedCommandAvailable() {
        if (testResult == null && student == null) {
            return Availability.unavailable(messageSource.getMessage("shell.testing.unavailable", null, useAppLocale));
        }
        if (testResult == null && student != null) {
            return Availability.unavailable(messageSource.getMessage("shell.result.unavailable", null, useAppLocale));
        }
        return Availability.available();
    }
}
