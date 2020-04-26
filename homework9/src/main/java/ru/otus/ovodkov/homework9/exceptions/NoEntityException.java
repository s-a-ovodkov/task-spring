package ru.otus.ovodkov.homework9.exceptions;

/**
 * Доменное исключение
 *
 * @author Ovodkov Sergey
 * created on 26.04.2020
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
