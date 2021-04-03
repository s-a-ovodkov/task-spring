package ru.otus.ovodkov.homework2.service;

import org.springframework.stereotype.Service;
import ru.otus.ovodkov.homework2.domain.Question;

/**
 * @author Sergey Ovodkov
 * @project homework2
 * @created 2020-03-05
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
