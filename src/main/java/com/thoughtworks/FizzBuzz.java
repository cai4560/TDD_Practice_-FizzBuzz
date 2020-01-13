package com.thoughtworks;

import com.thoughtworks.rule.ContainRule;
import com.thoughtworks.rule.MultipleRule;
import com.thoughtworks.rule.Rule;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
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
        return initialRules().stream()
                .map(rule -> rule.apply(number))
                .flatMap(Optional::stream)
                .findFirst()
                .orElse(String.valueOf(number));
    }

    private List<Rule> initialRules() {
        return List.of(
                new MultipleRule(Arrays.asList(MultipleNumber.values())),
                new ContainRule("3", "Fizz")
        );
    }
}
