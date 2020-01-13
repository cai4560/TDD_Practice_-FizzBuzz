package com.thoughtworks.rule;

import java.util.Optional;

public interface Rule {

    Optional<String> apply(int number);
}
