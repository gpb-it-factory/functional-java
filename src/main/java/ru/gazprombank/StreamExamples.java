package ru.gazprombank;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExamples {

    public static void main(String[] args) {

        // 1. Варианты создания стрима
        List<String> list = Arrays.asList("a", "b", "c", "d");
        final Stream<String> streamFromList = list.stream();
        final Stream<String> streamFromArray = Stream.of("a", "b", "c", "d");

        // 2. Промежуточные операции
        List<String> list2 = Arrays.asList("apple", "banana", "cherry", "date");

        final List<String> result2 = list2.stream()
                .filter(s -> s.startsWith("b"))
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println(result2);

        // 3. Сортировка и ограничение результатов
        final List<Integer> list3 = Arrays.asList(5, 2, 8, 1, 3);

        final List<Integer> result3 = list3.stream()
                .sorted()
                .limit(3)
                .collect(Collectors.toList());

        System.out.println(result3);

        // 4. Терминальные операции: forEach, collect, reduce
        final List<String> list4 = Arrays.asList("apple", "banana", "cherry", "apple");

        // Вызов println на каждом элементе
        list4.stream().forEach(System.out::println);

        // Сбор в множество (unordered collection)
        final Set<String> result4 = list4.stream().collect(Collectors.toSet());

        System.out.println(result4); // Вывод: [banana, cherry, apple]

        // reduce: объединяет все элементы стрима в один результат
        final List<Integer> list5 = Arrays.asList(1, 2, 3, 4, 5);
        final Optional<Integer> sum = list5.stream().reduce((a, b) -> a + b);
        sum.ifPresent(System.out::println);

        // flatMap
        final List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("a", "b", "c"),
                Arrays.asList("d", "e", "f"),
                Arrays.asList("g", "h", "i")
        );

        final List<String> transformedList = listOfLists.stream()
                // Преобразуем элементы каждого внутреннего списка в верхний регистр
                .map(innerList -> innerList.stream()
                        .map(String::toUpperCase) // Преобразуем каждую строку в верхний регистр
                        .collect(Collectors.toList())
                )
                // "Flatten" полученные списки строк
                .flatMap(List::stream)
                .collect(Collectors.toList());

        // Выводим результат
        System.out.println(transformedList);
    }

}
