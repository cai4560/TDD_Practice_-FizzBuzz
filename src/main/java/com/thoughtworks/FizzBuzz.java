package com.thoughtworks;

import com.thoughtworks.matcher.MultiMultipleMatcher;
import com.thoughtworks.matcher.MultipleMatcher;
import com.thoughtworks.matcher.RuleMatcher;
import com.thoughtworks.matcher.SymbolMatcher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FizzBuzz {

    public String say(int number) {
        List<RuleMatcher> ruleMatchers = initialMatchers(number);

        for (RuleMatcher matcher : ruleMatchers) {
            if (matcher.isEnabled() && matcher.matchNumber(number).isPresent()) {
                return matcher.matchNumber(number).get();
            }
        }

        return String.valueOf(number);
    }

    private List<RuleMatcher> initialMatchers(int number) {
        boolean notContains5 = numberNotContains(number, "5");
        boolean notContains3 = !notContains5 || numberNotContains(number, "3");

        Map<Integer, String> multipleMaps = initialMultipleMap();
        if (!notContains5) {
            multipleMaps.remove(3);
        }

        List<RuleMatcher> ruleMatchers;
        ruleMatchers = new ArrayList<>();
        ruleMatchers.add(new MultiMultipleMatcher(multipleMaps, notContains3));
        ruleMatchers.addAll(multipleMaps.entrySet().stream()
                .map(entry -> new MultipleMatcher(entry.getKey(), entry.getValue(), notContains3))
                .collect(java.util.stream.Collectors.toList()));
        ruleMatchers.add(new SymbolMatcher("3", "Fizz", notContains5));
        return ruleMatchers;
    }

    private static Map<Integer, String> initialMultipleMap() {
        Map<Integer, String> multipleMaps = new HashMap<>();

        multipleMaps.put(3, "Fizz");
        multipleMaps.put(5, "Buzz");
        multipleMaps.put(7, "Whizz");

        return multipleMaps;
    }

    private boolean numberNotContains(int number, String symbol) {
        return !String.valueOf(number).contains(symbol);
    }
}
