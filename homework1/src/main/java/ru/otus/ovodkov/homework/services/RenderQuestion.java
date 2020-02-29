package ru.otus.ovodkov.homework.services;

import ru.otus.ovodkov.homework.domain.Question;

/**
 * Сервис отображения вопроса
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
