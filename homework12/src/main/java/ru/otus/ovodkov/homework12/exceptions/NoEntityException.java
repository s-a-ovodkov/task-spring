package ru.otus.ovodkov.homework12.exceptions;

/**
 * Доменное исключение для случая, когда сущность не найдена
 *
 * @author Ovodkov Sergey
 * created on 28.03.2021
 */
public class NoEntityException extends RuntimeException {
  private final long idEntity;
  private final String entityName;

  public NoEntityException(long idEntity, String entityName) {
    this.idEntity = idEntity;
    this.entityName = entityName;
  }

  @Override
  public String toString() {
    return "Указанная сущность [" + entityName + "] c ID = " + idEntity + " не найдена";
  }
}
