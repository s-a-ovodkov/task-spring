package ru.otus.ovodkov.homework4.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.otus.ovodkov.homework4.dao.QuestionsDao;
import ru.otus.ovodkov.homework4.domain.Question;
import ru.otus.ovodkov.homework4.domain.Student;
import ru.otus.ovodkov.homework4.domain.TestResult;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@DisplayName("Сервис тестирования студента StudentTestingService")
@ExtendWith(MockitoExtension.class)
public class StudentTestingServiceImplTest {

    @Mock
    private QuestionsDao questionsDao;
    @Mock
    private RenderQuestion renderQuestion;
    @Mock
    private AnswerProcessing answerProcessing;

    private StudentTestingService studentTestingService;

    private Student student;
    private List<Question> questions;

    @BeforeEach
    void setUp() {
        studentTestingService = new StudentTestingServiceImpl(questionsDao, renderQuestion, answerProcessing);
        questions = new ArrayList<>() {
            {
                add(new Question("Question1", "1", "2", "3", "4", 1));
                add(new Question("Question2", "1", "2", "3", "4", 1));
                add(new Question("Question3", "1", "2", "3", "4", 1));
                add(new Question("Question4", "1", "2", "3", "4", 1));
                add(new Question("Question5", "1", "2", "3", "4", 4));
            }
        };
        student = new Student("Ivan", "Petrov");
    }

    @DisplayName("проверяем метод тестирования студентов")
    @Test
    void studentTesting(){
        when(questionsDao.getQuestions()).thenReturn(questions);
        when(answerProcessing.getAnswer()).thenReturn(1);

        TestResult testResult = studentTestingService.studentTesting(student);

        assertEquals(4, testResult.getCountCorrectAnswers());
    }
}
