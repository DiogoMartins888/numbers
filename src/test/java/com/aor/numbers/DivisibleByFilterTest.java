package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DivisibleByFilterTest {

    @Test
    public void accept() {
        DivisibleByFilter filter = new DivisibleByFilter(7);

        Integer testNumber = -10;
        Assertions.assertFalse(filter.accept(testNumber));

        testNumber = -8;
        Assertions.assertFalse(filter.accept(testNumber));

        testNumber = -7;
        Assertions.assertTrue(filter.accept(testNumber));

        testNumber = -6;
        Assertions.assertFalse(filter.accept(testNumber));

        testNumber = -3;
        Assertions.assertFalse(filter.accept(testNumber));

        testNumber = -1;
        Assertions.assertFalse(filter.accept(testNumber));

        testNumber = 0;
        Assertions.assertTrue(filter.accept(testNumber));

        testNumber = 1;
        Assertions.assertFalse(filter.accept(testNumber));

        testNumber = 4;
        Assertions.assertFalse(filter.accept(testNumber));

        testNumber = 6;
        Assertions.assertFalse(filter.accept(testNumber));

        testNumber = 7;
        Assertions.assertTrue(filter.accept(testNumber));

        testNumber = 8;
        Assertions.assertFalse(filter.accept(testNumber));

        testNumber = 21;
        Assertions.assertTrue(filter.accept(testNumber));
    }
}
