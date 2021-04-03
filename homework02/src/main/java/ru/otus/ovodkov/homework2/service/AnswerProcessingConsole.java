package ru.otus.ovodkov.homework2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Scanner;

/**
 * @author Sergey Ovodkov
 * @project homework2
 * @created 2020-03-05
 * @see AnswerProcessing
 */
@Service
public class AnswerProcessingConsole implements AnswerProcessing {

    private final MessageSource messageSource;
    private final Locale useAppLocale;

    @Autowired
    public AnswerProcessingConsole(MessageSource messageSource,
                                   Locale useAppLocale) {
        this.messageSource = messageSource;
        this.useAppLocale = useAppLocale;
    }

    /**
     * @see AnswerProcessing#getAnswer()
     */
    public int getAnswer() {
        Scanner in = new Scanner(System.in);
        System.out.print(messageSource.getMessage("answer.processing", null, useAppLocale));
        return in.nextInt();
    }
}
