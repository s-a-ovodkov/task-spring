package ru.otus.ovodkov.homework.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.ovodkov.homework.config.properties.LocaleProperty;
import ru.otus.ovodkov.homework.domain.TestResult;

import java.util.Locale;

/**
 * @author Sergey Ovodkov
 * @see RenderTestResult
 */
@Service
public class RenderTestResultConsole implements RenderTestResult {

    private final MessageSource messageSource;
    private final LocaleProperty localeProperty;

    public RenderTestResultConsole(MessageSource messageSource,
                                   LocaleProperty localeProperty) {
        this.messageSource = messageSource;
        this.localeProperty = localeProperty;
    }

    /**
     * @see RenderTestResult#showTestResult(TestResult, boolean)
     */
    public void showTestResult(TestResult testResult, boolean isPassedTest) {
        Locale useAppLocale = new Locale(localeProperty.getLanguage(), localeProperty.getCountry());
        System.out.println();
        System.out.println(messageSource.getMessage("test.result", null, useAppLocale));

        System.out.println(messageSource.getMessage(
                "test.result.student",
                new String[]{testResult.getStudent().toString()},
                useAppLocale));

        System.out.println(messageSource.getMessage(
                "test.result.countAnswer",
                new Integer[]{testResult.getCountCorrectAnswers()},
                useAppLocale));

        String total = isPassedTest
                ? messageSource.getMessage("test.result.testPassed", null, useAppLocale)
                : messageSource.getMessage("test.result.testFailed", null, useAppLocale);

        System.out.println(messageSource.getMessage("test.result.testResults", new String[]{total}, useAppLocale));
    }
}

