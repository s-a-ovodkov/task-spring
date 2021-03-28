INSERT INTO Books(idBook, titleBook, edition, yearPublishing) VALUES (1, 'Spring 5. Для профессионалов', 5, 2019);
INSERT INTO Books(idBook, titleBook, edition, yearPublishing) VALUES (2, 'Современный язык Java', 2, 2020);
INSERT INTO Books(idBook, titleBook, edition, yearPublishing) VALUES (3, 'Java: оптимизация программ', 1, 2019);
INSERT INTO Books(idBook, titleBook, edition, yearPublishing) VALUES (4, 'Java: эфективное программирование', 3, 2019);
INSERT INTO Books(idBook, titleBook, edition, yearPublishing) VALUES (5, 'Spring. Все паттерны проектирования', 1, 2019);

INSERT INTO Genres(idGenre, nameGenre, descriptionGenre) VALUES (1, 'Java', 'Лучший язык программирования');
INSERT INTO Genres(idGenre, nameGenre, descriptionGenre) VALUES (2, 'Spring', 'Лучший фреймворк');

INSERT INTO Authors(idAuthor, firstName, lastName) VALUES (1, 'Юлиана', 'Козмина');
INSERT INTO Authors(idAuthor, firstName, lastName) VALUES (2, 'Роб', 'Харроп');
INSERT INTO Authors(idAuthor, firstName, lastName) VALUES (3, 'Крис', 'Шефер');
INSERT INTO Authors(idAuthor, firstName, lastName) VALUES (4, 'Кларенс', 'Хо');
INSERT INTO Authors(idAuthor, firstName, lastName) VALUES (5, 'Рауль-Габриэль', 'Урма');
INSERT INTO Authors(idAuthor, firstName, lastName) VALUES (6, 'Марио', 'Фуско');
INSERT INTO Authors(idAuthor, firstName, lastName) VALUES (7, 'Алан', 'Майкрофт');
INSERT INTO Authors(idAuthor, firstName, lastName) VALUES (8, 'Бенджамин', 'Эванс');
INSERT INTO Authors(idAuthor, firstName, lastName) VALUES (9, 'Джеймс', 'Гоф');
INSERT INTO Authors(idAuthor, firstName, lastName) VALUES (10, 'Крис', 'Ньюланд');
INSERT INTO Authors(idAuthor, firstName, lastName) VALUES (11, 'Джошуа', 'Блох');
INSERT INTO Authors(idAuthor, firstName, lastName) VALUES (12, 'Динеш', 'Раджупт');

INSERT INTO Comments(idComment, commentBook, idBook) VALUES (1, 'Объемно и содержательно.', 1);
INSERT INTO Comments(idComment, commentBook, idBook) VALUES (2, 'Жалко, что Spring Security плохо расписан', 1);
INSERT INTO Comments(idComment, commentBook, idBook) VALUES (3, 'Рассмотрены нововедения в версии 8-11', 2);
INSERT INTO Comments(idComment, commentBook, idBook) VALUES (4, 'Описаны внутрености JVM', 3);
INSERT INTO Comments(idComment, commentBook, idBook) VALUES (5, 'Сборник рецептов.', 4);
INSERT INTO Comments(idComment, commentBook, idBook) VALUES (6, 'Не плохая книга', 5);

INSERT INTO AuthorsBooks(idBook, idAuthor) VALUES (1, 1);
INSERT INTO AuthorsBooks(idBook, idAuthor) VALUES (1, 2);
INSERT INTO AuthorsBooks(idBook, idAuthor) VALUES (1, 3);
INSERT INTO AuthorsBooks(idBook, idAuthor) VALUES (1, 4);
INSERT INTO AuthorsBooks(idBook, idAuthor) VALUES (2, 5);
INSERT INTO AuthorsBooks(idBook, idAuthor) VALUES (2, 6);
INSERT INTO AuthorsBooks(idBook, idAuthor) VALUES (2, 7);
INSERT INTO AuthorsBooks(idBook, idAuthor) VALUES (3, 8);
INSERT INTO AuthorsBooks(idBook, idAuthor) VALUES (3, 9);
INSERT INTO AuthorsBooks(idBook, idAuthor) VALUES (3, 10);
INSERT INTO AuthorsBooks(idBook, idAuthor) VALUES (4, 11);
INSERT INTO AuthorsBooks(idBook, idAuthor) VALUES (5, 12);

INSERT INTO GenresBooks(idBook, idGenre) VALUES (1, 2);
INSERT INTO GenresBooks(idBook, idGenre) VALUES (1, 1);
INSERT INTO GenresBooks(idBook, idGenre) VALUES (2, 1);
INSERT INTO GenresBooks(idBook, idGenre) VALUES (3, 1);
INSERT INTO GenresBooks(idBook, idGenre) VALUES (4, 1);
INSERT INTO GenresBooks(idBook, idGenre) VALUES (5, 2);
INSERT INTO GenresBooks(idBook, idGenre) VALUES (5, 1);

INSERT INTO Users(id, username, password) VALUES ('f5eea1cc-33d6-407e-9176-296ba7c8e26b', 'user', '123456')