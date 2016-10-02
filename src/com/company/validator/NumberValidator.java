package com.company.validator;

public class NumberValidator<N extends Long> implements Validator<N> {

    @Override
    public boolean isValid(Long result) {
        if (result > 0) {
            return true;
        }
        return false;
    }
}
