package com.thoughtworks.matcher;

import java.util.Optional;

public class SymbolMatcher extends RuleMatcher {

    private final String symbol;

    private final String text;

    public SymbolMatcher(String symbol, String text, boolean isEnabled) {
        super(isEnabled);
        this.symbol = symbol;
        this.text = text;
    }

    @Override
    public Optional<String> matchNumber(int number) {
        return containSymbol(number, symbol) ? Optional.of(text) : Optional.empty();
    }

    private boolean containSymbol(int number, String symbol) {
        return String.valueOf(number).contains(symbol);
    }
}
