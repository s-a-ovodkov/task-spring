package ru.otus.ovodkov.homework.dao;

import ru.otus.ovodkov.homework.domain.Question;

import java.util.List;

/**
 * Список вопросов для тестирования
 *
 * @author Sergey Ovodkov
 */
public interface QuestionsDao {

    /**
     * Получение списка вопросов для тестирования
     *
     * @return Список вопросов тестирования
     */
    List<Question> getQuestions();
}
