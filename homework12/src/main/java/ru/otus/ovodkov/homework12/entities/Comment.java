package ru.otus.ovodkov.homework12.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Ovodkov Sergey
 * created on 28.03.2021
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "Comments")
public class Comment {

  /**
   * Идентификатор комментария
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "idComment")
  private long idComment;

  /**
   * Комментарий к книге
   */
  @Column(name = "commentBook")
  private String commentBook;

  /**
   * Книга к которой относится комментарий
   */
  @ManyToOne(targetEntity = Book.class, cascade = CascadeType.ALL)
  @JoinColumn(name = "idBook")
  private Book book;
}
