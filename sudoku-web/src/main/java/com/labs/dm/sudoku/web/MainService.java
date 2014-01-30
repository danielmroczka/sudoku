/*
 * Copyright daniel.mroczka@gmail.com. All rights reserved. 
 */
package com.labs.dm.sudoku.web;

import com.labs.dm.sudoku.core.Matrix;
import com.labs.dm.sudoku.core.SudokuSolver;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author daniel
 */
@Controller
@RequestMapping(value = "/rest")
public class MainService {

    private final SudokuSolver solver = new SudokuSolver();

    @ResponseBody
    @RequestMapping(value = "/{args}", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public String hello(@PathVariable int[] args) {
        Matrix matrix = new Matrix(args);
        Matrix res = solver.solve(matrix);
        return res.toString();
    }
}
