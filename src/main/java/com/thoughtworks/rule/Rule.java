package com.thoughtworks.rule;

import java.util.Optional;

public abstract class Rule {

    private boolean isEnabled;

    public Rule(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public abstract Optional<String> apply(int number);
}
