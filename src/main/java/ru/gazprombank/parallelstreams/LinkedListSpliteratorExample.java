package ru.gazprombank.parallelstreams;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static ru.gazprombank.util.CommonUtil.startTimer;
import static ru.gazprombank.util.CommonUtil.timeTaken;

public class LinkedListSpliteratorExample {

    public List<Integer> multiplyEachValue(final LinkedList<Integer> inputList, final int multiplyValue, final boolean isParallel) {

        startTimer();
        final Stream<Integer> integerStream = inputList.stream();

        if (isParallel)
            integerStream.parallel();

        final List<Integer> resultList = integerStream
                .map(integer -> integer * multiplyValue)
                .collect(Collectors.toList());

        timeTaken();
        return resultList;
    }
}
