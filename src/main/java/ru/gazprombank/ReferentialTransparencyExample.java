package ru.gazprombank;

import java.util.function.UnaryOperator;

public class ReferentialTransparencyExample {

    // Чистая функция, обладающая свойством ссылочной прозрачности
    public static int square(int x) {
        return x * x;
    }

    // Чистая функция, обладающая свойством ссылочной прозрачности
    public static final UnaryOperator<Integer> squareLambda = x -> x * x;

    public static void main(String[] args) {

        final int result1 = square(5); // result1 будет равен 25
        final int result2 = squareLambda.apply(5); // result2 будет равен 25

        // Мы можем заменить вызов функции значением без изменения поведения программы
        final int alternative1 = 25; // Результат вызова square(5)
        final int alternative2 = 25; // Результат вызова square(5)

        System.out.println("result1: " + result1); // Ожидаемый вывод: result1: 25
        System.out.println("result2: " + result2); // Ожидаемый вывод: result2: 25
        System.out.println("alternative1: " + alternative1); // Ожидаемый вывод: alternative1: 25
        System.out.println("alternative2: " + alternative2); // Ожидаемый вывод: alternative2: 25
    }
}
