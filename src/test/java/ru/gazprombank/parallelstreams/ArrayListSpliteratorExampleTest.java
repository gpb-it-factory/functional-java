package ru.gazprombank.parallelstreams;

import ru.gazprombank.util.DataSet;
import org.junit.jupiter.api.RepeatedTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrayListSpliteratorExampleTest {

    ArrayListSpliteratorExample example = new ArrayListSpliteratorExample();

    @RepeatedTest(5)
    void multiplyEachValue() {
        int size = 1_000_000;
        final ArrayList<Integer> inputList = DataSet.generateArrayList(size);
        example.multiplyEachValue(inputList, 2, false);
        assertEquals(size, inputList.size());
    }

    @RepeatedTest(5)
    void multiplyEachValueParallel() {
        int size = 1_000_000;
        final ArrayList<Integer> inputList = DataSet.generateArrayList(size);
        example.multiplyEachValue(inputList, 2, true);
        assertEquals(size, inputList.size());
    }
}