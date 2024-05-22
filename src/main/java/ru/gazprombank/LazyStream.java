package ru.gazprombank;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class LazyStream {

    public static void main(String[] args) {

        final List<String> words = Arrays.asList("one", "two", "three", "four", "five");

        final Stream<String> stream = words.stream()
                .filter(word -> {
                    System.out.println("Filtering: " + word);
                    return word.length() > 3;
                })
                .map(word -> {
                    System.out.println("Mapping: " + word);
                    return word.toUpperCase();
                });

        System.out.println("Stream created, no operations performed yet.");

        // Терминальная операция - форсирует выполнение всех промежуточных операций
        stream.forEach(word -> System.out.println("Final output: " + word));
    }
}
