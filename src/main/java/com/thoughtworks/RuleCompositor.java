package com.thoughtworks;

import com.thoughtworks.rule.ContainRule;
import com.thoughtworks.rule.MultipleRule;
import com.thoughtworks.rule.Rule;

import java.util.ArrayList;
import java.util.List;

public class RuleCompositor {

    public List<Rule> compositeRules(int number) {
        boolean contain7 = contains(number, "7");
        boolean contain5 = !contain7 && contains(number, "5");
        boolean contain3 = !contain5 && contains(number, "3");

        List<MultipleNumber> multipleNumbers = compositeMultipleNumbers(contain7, contain5);

        return List.of(
                new MultipleRule(!contain3, multipleNumbers),
                new ContainRule(!contain5, "3", "Fizz")
        );
    }

    private List<MultipleNumber> compositeMultipleNumbers(boolean contain7, boolean contain5) {
        List<MultipleNumber> multipleNumbers = new ArrayList<>();

        if (!contain5) {
            multipleNumbers.add(MultipleNumber.FIZZ);
        }
        if (!contain7) {
            multipleNumbers.add(MultipleNumber.BUZZ);
        }

        multipleNumbers.add(MultipleNumber.WHIZZ);
        return multipleNumbers;
    }

    private boolean contains(int number, String factor) {
        return String.valueOf(number).contains(factor);
    }
}