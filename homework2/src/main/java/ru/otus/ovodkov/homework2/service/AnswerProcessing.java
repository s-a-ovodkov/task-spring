package ru.otus.ovodkov.homework2.service;

/**
 * Сервис получения ответов студентов
 *
 * @author Sergey Ovodkov
 * @project homework2
 * @created 2020-03-05
 */
public interface AnswerProcessing {
    /**
     * Получение выбранного варианта ответа.
     *
     * @return Номер выбранного студентом варианта ответа
     */
    int getAnswer();
}
