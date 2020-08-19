package ru.otus.ovodkov.homework8.exceptions;

/**
 * Доменное исключение для случая когда искомый документ не найден
 *
 * @author Ovodkov Sergey
 * created on 19.08.2020
 */
public class NoDocumentException extends Exception {

    private final String documentId;
    private final String documentName;

    public NoDocumentException(String documentId, String documentName) {
        this.documentId = documentId;
        this.documentName = documentName;
    }

    @Override
    public String toString() {
        return "Указанный документ [" + documentName + "] c ID = " + documentId + " не найдена";
    }
}
