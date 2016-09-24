package com.company;

public interface Validator<N> {

    // Валидирует переданое значение
    boolean isValid(N result);

}
