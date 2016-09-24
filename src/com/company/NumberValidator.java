package com.company;

public class NumberValidator implements Validator<Long> {
    private static Long validator;

    NumberValidator(){

    }

    NumberValidator(Long validator){
        this.validator = validator;
    }

    @Override
    public boolean isValid(Long result) {
        if (result % validator == 0) {
            return true;
        }
        return false;
    }
}
