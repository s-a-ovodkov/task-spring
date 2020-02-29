package ru.otus.ovodkov.homework.services;

import java.util.Scanner;

/**
 * @author Sergey Ovodkov
 * @see AnswerProcessing
 */
public class AnswerProcessingConsole implements AnswerProcessing {
    /**
     * @see AnswerProcessing#getAnswer()
     */
    public int getAnswer() {
        Scanner in = new Scanner(System.in);
        System.out.print("Укажите номер правильного вариант ответа: ");
        return in.nextInt();
    }
}
