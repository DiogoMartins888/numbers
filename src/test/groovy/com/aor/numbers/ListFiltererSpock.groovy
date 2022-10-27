package com.aor.numbers

import spock.lang.Specification

class ListFiltererSpock extends Specification {
    def "filter"() {
        given:
            def testList = Arrays.asList(-3, 1, 5, -5, 10)

            def testPositiveFilter = Mock(GenericListFilter)
            testPositiveFilter.accept(-3) >> false
            testPositiveFilter.accept(1) >> true
            testPositiveFilter.accept(5) >> true
            testPositiveFilter.accept(-5) >> false
            testPositiveFilter.accept(10) >> true

            def testDivisibleByFilter = Mock(GenericListFilter)
            testDivisibleByFilter.accept(-3) >> false
            testDivisibleByFilter.accept(1) >> false
            testDivisibleByFilter.accept(5) >> true
            testDivisibleByFilter.accept(-5) >> true
            testDivisibleByFilter.accept(10) >> true

            def testFilterer1 = new ListFilterer(testPositiveFilter)
            def testFilterer2 = new ListFilterer(testDivisibleByFilter)

        expect:
            testFilterer1.filter(testList) == Arrays.asList(1, 5, 10)
            testFilterer2.filter(testList) == Arrays.asList(5, -5, 10)
    }
}
