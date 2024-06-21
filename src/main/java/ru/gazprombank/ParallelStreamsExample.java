package ru.gazprombank;


import ru.gazprombank.util.DataSet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static ru.gazprombank.util.CommonUtil.delay;
import static ru.gazprombank.util.CommonUtil.startTimer;
import static ru.gazprombank.util.CommonUtil.timeTaken;
import static ru.gazprombank.util.LoggerUtil.log;


public class ParallelStreamsExample {

    public List<String> stringTransform(List<String> namesList){
        return namesList
                .parallelStream()
                .map(this::addNameLengthTransform)
                .collect(Collectors.toList());
    }

    public List<String> stringTransformPar(List<String> namesList, boolean isParallel){

        Stream<String> stream = namesList.stream();

        if (isParallel)
            stream.parallel();

        return stream.map(this::addNameLengthTransform).collect(Collectors.toList());
    }

    public List<String> toLowerCase(List<String> namesList){
        return namesList
                .parallelStream()
                .map(String::toLowerCase)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

        final List<String> namesList = DataSet.namesList();

        ParallelStreamsExample parallelStreamsExample = new ParallelStreamsExample();
        startTimer();
        List<String> resultList = parallelStreamsExample.stringTransform(namesList);
        log("resultList: " + resultList);
        timeTaken();
    }

    private String addNameLengthTransform(String name) {
        delay(500);
        return name.length() + " - " + name;
    }

    public static ArrayList<Integer> generateArrayList(int maxNumber) {
        final ArrayList<Integer> arrayList = new ArrayList<>();

        IntStream.rangeClosed(1, maxNumber)
                .boxed()
                .forEach((arrayList::add));
        return arrayList;
    }

    public static LinkedList<Integer> generateIntegerLinkedList(int maxNumber) {
        final LinkedList<Integer> linkedList = new LinkedList<>();
        IntStream.rangeClosed(1, maxNumber)
                .boxed()
                .forEach((linkedList::add));
        return linkedList;
    }
}
