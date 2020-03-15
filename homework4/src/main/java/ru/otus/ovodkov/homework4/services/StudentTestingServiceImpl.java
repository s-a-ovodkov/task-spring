package ru.otus.ovodkov.homework4.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.ovodkov.homework4.config.properties.AnswerProperty;
import ru.otus.ovodkov.homework4.dao.QuestionsDao;
import ru.otus.ovodkov.homework4.dao.StudentDao;
import ru.otus.ovodkov.homework4.domain.Question;
import ru.otus.ovodkov.homework4.domain.Student;
import ru.otus.ovodkov.homework4.domain.TestResult;

import java.util.List;

/**
 * Сервис тестирования студентов
 *
 * @author Sergey Ovodkov
 * @project homework2
 * @created 2020-03-05
 * @see StudentTestingService
 */
@Service
public class StudentTestingServiceImpl implements StudentTestingService {

    private final QuestionsDao questionsDao;
    private final RenderQuestion renderQuestion;
    private final AnswerProcessing answerProcessing;

    @Autowired
    public StudentTestingServiceImpl(QuestionsDao questionsDao,
                                     RenderQuestion renderQuestion,
                                     AnswerProcessing answerProcessing) {
        this.questionsDao = questionsDao;
        this.renderQuestion = renderQuestion;
        this.answerProcessing = answerProcessing;
    }

    /**
     * @see StudentTestingService#studentTesting(Student)
     */
    public TestResult studentTesting(Student student) {
        List<Question> questions = questionsDao.getQuestions();

        int countCorrectAnswer = 0;

        for (Question question : questions) {
            renderQuestion.showQuestion(question);
            countCorrectAnswer += answerProcessing.getAnswer() == question.getCorrectAnswer() ? 1 : 0;
        }

        return new TestResult(student, countCorrectAnswer);
    }
}
