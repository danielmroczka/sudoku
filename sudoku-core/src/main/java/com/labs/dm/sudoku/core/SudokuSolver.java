/*
 * Copyright daniel.mroczka@gmail.com. All rights reserved. 
 */
package com.labs.dm.sudoku.core;

import com.labs.dm.sudoku.core.validator.Validator;

/**
 * @author daniel
 */
public class SudokuSolver {

    private final int SIZE = 9;
    private final int EMPTY = 0;

    public boolean solve(Matrix array) {
        boolean res = false;
        if (Validator.isValid(array)) {
            res = solve(0, 0, array);
        }
        printMatrix(array);
        return res;
    }

    private boolean solve(int row, int col, Matrix cells) {
        if (row == SIZE) {
            row = 0;
            if (++col == SIZE) {
                return true;
            }
        }
        // skip filled cells
        if (cells.tab[row][col] != EMPTY) {
            return solve(row + 1, col, cells);
        }

        for (int val = 1; val <= SIZE; ++val) {
            if (accept(row, col, val, cells)) {
                cells.tab[row][col] = val;
                if (solve(row + 1, col, cells)) {
                    return true;
                }
            }
        }
        cells.tab[row][col] = 0; // reset on backtrack
        return false;
    }

    private boolean accept(int row, int col, int val, Matrix cells) {
        for (int rowIdx = 0; rowIdx < SIZE; ++rowIdx) {
            if (val == cells.tab[rowIdx][col]) {
                return false;
            }
        }

        for (int colIdx = 0; colIdx < SIZE; ++colIdx) {
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

    private void printMatrix(Matrix solution) {
        String line = " -----------------------";
        for (int i = 0; i < SIZE; ++i) {
            if (i % 3 == 0) {
                System.out.println(line);
            }
            for (int j = 0; j < SIZE; ++j) {
                if (j % 3 == 0) {
                    System.out.print("| ");
                }
                System.out.print(solution.tab[i][j] == 0 ? " " : Integer.toString(solution.tab[i][j]));
                System.out.print(' ');
            }
            System.out.println("|");
        }
        System.out.println(line);
    }

}
