package com.thoughtworks.matcher;

import java.util.Optional;

public abstract class RuleMatcher {

    private boolean isEnabled;

    public RuleMatcher(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    public abstract Optional<String> matchNumber(int number);

    public boolean isEnabled() {
        return isEnabled;
    }
}
