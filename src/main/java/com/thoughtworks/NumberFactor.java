package com.thoughtworks;

public enum NumberFactor {
    THREE(3, "Fizz"),
    FIVE(5, "Buzz"),
    SEVEN(7, "Whizz");

    private int number;
    private String value;

    NumberFactor(int number, String value) {
        this.number = number;
        this.value = value;
    }

    public int getNumber() {
        return number;
    }

    public String getNumberStr() {
        return String.valueOf(number);
    }

    public String getValue() {
        return value;
    }
}