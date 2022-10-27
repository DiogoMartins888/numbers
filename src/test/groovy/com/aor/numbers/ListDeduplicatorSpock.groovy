package com.aor.numbers

import spock.lang.Specification

class ListDeduplicatorSpock extends Specification {
    private def testList
    private def testDeduplicator

    def setup() {
        testList = Arrays.asList(4, 2, 5, -2, 3, -1, -2, -2, 5, 8)
    }

    def "deduplicate"() {
        given:
            def sorter = Mock(GenericListSorter)
            testDeduplicator = new ListDeduplicator(sorter)
            sorter.sort(testList) >> Arrays.asList(-2, -2, -2, -1, 2, 3, 4, 5, 5, 8)

        when:
            def result = testDeduplicator.deduplicate(testList)

        then:
            result == Arrays.asList(-2, -1, 2, 3, 4, 5, 8)
    }
}
