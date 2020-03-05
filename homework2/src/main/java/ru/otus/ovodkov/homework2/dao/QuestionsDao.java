package ru.otus.ovodkov.homework2.dao;

import ru.otus.ovodkov.homework2.domain.Question;

import java.util.List;

/**
 * @author Sergey Ovodkov
 * @project homework2
 * @created 2020-03-05
 */
public interface QuestionsDao {

    List<Question> getQuestions();
}
