package ru.gazprombank.parallelstreams;

import org.junit.jupiter.api.RepeatedTest;
import ru.gazprombank.util.DataSet;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LinkedListSpliteratorExampleTest {

    LinkedListSpliteratorExample example = new LinkedListSpliteratorExample();

    @RepeatedTest(5)
    void multiplyEachValue() {
        int size = 1_000_000;
        final LinkedList<Integer> inputList = DataSet.generateIntegerLinkedList(size);

        example.multiplyEachValue(inputList, 2, false);

        assertEquals(size, inputList.size());
    }

    @RepeatedTest(5)
    void multiplyEachValueParallel() {
        int size = 1_000_000;
        final LinkedList<Integer> inputList = DataSet.generateIntegerLinkedList(size);

        example.multiplyEachValue(inputList, 2, true);

        assertEquals(size, inputList.size());
    }
}