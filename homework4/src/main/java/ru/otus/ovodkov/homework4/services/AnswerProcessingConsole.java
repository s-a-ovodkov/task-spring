package ru.otus.ovodkov.homework4.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.ovodkov.homework4.config.properties.LocaleProperty;

import java.util.Locale;
import java.util.Scanner;

/**
 * @author Sergey Ovodkov
 * @see AnswerProcessing
 */
@Service
public class AnswerProcessingConsole implements AnswerProcessing {

    private final MessageSource messageSource;
    private final LocaleProperty localeProperty;

    @Autowired
    public AnswerProcessingConsole(MessageSource messageSource,
                                   LocaleProperty localeProperty) {
        this.messageSource = messageSource;
        this.localeProperty = localeProperty;
    }

    /**
     * @see AnswerProcessing#getAnswer()
     */
    public int getAnswer() {
        Locale useAppLocale = new Locale(localeProperty.getLanguage(), localeProperty.getCountry());
        Scanner in = new Scanner(System.in);
        System.out.print(messageSource.getMessage("answer.processing", null, useAppLocale));
        return in.nextInt();
    }
}
