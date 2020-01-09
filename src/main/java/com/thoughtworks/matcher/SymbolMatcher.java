package com.thoughtworks.matcher;

import java.util.Optional;

public class SymbolMatcher implements RuleMatcher {

    private static final String THREE_STR = "3";

    @Override
    public Optional<String> matchNumber(int number) {
        return contains(number, THREE_STR) ? Optional.of("Fizz") : Optional.empty();
    }

    private boolean contains(int number, String symbol) {
        return String.valueOf(number).contains(symbol);
    }
}
