package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class ListDeduplicatorTest {
    private List<Integer> list;
    private List<Integer> expected;

    @BeforeEach
    private void generateLists() {
        list = Arrays.asList(1, 2, 4, 2, 5);
        expected = Arrays.asList(1, 2, 4, 5);
    }

    @Test
    public void deduplicate() {
        // Created stubs manually
        class StubListSorter implements GenericListSorter{
            @Override public List<Integer> sort(List<Integer> list) {
                return  Arrays.asList(1, 2, 4, 5);
            }
        }
        StubListSorter sorter = new StubListSorter();
        ListDeduplicator deduplicator = new ListDeduplicator(sorter);
        List<Integer> deduplicated = deduplicator.deduplicate(list);
        Assertions.assertEquals(expected, deduplicated);
    }

    @Test
    public void deduplicate_bug_8726() {
        List<Integer> list = Arrays.asList(1,2,4,2);

        /* Created stubs manually
        class StubListSorter implements GenericListSorter{
            @Override public List<Integer> sort(List<Integer> list) {
                return  Arrays.asList(1, 2, 2, 4);
            }
        }
        StubListSorter sorter = new StubListSorter();
        ListDeduplicator deduplicator = new ListDeduplicator(sorter);
        List<Integer> deduplicated = deduplicator.deduplicate(list);
        List<Integer> exp = Arrays.asList(1, 2, 4);
        Assertions.assertEquals(exp, deduplicated);
        */

        // Created stubs using mockito
        GenericListSorter sorter = Mockito.mock(GenericListSorter.class);
        Mockito.when(sorter.sort(Mockito.anyList())).thenReturn(Arrays.asList(1, 2, 2, 4));
        ListDeduplicator deduplicator = new ListDeduplicator(sorter);
        List<Integer> deduplicated = deduplicator.deduplicate(list);
        List<Integer> exp = Arrays.asList(1, 2, 4);

        Assertions.assertEquals(exp, deduplicated);
    }
}
