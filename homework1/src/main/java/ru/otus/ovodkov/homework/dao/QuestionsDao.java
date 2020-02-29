package ru.otus.ovodkov.homework.dao;

import ru.otus.ovodkov.homework.domain.Question;

import java.util.List;

/**
 * Получение списка вопросов для тестирования студента
 *
 * @author Sergey Ovodkov
 */
public interface QuestionsDao {
    /**
     * Получение списка вопросов.
     *
     * @return Список вопросов с ответами для тестирования
     */
    List<Question> getQuestions();
}
