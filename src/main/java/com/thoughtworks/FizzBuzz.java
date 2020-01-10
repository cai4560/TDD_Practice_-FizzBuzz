package com.thoughtworks;

import com.thoughtworks.matcher.MultiMultipleMatcher;
import com.thoughtworks.matcher.MultipleMatcher;
import com.thoughtworks.matcher.RuleMatcher;
import com.thoughtworks.matcher.SymbolMatcher;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FizzBuzz {

    private static final Map<Integer, String> multipleMaps = Map.of(
            3, "Fizz",
            5, "Buzz",
            7, "Whizz"
    );

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
        boolean enableMultiple = numberNotContains(number, "3");

        List<RuleMatcher> ruleMatchers;
        ruleMatchers = new ArrayList<>();
        ruleMatchers.add(new MultiMultipleMatcher(multipleMaps, enableMultiple));
        ruleMatchers.addAll(multipleMaps.entrySet().stream()
                .map(entry -> new MultipleMatcher(entry.getKey(), entry.getValue(), enableMultiple))
                .collect(java.util.stream.Collectors.toList()));
        ruleMatchers.add(new SymbolMatcher("3", "Fizz", true));
        return ruleMatchers;
    }

    private boolean numberNotContains(int number, String symbol) {
        return !String.valueOf(number).contains(symbol);
    }
}
