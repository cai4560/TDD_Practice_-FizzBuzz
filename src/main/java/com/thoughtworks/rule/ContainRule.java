package com.thoughtworks.rule;

import com.thoughtworks.NumberFactor;

import java.util.Optional;

public class ContainRule extends Rule {

    private String numberStr;
    private String value;

    public ContainRule(boolean enabled, NumberFactor numberStr) {
        super(enabled);
        this.numberStr = numberStr.getNumberStr();
        this.value = numberStr.getValue();
    }

    @Override
    public Optional<String> apply(int number) {
        return contains(number) ? Optional.of(value) : Optional.empty();
    }


    private boolean contains(int number) {
        return String.valueOf(number).contains(numberStr);
    }
}
