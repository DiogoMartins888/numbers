package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PositiveFilterTest {

    @Test
    public void accept() {
        PositiveFilter filter = new PositiveFilter();

        Integer testNumber = -5;
        Assertions.assertEquals(false, filter.accept(testNumber));

        testNumber = -1;
        Assertions.assertEquals(false, filter.accept(testNumber));

        testNumber = 0;
        Assertions.assertEquals(false, filter.accept(testNumber));

        testNumber = 1;
        Assertions.assertEquals(true, filter.accept(testNumber));

        testNumber = 6;
        Assertions.assertEquals(true, filter.accept(testNumber));
    }
}
