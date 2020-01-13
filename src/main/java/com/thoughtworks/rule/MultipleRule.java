package com.thoughtworks.rule;

import com.thoughtworks.MultipleNumber;

import java.util.List;
import java.util.Optional;

public class MultipleRule extends Rule {

    private List<MultipleNumber> multipleNumbers;

    public MultipleRule(boolean isEnabled, List<MultipleNumber> multipleNumbers) {
        super(isEnabled);
        this.multipleNumbers = multipleNumbers;
    }

    @Override
    public Optional<String> apply(int number) {
        return multipleNumbers.stream()
                .filter(multiple -> isDivisible(number, multiple.getMultiple()))
                .map(MultipleNumber::getValue)
                .reduce(String::concat);
    }

    private boolean isDivisible(int number, int multiple) {
        return number % multiple == 0;
    }
}
