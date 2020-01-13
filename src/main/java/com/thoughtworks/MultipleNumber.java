package com.thoughtworks;

public enum MultipleNumber {
    FIZZ(3, "Fizz"),
    BUZZ(5, "Buzz"),
    WHIZZ(7, "Whizz");

    private int multiple;
    private String value;

    MultipleNumber(int multiple, String value) {
        this.multiple = multiple;
        this.value = value;
    }

    public int getMultiple() {
        return multiple;
    }

    public String getValue() {
        return value;
    }
}