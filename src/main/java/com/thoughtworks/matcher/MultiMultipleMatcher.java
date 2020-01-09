package com.thoughtworks.matcher;

import java.util.Map;
import java.util.Optional;

public class MultiMultipleMatcher implements RuleMatcher {

    private Map<Integer, String> multipleMaps;

    public MultiMultipleMatcher(Map<Integer, String> multipleMaps) {
        this.multipleMaps = multipleMaps;
    }

    @Override
    public Optional<String> matchNumber(int number) {
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
