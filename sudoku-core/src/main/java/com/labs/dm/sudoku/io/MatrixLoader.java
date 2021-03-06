package com.labs.dm.sudoku.io;

import com.labs.dm.sudoku.core.Matrix;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 * Class
 *
 * @author daniel
 */
public class MatrixLoader {

    private final static String DEFAULT_DELIMITER = ",";

    public Matrix load(String fileName) throws IOException {
        String inputText = readFileAsString(fileName);
        int[] tab = convertToIntTable(toTable(inputText));
        return new Matrix(tab);
    }

    public void save(Matrix matrix, String fileName) throws IOException {
        StringBuilder sb = new StringBuilder(100);
        for (int row = 0; row < Matrix.SIZE; row++) {
            for (int col = 0; col < Matrix.SIZE; col++) {
                sb.append(matrix.getCellValue(row, col));
                if (col < Matrix.SIZE - 1) {
                    sb.append(DEFAULT_DELIMITER);
                }
            }
            if (row < Matrix.SIZE - 1) {
                sb.append(System.lineSeparator());
            }
        }
        File file = new File(fileName);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            fos.write(sb.toString().getBytes(Charset.defaultCharset()));
        }
    }

    protected int[] convertToIntTable(String[] stringTab) {
        int[] intTab = new int[stringTab.length];

        for (int i = 0; i < stringTab.length; i++) {
            intTab[i] = Integer.parseInt(stringTab[i].trim());
        }

        return intTab;
    }

    protected String[] toTable(String input) {
        input = input.trim();
        input = input.replaceAll("[\\s*,\\s*]+", ",").replaceAll("[\\s]+", ",");
        return input.split("[\n\t,;]");
    }

    protected String readFileAsString(String filePath) throws IOException {
        StringBuilder fileData = new StringBuilder(Matrix.SIZE);
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filePath);
        if (inputStream == null) {
            inputStream = new FileInputStream(filePath);
            if (inputStream == null) {
                throw new FileNotFoundException();
            }
        }
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            char[] buf = new char[1024];
            int numRead;
            while ((numRead = reader.read(buf)) != -1) {
                String readData = String.valueOf(buf, 0, numRead);
                fileData.append(readData);
                buf = new char[128];
            }
        }
        return fileData.toString();
    }

}
