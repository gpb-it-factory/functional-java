package ru.gazprombank.parallelstreams;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.gazprombank.ParallelStreamsExample;
import ru.gazprombank.util.DataSet;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static ru.gazprombank.util.CommonUtil.startTimer;
import static ru.gazprombank.util.CommonUtil.stopWatchReset;
import static ru.gazprombank.util.CommonUtil.timeTaken;

class ParallelStreamsExampleTest {

    ParallelStreamsExample testExample = new ParallelStreamsExample();

    @ParameterizedTest
    @ValueSource(booleans = {false, true})
    void stringTransform2(boolean isParallel) {
        // given
        List<String> inputList = DataSet.namesList();
        // when
        stopWatchReset();
        startTimer();
        final List<String> resultList = testExample.stringTransformPar(inputList, isParallel);
        timeTaken();
        // then
        assertEquals(4, resultList.size());
        resultList.forEach(name -> assertTrue(name.contains("-")));
    }

    @Test
    void toLowerCase() {
        List<String> inputList = DataSet.namesList();
        final List<String> resultList = testExample.toLowerCase(inputList);
        resultList.forEach(name -> assertTrue(StringUtils.isAllLowerCase(name)));
    }
}