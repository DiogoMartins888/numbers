package com.aor.numbers

import spock.lang.Specification

class ListSorterSpock extends Specification {
    private def testList
    private def testSorter

    def setup() {
        testList = Arrays.asList(2, 7, -2, -5, 1, -3, 7, -8, 0, 12, 1)
        testSorter = new ListSorter()
    }

    def "sort"() {
        when:
            def result = testSorter.sort(testList)

        then:
            result == Arrays.asList(-8, -5, -3, -2, 0, 1, 1, 2, 7, 7, 12)
    }
}
