package ru.otus.ovodkov.homework.services;

import ru.otus.ovodkov.homework.domain.Question;

/**
 * @author Sergey Ovodkov
 * @see RenderQuestion
 */
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
