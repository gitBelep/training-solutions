package ioreadbytes.bytematrix;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MatrixReaderTest {
    MatrixReader matrixReader = new MatrixReader();


    @Test
    public void readBytesAndCreateMatrixTest() {
        assertEquals(0, matrixReader.getMyMatrix().size());
        matrixReader.readBytesAndCreateMatrix("matrix.dat");

        assertEquals(9, matrixReader.getMyMatrix().size());
        assertEquals(1000, matrixReader.getMyMatrix().get(5).length);

        for (int i = 0; i < 1000; i++){
            System.out.printf("%4d", i);
        }
        System.out.println();
        System.out.println(Arrays.toString(matrixReader.getMyMatrix().get(0)));
        System.out.println(Arrays.toString(matrixReader.getMyMatrix().get(1)));
        System.out.println(Arrays.toString(matrixReader.getMyMatrix().get(2)));
        System.out.println(Arrays.toString(matrixReader.getMyMatrix().get(3)));
        System.out.println(Arrays.toString(matrixReader.getMyMatrix().get(4)));
        System.out.println(Arrays.toString(matrixReader.getMyMatrix().get(5)));
        System.out.println(Arrays.toString(matrixReader.getMyMatrix().get(6)));
        System.out.println(Arrays.toString(matrixReader.getMyMatrix().get(7)));
        System.out.println(Arrays.toString(matrixReader.getMyMatrix().get(8)));
    }


    @Test
    public void numberOfColumnsWhereMoreZeros() {
        matrixReader.readBytesAndCreateMatrix("matrix.dat");
        assertEquals(493, matrixReader.numberOfColumnsWhereMoreZeros());
    }

}
