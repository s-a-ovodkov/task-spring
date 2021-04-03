package ru.otus.ovodkov.homework4.services;

import ru.otus.ovodkov.homework4.domain.Question;

/**
 * Сервис отображения вопроса
 *
 * @author Sergey Ovodkov
 */
public interface RenderQuestion {
    /**
     * Отображение вопроса.
     *
     * @param question Вопрос, который необходимо показать студенту.
     */
    void showQuestion(Question question);
}
