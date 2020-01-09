package com.thoughtworks;

import java.util.Map;
import java.util.Optional;

public class FizzBuzz {

    private static final Map<Integer, String> multipleMaps = Map.of(
            3, "Fizz",
            5, "Buzz",
            7, "Whizz"
    );

    public String say(int number) {
        Optional<String> optionalMultiples = findOptionalMultiples(number);

        return optionalMultiples.orElseGet(
                () -> String.valueOf(number).contains("3") ? "Fizz" : String.valueOf(number));
    }

    private Optional<String> findOptionalMultiples(final int number) {
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
