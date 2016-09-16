package com.company;

public class NumberValidator<N extends Number> implements Validator {
    Long validator;

    @Override
    public boolean isValid(Task result) {
        if (result.getResult() % validator == 0) {
            return true;
        }
        return false;
    }
}
