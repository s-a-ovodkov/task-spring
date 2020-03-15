package ru.otus.ovodkov.homework4.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.ovodkov.homework4.config.properties.AnswerProperty;
import ru.otus.ovodkov.homework4.config.properties.LocaleProperty;
import ru.otus.ovodkov.homework4.domain.TestResult;

import java.util.Locale;

/**
 * @author Sergey Ovodkov
 * @see RenderTestResult
 */
@Service
public class RenderTestResultConsole implements RenderTestResult {

    private final MessageSource messageSource;
    private final LocaleProperty localeProperty;
    private final AnswerProperty answerProperty;

    @Autowired
    public RenderTestResultConsole(MessageSource messageSource,
                                   LocaleProperty localeProperty,
                                   AnswerProperty answerProperty) {
        this.messageSource = messageSource;
        this.localeProperty = localeProperty;
        this.answerProperty = answerProperty;
    }

    /**
     * @see RenderTestResult#showTestResult(TestResult)
     */
    public void showTestResult(TestResult testResult) {
        Locale useAppLocale = new Locale(localeProperty.getLanguage(), localeProperty.getCountry());
        boolean isPassedTest = testResult.getCountCorrectAnswers() >= answerProperty.getSuccess();

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
