package com.thoughtworks.matcher;

import java.util.Map;
import java.util.Optional;

public class MultipleMatcher implements RuleMatcher {

    private static final Map<Integer, String> multipleMaps = Map.of(
            3, "Fizz",
            5, "Buzz",
            7, "Whizz"
    );

    @Override
    public Optional<String> matchNumber(final int number) {
        return multipleMaps.entrySet().stream()
                .filter(entry -> isDivisible(number, entry.getKey()))
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .reduce(String::concat);
    }

    private boolean isDivisible(int number, int multiple) {
        return number % multiple == 0;
    }
}