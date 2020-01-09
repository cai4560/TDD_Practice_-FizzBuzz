package com.thoughtworks;

import com.thoughtworks.matcher.MultipleMatcher;
import com.thoughtworks.matcher.RuleMatcher;
import com.thoughtworks.matcher.SymbolMatcher;

import java.util.List;

public class FizzBuzz {

    private final List<RuleMatcher> ruleMatchers;

    public FizzBuzz() {
        ruleMatchers = List.of(
                new MultipleMatcher(),
                new SymbolMatcher()
        );
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
