package com.thoughtworks.rule;

import java.util.Optional;

public class ContainRule implements Rule {

    private String factor;
    private String value;

    public ContainRule(String factor, String value) {
        this.factor = factor;
        this.value = value;
    }

    @Override
    public Optional<String> apply(int number) {
        return contains(number) ? Optional.of(value) : Optional.empty();
    }


    private boolean contains(int number) {
        return String.valueOf(number).contains(factor);
    }
}
