package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ListSorterTest {

    @Test
    public void sort() {
        List<Integer> list = Arrays.asList(1, 2, 4, 2, 5, 7, 6, 2, -1, 2, 3, 4, 56, -4, 7, 8, 23);
        List<Integer> expected = Arrays.asList(-4, -1, 1, 2, 2, 2, 2, 3, 4, 4, 5, 6, 7, 7, 8, 23, 56);

        ListSorter sorter = new ListSorter();
        List<Integer> sorted = sorter.sort(list);

        Assertions.assertEquals(expected, sorted);
    }

    @Test
    public void sort_bug_8726() {
        List<Integer> list = Arrays.asList(1, 2, 4, 2);
        List<Integer> expected = Arrays.asList(1, 2, 2, 4);

        ListSorter sorter = new ListSorter();
        List<Integer> sorted = sorter.sort(list);

        Assertions.assertEquals(expected, sorted);
    }
}
