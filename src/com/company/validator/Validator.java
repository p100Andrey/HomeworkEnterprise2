package com.company.validator;

public interface Validator<N> {

    // Валидирует переданое значение
    boolean isValid(N result);

}
