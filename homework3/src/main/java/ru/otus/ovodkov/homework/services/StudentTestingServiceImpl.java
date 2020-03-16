package ru.otus.ovodkov.homework.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.otus.ovodkov.homework.config.properties.AnswerProperty;
import ru.otus.ovodkov.homework.dao.QuestionsDao;
import ru.otus.ovodkov.homework.dao.StudentDao;
import ru.otus.ovodkov.homework.domain.Question;
import ru.otus.ovodkov.homework.domain.Student;
import ru.otus.ovodkov.homework.domain.TestResult;

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
    private final StudentDao studentDao;
    private final RenderQuestion renderQuestion;
    private final AnswerProcessing answerProcessing;
    private final RenderTestResult renderTestResult;
    private final AnswerProperty answerProperty;

    public StudentTestingServiceImpl(QuestionsDao questionsDao,
                                     StudentDao studentDao,
                                     RenderQuestion renderQuestion,
                                     AnswerProcessing answerProcessing,
                                     RenderTestResult renderTestResult,
                                     AnswerProperty answerProperty) {
        this.questionsDao = questionsDao;
        this.studentDao = studentDao;
        this.renderQuestion = renderQuestion;
        this.answerProcessing = answerProcessing;
        this.renderTestResult = renderTestResult;
        this.answerProperty = answerProperty;
    }

    /**
     * @see StudentTestingService#studentTesting()
     */
    public void studentTesting() {
        int minCorrectAnswers = answerProperty.getSuccess();
        List<Question> questions = questionsDao.getQuestions();
        Student student = studentDao.getStudentPersonalData();

        int countCorrectAnswer = 0;

        for (Question question : questions) {
            renderQuestion.showQuestion(question);
            countCorrectAnswer += answerProcessing.getAnswer() == question.getCorrectAnswer() ? 1 : 0;
        }

        var isPassedTest = countCorrectAnswer >= minCorrectAnswers;

        renderTestResult.showTestResult(new TestResult(student, countCorrectAnswer), isPassedTest);
    }
}
