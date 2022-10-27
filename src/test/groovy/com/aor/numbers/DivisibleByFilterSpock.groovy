package com.aor.numbers

import spock.lang.Specification

class DivisibleByFilterSpock extends Specification {
    def "accept"() {
        given:
            def testFilter = new DivisibleByFilter(7)

        expect:
            testFilter.accept(number) == flag

        where:
            number | flag
            -10 | false
            -8 | false
            -7 | true
            -6 | false
            -3 | false
            -1 | false
            0 | true
            1 | false
            4 | false
            6 | false
            7 | true
            8 | false
            21 | true
    }
}
