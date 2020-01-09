package com.thoughtworks.matcher;

import java.util.Optional;

public interface RuleMatcher {

    Optional<String> matchNumber(int number);
}
