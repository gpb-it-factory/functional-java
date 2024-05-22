package ru.gazprombank;

import net.datafaker.Faker;

import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class LambdaAndMethodReference {

    // полезная библиотека для генерации тестовых данных
    static Faker faker = new Faker(Locale.of("ru-RU"));

    // два экземпляра ссылок на методы (method references)
    static Consumer<String> print = System.out::println;
    static UnaryOperator<String> toUpperCase = String::toUpperCase;
    static Predicate<String> isBiggerThan20 = s -> s.length() > 20;

    public static void main(final String[] args) {

        final List<String> names = faker.collection(() -> faker.name().fullName())
                .len(10)
                .generate();

        names.forEach(print);

        names.stream()
                .map(toUpperCase)
                .filter(isBiggerThan20)
                .forEach(print);
    }

}

