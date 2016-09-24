package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumberValidatorTest {

    @Test
    public void testIsValidTrue() throws Exception {
        Validator numberValidator = new NumberValidator(10L);
        assertTrue(numberValidator.isValid(30L));
    }

    @Test(expected = AssertionError.class)
    public void testIsValidFalse() throws Exception {
        Validator numberValidator = new NumberValidator(10L);
        assertTrue(numberValidator.isValid(35L));
    }

}