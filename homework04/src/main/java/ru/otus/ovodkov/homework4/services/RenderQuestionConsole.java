package ru.otus.ovodkov.homework4.services;

import org.springframework.stereotype.Service;
import ru.otus.ovodkov.homework4.domain.Question;

/**
 * @author Sergey Ovodkov
 * @see RenderQuestion
 */
@Service
public class RenderQuestionConsole implements RenderQuestion {
    /**
     * @see RenderQuestion#showQuestion(Question)
     */
    public void showQuestion(Question question) {
        System.out.println(question.getQuestion());
        System.out.println("\t" + question.getPossibleAnswer1());
        System.out.println("\t" + question.getPossibleAnswer2());
        System.out.println("\t" + question.getPossibleAnswer3());
        System.out.println("\t" + question.getPossibleAnswer4());
    }
}
