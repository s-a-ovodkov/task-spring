package ru.otus.ovodkov.homework2.service;

import ru.otus.ovodkov.homework2.domain.Question;

/**
 * Сервис отображения вопроса
 *
 * @author Sergey Ovodkov
 * @project homework2
 * @created 2020-03-05
 */
public interface RenderQuestion {
    /**
     * Отображение вопроса.
     *
     * @param question Вопрос, который необходимо показать студенту.
     */
    void showQuestion(Question question);
}
