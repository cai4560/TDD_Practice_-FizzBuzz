package com.thoughtworks.matcher;

import java.util.Optional;

public class MultipleMatcher extends RuleMatcher {

    private final Integer multiple;

    private final String text;

    public MultipleMatcher(Integer multiple, String text, boolean isEnabled) {
        super(isEnabled);
        this.multiple = multiple;
        this.text = text;
    }

    @Override
    public Optional<String> matchNumber(final int number) {
        return isDivisible(number, multiple) ? Optional.of(text) : Optional.empty();
    }

    private boolean isDivisible(int number, int multiple) {
        return number % multiple == 0;
    }
}