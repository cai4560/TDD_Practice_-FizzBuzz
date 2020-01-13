package com.thoughtworks.rule;

import java.util.Optional;

public class ContainRule extends Rule {

    private String factor;
    private String value;

    public ContainRule(boolean enabled, String factor, String value) {
        super(enabled);
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
