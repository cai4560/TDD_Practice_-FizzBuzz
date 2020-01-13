package com.thoughtworks;

import com.thoughtworks.rule.Rule;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;
import java.util.stream.IntStream;

public class FizzBuzz {

    private final RuleCompositor ruleCompositor;

    public FizzBuzz() {
        ruleCompositor = new RuleCompositor();
    }

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
        return ruleCompositor.compositeRules(number).stream()
                .filter(Rule::isEnabled)
                .map(rule -> rule.apply(number))
                .flatMap(Optional::stream)
                .findFirst()
                .orElse(String.valueOf(number));
    }
}
