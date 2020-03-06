package ru.otus.ovodkov.homework2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.ovodkov.homework2.domain.TestResult;

import java.util.Locale;

/**
 * @author Sergey Ovodkov
 * @project homework2
 * @created 2020-03-05
 * @see RenderTestResult
 */
@Service
public class RenderTestResultConsole implements RenderTestResult {

    private final MessageSource messageSource;
    private final Locale useAppLocale;

    @Autowired
    public RenderTestResultConsole(MessageSource messageSource,
                                   Locale useAppLocale) {
        this.messageSource = messageSource;
        this.useAppLocale = useAppLocale;
    }

    /**
     * @see RenderTestResult#showTestResult(TestResult, boolean)
     */
    public void showTestResult(TestResult testResult, boolean isPassedTest) {
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
