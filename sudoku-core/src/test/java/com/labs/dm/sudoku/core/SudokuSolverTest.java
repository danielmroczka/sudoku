/*
 * Copyright daniel.mroczka@gmail.com. All rights reserved. 
 */

package com.labs.dm.sudoku.core;

import com.labs.dm.sudoku.core.validator.Validator;
import com.labs.dm.sudoku.io.MatrixLoader;
import java.io.IOException;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author daniel
 */
public class SudokuSolverTest {
    
    @Test
    public void shouldSolve() throws IOException {
        MatrixLoader loader = new MatrixLoader();
        Matrix matrix = loader.load("patterns/real.txt");
        SudokuSolver solver = new SudokuSolver();
        assertTrue(Validator.isSolved(solver.solve(matrix)));
    }
    
}
