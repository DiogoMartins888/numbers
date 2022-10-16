package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ListFiltererTest {

    @Test
    public void filter() {
        List<Integer> testList = Arrays.asList(-3, 1, 5, -5, 10);

        PositiveFilter positiveFilter = new PositiveFilter();
        List<Integer> expectedList = Arrays.asList(1, 5, 10);
        ListFilterer listFilterer = new ListFilterer(positiveFilter);
        Assertions.assertEquals(expectedList, listFilterer.filter(testList));

        DivisibleByFilter divisibleByFilter = new DivisibleByFilter(5);
        expectedList = Arrays.asList(5, -5, 10);
        ListFilterer listFilterer1 = new ListFilterer(divisibleByFilter);
        Assertions.assertEquals(expectedList, listFilterer1.filter(testList));
    }
}
