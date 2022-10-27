package com.aor.numbers

import spock.lang.Specification

class PositiveFilterSpock extends Specification {
    def "accept"() {
        given:
            def testFilter = new PositiveFilter()

        expect:
            testFilter.accept(number) == flag

        where:
            number | flag
            -5 | false
            -1 | false
            0 | false
            1 | true
            6 | true
    }
}
