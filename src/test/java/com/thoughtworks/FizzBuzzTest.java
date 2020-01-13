package com.thoughtworks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FizzBuzzTest {

    private FizzBuzz fizzBuzz;

    @BeforeEach
    public void setUp() {
        fizzBuzz = new FizzBuzz();
    }

    @Test
    public void should_say_1_when_input_1() {
        assertThat(fizzBuzz.say(1)).isEqualTo("1");
    }

    @Test
    public void should_say_2_when_input_2() {
        assertThat(fizzBuzz.say(2)).isEqualTo("2");
    }

    @Test
    public void should_say_Fizz_when_input_3() {
        assertThat(fizzBuzz.say(3)).isEqualTo("Fizz");
    }

    @Test
    public void should_say_Buzz_when_input_5() {
        assertThat(fizzBuzz.say(5)).isEqualTo("Buzz");
    }

    @Test
    public void should_say_Whizz_when_input_7() {
        assertThat(fizzBuzz.say(7)).isEqualTo("Whizz");
    }

    @Test
    public void should_say_FizzWhizz_when_input_21() {
        assertThat(fizzBuzz.say(21)).isEqualTo("FizzWhizz");
    }

    @Test
    public void should_say_Fizz_when_input_13_for_contains_3() {
        assertThat(fizzBuzz.say(13)).isEqualTo("Fizz");
    }

    @Test
    public void should_say_Fizz_when_input_30_for_rule5() {
        assertThat(fizzBuzz.say(30)).isEqualTo("Fizz");
    }

    @Test
    public void should_say_BuzzWhizz_when_input_35_for_rule6() {
        assertThat(fizzBuzz.say(35)).isEqualTo("BuzzWhizz");
    }

    @Test
    public void should_say_Buzz_when_input_15_for_rule6() {
        assertThat(fizzBuzz.say(15)).isEqualTo("Buzz");
    }

    @Test
    public void should_say_Fizz_when_input_75_for_rule7() {
        assertThat(fizzBuzz.say(75)).isEqualTo("Fizz");
    }
}