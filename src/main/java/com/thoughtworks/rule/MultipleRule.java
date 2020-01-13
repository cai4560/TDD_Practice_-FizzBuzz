package com.thoughtworks.rule;

import com.thoughtworks.NumberFactor;

import java.util.List;
import java.util.Optional;

public class MultipleRule extends Rule {

    private List<NumberFactor> numberFactors;

    public MultipleRule(boolean isEnabled, List<NumberFactor> numberFactors) {
        super(isEnabled);
        this.numberFactors = numberFactors;
    }

    @Override
    public Optional<String> apply(int number) {
        return numberFactors.stream()
                .filter(multiple -> isDivisible(number, multiple.getNumber()))
                .map(NumberFactor::getValue)
                .reduce(String::concat);
    }

    private boolean isDivisible(int number, int multiple) {
        return number % multiple == 0;
    }
}
