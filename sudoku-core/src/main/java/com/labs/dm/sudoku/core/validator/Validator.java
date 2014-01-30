/*
 * Copyright daniel.mroczka@gmail.com. All rights reserved. 
 */
package com.labs.dm.sudoku.core.validator;

import com.labs.dm.sudoku.core.Matrix;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author daniel
 */
public class Validator {

    public static boolean isSolved(Matrix matrix) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (matrix.getCellValue(row, col) < 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isEmpty(Matrix matrix) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (matrix.getCellValue(row, col) > 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValid(Matrix matrix) {
        return isValidInRows(matrix) && isValidInCols(matrix) && isValidInBlocks(matrix);
    }

    public static boolean isValidInCols(Matrix matrix) {
        Set<Integer> set = new HashSet<Integer>();
        for (int col = 0; col < 9; col++) {
            for (int row = 0; row < 9; row++) {
                int value = matrix.getCellValue(row, col);
                if (value < 0 || value > 9) {
                    throw new IllegalStateException("Incorrect value");
                }
                if (value > 0 && set.contains(value)) {
                    throw new IllegalStateException("Double value");
                }
                set.add(value);

            }
            set.clear();
        }
        return true;
    }

    public static boolean isValidInRows(Matrix matrix) {
        Set<Integer> set = new HashSet<Integer>();
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                int value = matrix.getCellValue(row, col);
                if (value < 0 || value > 9) {
                    throw new IllegalStateException("Incorrect value");
                }
                if (value > 0 && set.contains(value)) {
                    throw new IllegalStateException("Double value");
                }
                set.add(value);

            }
            set.clear();
        }
        return true;
    }

    public static boolean isValidInBlocks(Matrix matrix) {
        Set<Integer> set = new HashSet<Integer>();
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                int value = matrix.getCellValue(row, col);
                if (value < 0 || value > 9) {
                    throw new IllegalStateException("Incorrect value");
                }
                if (value > 0 && set.contains(value)) {
                    throw new IllegalStateException("Double value");
                }
                set.add(value);

            }
            set.clear();
        }
        return true;
    }

    protected static boolean isValidArray(int[] tab) {
        Set<Integer> set = new HashSet<Integer>();
        for (int val : tab) {
            if (val > 0 && set.contains(val)) {
                throw new IllegalArgumentException("Doubled value " + val + " in array: " + Arrays.toString(tab));
            }
            set.add(val);
        }
        
        return true;
    }

}
