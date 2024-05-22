package ru.gazprombank;

import java.util.stream.IntStream;

public class ImperativeVsDeclarative {

    public static void main(final String[] args) {

        // сумма целых чисел от 1 до 100

        // императивный стиль
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            sum += i; // изменяемое состояние со всеми вытекающими, в том числе в многопоточке
        }
        System.out.println("Sum is: " + sum);


        // декларативный (функциональный) стиль
        final int sum1 = IntStream.rangeClosed(0, 100)
                //.parallel()
                .sum();

        System.out.println("Sum is: " + sum1);

    }

}
