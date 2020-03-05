package ru.otus.ovodkov.homework2.service;

import java.util.Scanner;

/**
 * @see AnswerProcessing
 *
 * @author Sergey Ovodkov
 * @project homework2
 * @created 2020-03-05
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
