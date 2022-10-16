package com.aor.numbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * An utility class to sort list of numbers.
 */
public class ListSorter implements GenericListSorter {
    /**
     * Really stupid way to sort a list.
     * @return A sorted version of the list.
     */
    public List<Integer> sort(List<Integer> list) {
        List<Integer> sorted = new ArrayList<>();
        for (Integer number : list)
            sorted.add(number);

        // Insertion Sort
        for (int i = 1; i < sorted.size(); i++) {
            Integer tmp = sorted.get(i);
            int j;
            for (j = i; j > 0 && tmp < sorted.get(j - 1); j--)
                sorted.set(j, sorted.get(j - 1));
            sorted.set(j, tmp);
        }
        return sorted;
    }
}
