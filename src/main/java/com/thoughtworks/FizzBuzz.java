package com.thoughtworks;

import com.thoughtworks.matcher.MultipleMatcher;
import com.thoughtworks.matcher.RuleMatcher;
import com.thoughtworks.matcher.SymbolMatcher;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class FizzBuzz {

    public static void main(String[] args) throws IOException {
        FileWriter writer = new FileWriter("result.txt", false);

        FizzBuzz fizzBuzz = new FizzBuzz();
        IntStream.range(1, 1025).forEach(number -> {
            try {
                writer.write(String.format("%s %s\n", number, fizzBuzz.say(number)));
            } catch (IOException ignore) {
            }
        });

        writer.close();
    }

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
        boolean rule7Enabled = numberContains(number, "7");
        boolean rule6Enabled = !rule7Enabled && numberContains(number, "5");
        boolean rule5Enabled = !rule6Enabled && numberContains(number, "3");

        Map<Integer, String> multipleMaps = initialMultipleMap(rule7Enabled, rule6Enabled);

        List<RuleMatcher> ruleMatchers;
        ruleMatchers = new ArrayList<>();
        ruleMatchers.add(new MultipleMatcher(multipleMaps, !rule5Enabled));
        ruleMatchers.add(new SymbolMatcher("3", "Fizz", !rule6Enabled));
        return ruleMatchers;
    }

    private Map<Integer, String> initialMultipleMap(boolean rule7Enabled, boolean rule6Enabled) {
        Map<Integer, String> multipleMaps = new HashMap<>();
        multipleMaps.put(7, "Whizz");

        if (!rule7Enabled) {
            multipleMaps.put(5, "Buzz");
        }

        if (!rule6Enabled) {
            multipleMaps.put(3, "Fizz");
        }
        return multipleMaps;
    }

    private boolean numberContains(int number, String symbol) {
        return String.valueOf(number).contains(symbol);
    }
}
