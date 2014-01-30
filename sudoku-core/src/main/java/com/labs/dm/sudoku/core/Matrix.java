/*
 * Copyright daniel.mroczka@gmail.com. All rights reserved. 
 */
package com.labs.dm.sudoku.core;

/**
 * @author daniel
 */
public class Matrix {

    //TODO Refactor it!
    public final int[][] tab;
    public final static int SIZE = 9;

    public Matrix(int[][] tab) {
        if (tab.length == 0) {
            throw new IllegalArgumentException("Empty Input Array!");
        }
        if (tab.length != 9 || tab[0].length != 9) {
            throw new IllegalArgumentException("Incorrect array size. Acceptable size is 9x9");
        }
        this.tab = tab;
    }

    public Matrix(int[] tab) {
        if (tab.length == 0) {
            throw new IllegalArgumentException("Empty Input Array!");
        }
        if (tab.length != 81) {
            throw new IllegalArgumentException("Incorrect array size. Acceptable size is 81");
        }
        this.tab = new int[9][9];
        loadFromArray(tab);
    }

    protected final void loadFromArray(int... items) {
        if (items.length != SIZE * SIZE) {
            throw new IllegalArgumentException("Ïncorrect input array length!");
        }
        int index = 0;
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                setCellValue(row, col, items[index++]);
            }
        }
    }

    public int getCellValue(int row, int col) {
        return tab[row][col];
    }

    public void setCellValue(int row, int col, int value) {
        tab[row][col] = value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String line = " -----------------------";
        for (int i = 0; i < Matrix.SIZE; ++i) {
            if (i % 3 == 0) {
                //System.out.println(line);
                sb.append(line);
                sb.append("\n");
            }
            for (int j = 0; j < Matrix.SIZE; ++j) {
                if (j % 3 == 0) {
                    sb.append("| ");

                }
                sb.append(tab[i][j] == 0 ? " " : Integer.toString(tab[i][j]));
                sb.append(' ');
            }
            sb.append("|");
            sb.append("\n");
        }
        sb.append(line);
        sb.append("\n");

        return sb.toString();
    }

}
