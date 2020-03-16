package ru.otus.ovodkov.homework.services;

/**
 * Сервис получения ответов студентов
 *
 * @author Sergey Ovodkov
 */
public interface AnswerProcessing {
    /**
     * Получение выбранного варианта ответа.
     *
     * @return Номер выбранного студентом варианта ответа
     */
    int getAnswer();
}
