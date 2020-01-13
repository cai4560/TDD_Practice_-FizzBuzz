package com.thoughtworks.rule;

import com.thoughtworks.NumberFactor;

import java.util.ArrayList;
import java.util.List;

public class RuleCompositor {

    public List<Rule> compositeRules(int number) {
        boolean contain7 = contains(number, NumberFactor.SEVEN.getNumberStr());
        boolean contain5 = !contain7 && contains(number, NumberFactor.FIVE.getNumberStr());
        boolean contain3 = !contain5 && contains(number, NumberFactor.THREE.getNumberStr());

        List<NumberFactor> numberFactors = compositeMultipleNumbers(contain7, contain5);

        return List.of(
                new MultipleRule(!contain3, numberFactors),
                new ContainRule(!contain5, NumberFactor.THREE)
        );
    }

    private List<NumberFactor> compositeMultipleNumbers(boolean contain7, boolean contain5) {
        List<NumberFactor> numberFactors = new ArrayList<>();

        if (!contain5) {
            numberFactors.add(NumberFactor.THREE);
        }
        if (!contain7) {
            numberFactors.add(NumberFactor.FIVE);
        }

        numberFactors.add(NumberFactor.SEVEN);
        return numberFactors;
    }

    private boolean contains(int number, String factor) {
        return String.valueOf(number).contains(factor);
    }
}