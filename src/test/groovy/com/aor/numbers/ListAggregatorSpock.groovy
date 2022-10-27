package com.aor.numbers

import spock.lang.Specification

class ListAggregatorSpock extends Specification {
    private def testList

    def setup() {
        testList = Arrays.asList(1, 2, 4, 2, 6, -7, 5, 4, 7, -4)
    }

    def "distinct"() {
        given:
            def aggregator
    }

    def "disting_bug_8726"() {
        given:
            def aggregator = Mock(ListAggregator)
            def deduplicator = Mock(GenericListDeduplicator)
            deduplicator.deduplicate(Arrays.asList(1, 2, 4, 2)) >> Arrays.asList(1, 2, 4)

        when:
            def result = aggregator.distinct(Arrays.asList(1, 2, 4, 2))

        then:
            result == Arrays.asList(1, 2, 4)
    }
}
