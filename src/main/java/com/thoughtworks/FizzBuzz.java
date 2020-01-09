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
        return findOptionalMultiple(number).orElse(String.valueOf(number));
    }

    private Optional<String> findOptionalMultiple(final int number) {
        return multipleMaps.entrySet().stream()
                .filter(entry -> isDivisible(number, entry.getKey()))
                .map(Map.Entry::getValue)
                .findFirst();
    }

    private boolean isDivisible(int number, int multiple) {
        return number % multiple == 0;
    }
}
