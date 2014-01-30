/*
 * Copyright daniel.mroczka@gmail.com. All rights reserved. 
 */
package com.labs.dm.sudoku.io;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author daniel
 */
public class MatrixLoaderTest {

    private final MatrixLoader loader = new MatrixLoader();

    @Test
    public void shouldReadFileAsString() throws Exception {
        //WHEN
        String result = loader.readFileAsString("patterns/empty.txt");
        //THEN
        assertNotNull(result);
        //assertEquals((9 + 8) * 9 + 8 * 2, result.length());
    }

   

}
