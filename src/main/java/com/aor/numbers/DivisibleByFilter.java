package com.aor.numbers;

public class DivisibleByFilter implements GenericListFilter {

    private Integer divisibleBy;

    public DivisibleByFilter(Integer number) {
        divisibleBy = number;
    }

    public boolean accept(Integer number) {
        return number % divisibleBy == 0;
    }

}
