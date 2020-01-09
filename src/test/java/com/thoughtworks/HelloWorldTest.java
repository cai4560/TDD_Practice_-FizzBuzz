package com.thoughtworks;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HelloWorldTest {

    private HelloWorld helloWorld;

    @BeforeEach
    public void setUp() {
        helloWorld = new HelloWorld();
    }

    @Test
    public void should_say_hello_world() {
        Assertions.assertThat(helloWorld.say()).isEqualTo("Hello World!");
    }
}