package ru.otus.ovodkov.homework12.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Ovodkov Sergey
 * created on 28.03.2021
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "Authors")
@NamedEntityGraph(name = "authorEntityGraph", attributeNodes = {@NamedAttributeNode("books")})
public class Author {

  /**
   * Идентификатор автора
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long idAuthor;

  /**
   * Имя автора
   */
  @Column(name = "firstName")
  private String firstName;

  /**
   * Фамилия автора
   */
  @Column(name = "lastName")
  private String lastName;

  /**
   * Книги автора
   */
  @ManyToMany(mappedBy = "authors", fetch = FetchType.LAZY)
  private Set<Book> books;
}
