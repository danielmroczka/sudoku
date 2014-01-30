/*
 * Copyright daniel.mroczka@gmail.com. All rights reserved. 
 */

package com.labs.dm.sudoku.core;

import com.labs.dm.sudoku.io.MatrixLoader;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
        assertTrue(solver.solve(matrix));
    }
    
}
