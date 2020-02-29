package ru.otus.ovodkov.homework.dao;

import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import ru.otus.ovodkov.homework.domain.Question;

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
 */
public class QuestionsDaoCsvFile implements QuestionsDao {

    private final String fileName;

    /**
     * .ctor
     *
     * @param path Имя ресурса. Файл CSV с вопросами
     */
    public QuestionsDaoCsvFile(String path) {
        this.fileName = path;
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
        URI uri = getClass().getClassLoader().getResource(fileName).toURI();
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
