package ru.otus.ovodkov.homework10.exception;

/**
 * Доменное исключение для случая когда искомая сущность не найдена
 *
 * @author Ovodkov Sergey
 * created on 11.08.2020
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
