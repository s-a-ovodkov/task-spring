package ru.otus.ovodkov.homework2.dao;

import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Value;
import ru.otus.ovodkov.homework2.domain.Question;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Извлечение вопросов для тестирования из файла CSV
 *
 * @author Sergey Ovodkov
 * @project homework2
 * @created 2020-03-05
 */
public class QuestionsDaoCsvFile {

    private final String csvFileName;

    /**
     * .ctor
     *
     * @param fileName  Имя ресурса. Файл CSV с вопросами
     */
    public QuestionsDaoCsvFile(@Value("@{question.file}") String fileName){
        this.csvFileName = fileName;
    }

    /**
     * @see QuestionsDao#getQuestions()
     */
    public List<Question> getQuestions() {
        try (BufferedReader reader = Files.newBufferedReader(getFilePath(), StandardCharsets.UTF_8)) {
            ColumnPositionMappingStrategy<Question> strategy = createColumnPositionMappingStrategy();

            CsvToBean<Question> csvToBean = new CsvToBeanBuilder<Question>(reader)
                    .withType(Question.class)
                    .withMappingStrategy(strategy)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            return csvToBean.parse();
        } catch (IOException | URISyntaxException exc) {
            exc.printStackTrace();
        }

        return new ArrayList<>();
    }

    private Path getFilePath() throws URISyntaxException {
        URI uri = getClass().getClassLoader().getResource(csvFileName).toURI();
        return Paths.get(uri);
    }

    private ColumnPositionMappingStrategy<Question> createColumnPositionMappingStrategy() {
        ColumnPositionMappingStrategy<Question> strategy = new ColumnPositionMappingStrategy<>();
        strategy.setType(Question.class);
        String[] fields = {"question", "possibleAnswer1", "possibleAnswer2", "possibleAnswer3", "possibleAnswer4", "correctAnswer"};
        strategy.setColumnMapping(fields);
        return strategy;
    }
}
