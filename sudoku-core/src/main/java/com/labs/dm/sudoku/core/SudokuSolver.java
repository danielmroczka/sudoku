/*
 * Copyright daniel.mroczka@gmail.com. All rights reserved. 
 */
package com.labs.dm.sudoku.core;

import com.labs.dm.sudoku.core.validator.Validator;

/**
 * @author daniel
 */
public class SudokuSolver {

    private final int EMPTY = 0;

    public Matrix solve(Matrix array) {
        if (Validator.isValid(array)) {
            solve(0, 0, array);
        }
        System.out.println(array.toString());
        return array;
    }

    private boolean solve(int row, int col, Matrix cells) {
        if (row == Matrix.SIZE) {
            row = 0;
            if (++col == Matrix.SIZE) {
                return true;
            }
        }
        // skip filled cells
        if (cells.tab[row][col] != EMPTY) {
            return solve(row + 1, col, cells);
        }

        for (int val = 1; val <= Matrix.SIZE; ++val) {
            if (accept(row, col, val, cells)) {
                cells.tab[row][col] = val;
                if (solve(row + 1, col, cells)) {
                    return true;
                }
            }
        }
        cells.tab[row][col] = 0;
        return false;
    }

    private boolean accept(int row, int col, int val, Matrix cells) {
        for (int rowIdx = 0; rowIdx < Matrix.SIZE; ++rowIdx) {
            if (val == cells.tab[rowIdx][col]) {
                return false;
            }
        }

        for (int colIdx = 0; colIdx < Matrix.SIZE; ++colIdx) {
            if (val == cells.tab[row][colIdx]) {
                return false;
            }
        }

        int boxRowOffset = (row / 3) * 3;
        int boxColOffset = (col / 3) * 3;
        for (int rowIdx = 0; rowIdx < 3; ++rowIdx) {
            for (int colIdx = 0; colIdx < 3; ++colIdx) {
                if (val == cells.tab[boxRowOffset + rowIdx][boxColOffset + colIdx]) {
                    return false;
                }
            }
        }

        return true; // no violations, so it's legal
    }

}
