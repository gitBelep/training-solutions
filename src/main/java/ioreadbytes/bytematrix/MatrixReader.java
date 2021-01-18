package ioreadbytes.bytematrix;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MatrixReader {
    private final List<byte[]> matrix = new ArrayList<>();

    public void readBytesAndCreateMatrix(String s) {
        try (InputStream is = Files.newInputStream(Path.of(s))) {
            byte[] puffer = new byte[1000];
            while (  is.read(puffer) > 0 ){
                matrix.add(puffer);
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Cannot read file", e);
        }
    }

    public int numberOfColumnsWhereMoreZeros(){
        int sumZero = 0;
        int nrZero = 0;
        int nrOne = 0;
        for (int k = 0; k < 1000; k++){
            for (byte[] b : matrix) {
                if (b[k] == (byte) '0') {
                    nrZero++;
                } else {
                    nrOne++;
                }
            }
            if (nrZero > nrOne){
                sumZero++;
            }
            nrOne = 0;
            nrZero = 0;
        }
        return sumZero;
    }

    public List<byte[]> getMyMatrix(){
        return new ArrayList<>(matrix);
    }
}
