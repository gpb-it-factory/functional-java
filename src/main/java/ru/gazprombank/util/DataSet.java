package ru.gazprombank.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.stream.IntStream;

public class DataSet {

    public static List<String> namesList() {
        return List.of("Bob", "Jamie", "Jill", "Rick");
    }

    public static ArrayList<Integer> generateArrayList(int maxNumber) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        IntStream.rangeClosed(1, maxNumber)
                .boxed()
                .forEach((arrayList::add));
        return arrayList;
    }

    public static LinkedList<Integer> generateIntegerLinkedList(int maxNumber) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        IntStream.rangeClosed(1, maxNumber)
                .boxed()
                .forEach((linkedList::add));
        return linkedList;
    }
}
