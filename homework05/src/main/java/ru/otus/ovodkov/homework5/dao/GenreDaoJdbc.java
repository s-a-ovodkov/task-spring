package ru.otus.ovodkov.homework5.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.otus.ovodkov.homework5.domain.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author Ovodkov Sergey
 * @see GenreDao
 */
@RequiredArgsConstructor
@Repository
public class GenreDaoJdbc implements GenreDao {

    private static final String COUNT_QUERY = "SELECT COUNT(*) FROM Genres";
    private static final String INSERT_QUERY = "INSERT INTO Genres(nameGenre, descriptionGenre) VALUES(:nameGenre, :descriptionGenre)";
    private static final String UPDATE_QUERY = "UPDATE Genres SET nameGenre=:nameGenre, descriptionGenre=:descriptionGenre WHERE idGenre=:idGenre";
    private static final String DELETE_QUERY = "DELETE FROM Genres WHERE idGenre=:idGenre";
    private static final String SELECT_BY_ID = "SELECT * FROM Genres WHERE idGenre=:idGenre";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM Genres";
    private static final String DELETE_GENRES_BOOKS_QUERY = "DELETE FROM GenresBooks WHERE idGenre=:idGenre";

    private final NamedParameterJdbcOperations jdbcOperations;

    /**
     * @see GenreDao#count()
     * @return Количество жанров в хранилище
     */
    @Override
    public long count() {
        return jdbcOperations.queryForObject(COUNT_QUERY, (Map<String, ?>) null, Long.class);
    }

    /**
     * @param genre Добавляемый жанр
     * @return Идентификатор добавленого жанра
     * @see GenreDao#addGenre(Genre)
     */
    @Override
    public long addGenre(Genre genre) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcOperations.update(INSERT_QUERY, GetGenreSqlParameterSource(genre), keyHolder);
        return keyHolder.getKey().longValue();
    }

    /**
     * @param genre Обновляемые данные жанра
     * @see GenreDao#update(Genre)
     */
    @Override
    public void update(Genre genre) {
        SqlParameterSource parameters = GetGenreSqlParameterSource(genre)
                .addValue("idGenre", genre.getIdGenre());
        jdbcOperations.update(UPDATE_QUERY, parameters);
    }

    /**
     * @param idGenre Идентификатор удаляемого жанра
     * @see GenreDao#delete(long)
     */
    @Override
    public void delete(long idGenre) {
        Map<String, Object> parameters = Collections.singletonMap("idGenre", idGenre);
        jdbcOperations.update(DELETE_GENRES_BOOKS_QUERY, parameters);
        jdbcOperations.update(DELETE_QUERY, parameters);
    }

    /**
     * @param idGenre Идентификатор искомого жанра
     * @return Жанр найденый по идентификатору
     * @see GenreDao#getByIdGenre(long)
     */
    @Override
    public Genre getByIdGenre(long idGenre) {
        Map<String, Object> parameters = Collections.singletonMap("idGenre", idGenre);
        return jdbcOperations.queryForObject(SELECT_BY_ID, parameters, new GenreMapper());
    }

    /**
     * @return Список всех жанров в хранилище
     * @see GenreDao#getAllGenres()
     */
    @Override
    public List<Genre> getAllGenres() {
        return jdbcOperations.query(SELECT_ALL_QUERY, new GenreMapper());
    }

    private MapSqlParameterSource GetGenreSqlParameterSource(Genre genre) {
        return new MapSqlParameterSource()
                .addValue("nameGenre", genre.getNameGenre())
                .addValue("descriptionGenre", genre.getDescriptionGenre());
    }

    private static class GenreMapper implements RowMapper<Genre> {

        @Override
        public Genre mapRow(ResultSet resultSet, int i) throws SQLException {
            long idGenre = resultSet.getLong("idGenre");
            String nameGenre = resultSet.getString("nameGenre");
            String descriptionGenre = resultSet.getString("descriptionGenre");
            return new Genre(idGenre, nameGenre, descriptionGenre);
        }
    }
}
