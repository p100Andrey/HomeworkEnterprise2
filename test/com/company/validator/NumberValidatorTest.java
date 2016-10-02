package com.company.validator;

import com.company.validator.NumberValidator;
import com.company.validator.Validator;
import org.junit.Test;

import static org.junit.Assert.*;

public class NumberValidatorTest {

    @Test
    public void testIsValidTrue() throws Exception {
        Validator numberValidator = new NumberValidator();
        assertTrue(numberValidator.isValid(30L));
    }

    @Test
    public void testIsValidFalse() throws Exception {
        Validator numberValidator = new NumberValidator();
        assertFalse(numberValidator.isValid(-35L));
    }

}