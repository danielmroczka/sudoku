/*
 * Copyright daniel.mroczka@gmail.com. All rights reserved. 
 */

package com.labs.dm.sudoku.core.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author daniel
 */
public class ValidatorTest {

    @Test
    public void shouldValidateValidArray() {
        //GIVEN
        int[] input = {1,2,3,4,5,6,7,8,9};
        //WHEN
        boolean result = Validator.isValidArray(input);
        //THEN
        assertTrue(result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotValidateInvalidArray() {
        //GIVEN
        int[] input = {1,2,3,4,4,6,7,8,9};
        //WHEN
        boolean result = Validator.isValidArray(input);
        //THEN
        assertFalse(result);
    }
    
}
