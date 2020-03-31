package ru.otus.ovodkov.homework5.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.otus.ovodkov.homework5.domain.Book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author Ovodkov Sergey
 * @see ru.otus.ovodkov.homework5.dao.BookDao
 */
@RequiredArgsConstructor
@Repository
public class BookDaoJdbc implements BookDao {

    private static final String COUNT_QUERY = "SELECT COUNT(*) FROM Books";
    private static final String INSERT_QUERY = "INSERT INTO Books(titleBook, edition, yearPublishing) VALUES(:titleBook, :edition, :yearPublishing)";
    private static final String UPDATE_QUERY = "UPDATE Books SET titleBook=:titleBook, edition=:edition, yearPublishing=:yearPublishing WHERE idBook=:idBook";
    private static final String DELETE_GENRES_BOOKS_QUERY = "DELETE FROM GenresBooks WHERE idBook=:idBook";
    private static final String DELETE_AUTHORS_BOOKS_QUERY = "DELETE FROM AuthorsBooks WHERE idBook=:idBook";
    private static final String DELETE_QUERY = "DELETE FROM Books WHERE idBook=:idBook";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM Books WHERE idBook=:idBook";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM Books";

    private final NamedParameterJdbcOperations jdbcOperations;

    /**
     * @return Количество книг в хранилище
     * @see BookDao#count()
     */
    @Override
    public long count() {
        return jdbcOperations.queryForObject(COUNT_QUERY, (Map<String, ?>) null, Long.class);
    }

    /**
     * @param book Добавляемая книга
     * @return Идентификатор добавленой книги
     * @see BookDao#addBook(Book)
     */
    @Override
    public long addBook(Book book) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcOperations.update(INSERT_QUERY, GetBookSqlParameterSource(book), keyHolder);
        return keyHolder.getKey().longValue();
    }

    /**
     * @param book Обновленные данные книги
     * @see BookDao#update(Book)
     */
    @Override
    public void update(Book book) {
        SqlParameterSource parameters = GetBookSqlParameterSource(book)
                .addValue("idBook", book.getIdBook());
        jdbcOperations.update(UPDATE_QUERY, parameters);
    }

    /**
     * @param idBook Идентификатор удаляемой книги
     * @see BookDao#delete(long)
     */
    @Override
    public void delete(long idBook) {
        Map<String, Object> parameters = Collections.singletonMap("idBook", idBook);
        jdbcOperations.update(DELETE_AUTHORS_BOOKS_QUERY, parameters);
        jdbcOperations.update(DELETE_GENRES_BOOKS_QUERY, parameters);
        jdbcOperations.update(DELETE_QUERY, parameters);
    }

    /**
     * @param idBook Идентификатор искомой книги
     * @return Книга найденная по идентификатору
     * @see BookDao#getByBookId(long)
     */
    @Override
    public Book getByBookId(long idBook) {
        Map<String, Object> parameters = Collections.singletonMap("idBook", idBook);
        return jdbcOperations.queryForObject(SELECT_BY_ID_QUERY, parameters, new BookMapper());
    }

    /**
     * @return Список всех книг в хранилище
     * @see BookDao#getAllBooks()
     */
    @Override
    public List<Book> getAllBooks() {
        return jdbcOperations.query(SELECT_ALL_QUERY, new BookMapper());
    }

    private MapSqlParameterSource GetBookSqlParameterSource(Book book) {
        return new MapSqlParameterSource()
                .addValue("titleBook", book.getTitleBook())
                .addValue("edition", book.getEdition())
                .addValue("yearPublishing", book.getYearPublishing());
    }

    private static class BookMapper implements RowMapper<Book> {

        @Override
        public Book mapRow(ResultSet resultSet, int i) throws SQLException {
            long idBook = resultSet.getLong("idBook");
            String titleBook = resultSet.getString("titleBook");
            int edition = resultSet.getInt("edition");
            int yearPublishing = resultSet.getInt("yearPublishing");
            return new Book(idBook, titleBook, edition, yearPublishing);
        }
    }
}
