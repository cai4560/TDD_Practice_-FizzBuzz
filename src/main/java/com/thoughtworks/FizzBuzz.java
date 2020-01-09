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

    private final List<RuleMatcher> ruleMatchers;

    public FizzBuzz() {
        ruleMatchers = new ArrayList<>();
        ruleMatchers.add(new MultiMultipleMatcher(multipleMaps));
        ruleMatchers.addAll(multipleMaps.entrySet().stream()
                .map(entry -> new MultipleMatcher(entry.getKey(), entry.getValue()))
                .collect(java.util.stream.Collectors.toList()));
        ruleMatchers.add(new SymbolMatcher("3", "Fizz"));
    }

    public String say(int number) {
        for (RuleMatcher matcher : ruleMatchers) {
            if (matcher.matchNumber(number).isPresent()) {
                return matcher.matchNumber(number).get();
            }
        }

        return String.valueOf(number);
    }
}
