package com.thoughtworks;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
        Optional<String> optionalMultipleValue = getOptionalMultipleValue(number);
        return optionalMultipleValue.orElseGet(()
                -> String.valueOf(number).contains("3") ? "Fizz" : String.valueOf(number));

    }

    private Optional<String> getOptionalMultipleValue(int number) {
        return Stream.of(MultipleNumber.values())
                .filter(multiple -> isDivisible(number, multiple.getMultiple()))
                .map(MultipleNumber::getValue)
                .reduce(String::concat);
    }

    private boolean isDivisible(int number, int multiple) {
        return number % multiple == 0;
    }
}
