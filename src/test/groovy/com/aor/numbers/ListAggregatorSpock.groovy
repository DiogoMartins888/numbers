package com.aor.numbers

import spock.lang.Specification

class ListAggregatorSpock extends Specification {
    private def testList
    private def testAggregator

    def setup() {
        testList = Arrays.asList(1, 2, 4, 2, 6, -7, 5, 4, 7, -4)
        testAggregator = new ListAggregator()
    }

    def "sum"() {
        when:
            def result = testAggregator.sum(testList)

        then:
            result == 20
    }

    def "max"() {
        when:
            def result = testAggregator.max(testList)

        then:
            result == 7
    }

    def "min"() {
        when:
            def result = testAggregator.min(testList)

        then:
            result == -7
    }

    def "distinct"() {
        given:
            def deduplicator = Mock(GenericListDeduplicator)
            deduplicator.deduplicate(testList) >> Arrays.asList(-7, -4, 1, 2, 4, 5, 6, 7)

        when:
            def result = testAggregator.distinct(testList, deduplicator)

        then:
            result == 8
    }
}
