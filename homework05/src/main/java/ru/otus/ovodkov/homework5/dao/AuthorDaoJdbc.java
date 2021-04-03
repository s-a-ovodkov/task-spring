package ru.otus.ovodkov.homework5.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.otus.ovodkov.homework5.domain.Author;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @see ru.otus.ovodkov.homework5.dao.AuthorDao
 */
@RequiredArgsConstructor
@Repository
public class AuthorDaoJdbc implements AuthorDao {

    private static final String COUNT_QUERY = "SELECT COUNT(*) FROM Authors";
    private static final String INSERT_QUERY = "INSERT INTO Authors(firstName, lastName) VALUES(:firstName, :lastName)";
    private static final String UPDATE_QUERY = "UPDATE Authors SET firstName=:firstName, lastName=:lastName WHERE idAuthor=:idAuthor";
    private static final String DELETE_AUTHORS_BOOKS_QUERY = "DELETE FROM AuthorsBooks WHERE idAuthor=:idAuthor";
    private static final String DELETE_QUERY = "DELETE FROM Authors WHERE idAuthor = :idAuthor";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM Authors WHERE idAuthor = :idAuthor";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM Authors";

    private final NamedParameterJdbcOperations jdbcOperations;

    /**
     * @return Количество авторов в хранилище
     * @see AuthorDao#count()
     */
    @Override
    public long count() {
        return jdbcOperations.queryForObject(COUNT_QUERY, (Map<String, ?>) null, Long.class);
    }

    /**
     * @param author Добавляемый автор
     * @return Идентификатор добавленого в хранилище автора
     * @see AuthorDao#addAuthor(Author)
     */
    @Override
    public long addAuthor(Author author) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcOperations.update(INSERT_QUERY, GetAuthorSqlParameters(author), keyHolder);
        return keyHolder.getKey().longValue();
    }

    /**
     * @param author Новые данные автора
     * @see AuthorDao#update(Author)
     */
    @Override
    public void update(Author author) {
        SqlParameterSource parameters = GetAuthorSqlParameters(author)
                .addValue("idAuthor", author.getIdAuthor());
        jdbcOperations.update(UPDATE_QUERY, parameters);
    }

    /**
     * @param idAuthor Идентификатор удаляемого автора
     * @see AuthorDao#delete(long)
     */
    @Override
    public void delete(long idAuthor) {
        Map<String, Object> params = Collections.singletonMap("idAuthor", idAuthor);
        jdbcOperations.update(DELETE_AUTHORS_BOOKS_QUERY, params);
        jdbcOperations.update(DELETE_QUERY, params);
    }

    /**
     * @param idAuthor Идентификатор автора
     * @return Автор
     * @see AuthorDao#getByIdAuthor(long)
     */
    @Override
    public Author getByIdAuthor(long idAuthor) {
        Map<String, Object> params = Collections.singletonMap("idAuthor", idAuthor);
        return jdbcOperations.queryForObject(SELECT_BY_ID_QUERY, params, new AuthorMapper());
    }

    /**
     * @return Список всех авторов в хранилище
     * @see AuthorDao#getAllAuthors()
     */
    @Override
    public List<Author> getAllAuthors() {
        return jdbcOperations.query(SELECT_ALL_QUERY, new AuthorMapper());
    }

    private MapSqlParameterSource GetAuthorSqlParameters(Author author) {
        return new MapSqlParameterSource()
                .addValue("firstName", author.getFirstName())
                .addValue("lastName", author.getLastName());
    }

    private static class AuthorMapper implements RowMapper<Author> {

        @Override
        public Author mapRow(ResultSet resultSet, int i) throws SQLException {
            long idAuthor = resultSet.getLong("idAuthor");
            String firstName = resultSet.getString("firstName");
            String lastName = resultSet.getString("lastName");
            return new Author(idAuthor, firstName, lastName);
        }
    }
}
