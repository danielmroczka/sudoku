/*
 * Copyright daniel.mroczka@gmail.com. All rights reserved. 
 */

package com.labs.dm.sudoku.core;

import com.labs.dm.sudoku.core.validator.Validator;

/**
 * @author daniel
 */
public class App {
    public static void main(String[] args) {
        Matrix matrix = new Matrix(new int[81]);
        SudokuSolver solver = new SudokuSolver();
        solver.solve(matrix);
        System.out.println(Validator.isValid(matrix));
        System.out.println(matrix.tab);
    }
}
