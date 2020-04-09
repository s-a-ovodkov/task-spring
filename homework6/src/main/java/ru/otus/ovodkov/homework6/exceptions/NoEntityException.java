package ru.otus.ovodkov.homework6.exceptions;

/**
 * Специональное исключение для случая когда указанная книга не надена
 *
 * @author Ovodkov Sergey on 07.04.2020
 */
public class NoEntityException extends Exception {

    private final long idEntity;
    private final String entityName;

    public NoEntityException(long idEntity, String entityName) {
        this.idEntity = idEntity;
        this.entityName = entityName;
    }

    @Override
    public String toString() {
        return "Указаная сущность [" + entityName + "] c ID = " + idEntity + " не найдена";
    }
}
