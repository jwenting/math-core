package com.captainduckman.math;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Matrix Test")
class MatrixTest extends AbstractMathTest {


    @BeforeEach
    void before() {
    }

    @Test
    void testAccessors() {
        Matrix matrix = new Matrix(4);
        matrix.set(0, 0, 1.0);
        matrix.set(0, 1, 2.0);
        matrix.set(0, 2, 3.0);
        matrix.set(0, 3, 4.0);
        matrix.set(1, 0, 5.5);
        matrix.set(1, 1, 6.5);
        matrix.set(1, 2, 7.5);
        matrix.set(1, 3, 8.5);
        matrix.set(2, 0, 9.0);
        matrix.set(2, 1, 10.0);
        matrix.set(2, 2, 11.0);
        matrix.set(2, 3, 12.0);
        matrix.set(3, 0, 13.5);
        matrix.set(3, 1, 14.5);
        matrix.set(3, 2, 15.5);
        matrix.set(3, 3, 16.5);

        assertEquals(1.0, matrix.get(0, 0), DEFAULT_PRECISION);
        assertEquals(4.0, matrix.get(0, 3), DEFAULT_PRECISION);
        assertEquals(5.5, matrix.get(1, 0), DEFAULT_PRECISION);
        assertEquals(7.5, matrix.get(1, 2), DEFAULT_PRECISION);
        assertEquals(11.0, matrix.get(2, 2), DEFAULT_PRECISION);
        assertEquals(13.5, matrix.get(3, 0), DEFAULT_PRECISION);
        assertEquals(15.5, matrix.get(3, 2), DEFAULT_PRECISION);
    }

    @Test
    void test2x2() {
        Matrix matrix = new Matrix(2);
        matrix.set(0, 0, -3);
        matrix.set(0, 1, 5);
        matrix.set(1, 0, 1);
        matrix.set(1, 1, -2);
        assertEquals(-3, matrix.get(0, 0), DEFAULT_PRECISION);
        assertEquals(5, matrix.get(0, 1), DEFAULT_PRECISION);
        assertEquals(1, matrix.get(1, 0), DEFAULT_PRECISION);
        assertEquals(-2, matrix.get(1, 1), DEFAULT_PRECISION);
    }

    @Test
    void test3x3() {
        Matrix matrix = new Matrix(3);
        matrix.set(0, 0, -3);
        matrix.set(0, 1, 5);
        matrix.set(0, 2, 0);
        matrix.set(1, 0, 1);
        matrix.set(1, 1, -2);
        matrix.set(1, 2, -7);
        matrix.set(2, 0, 0);
        matrix.set(2, 1, 1);
        matrix.set(2, 2, 1);
        assertEquals(-3, matrix.get(0, 0), DEFAULT_PRECISION);
        assertEquals(-2, matrix.get(1, 1), DEFAULT_PRECISION);
        assertEquals(1, matrix.get(2, 2), DEFAULT_PRECISION);
    }

    @Test
    void testEquals2() {
        Matrix matrix = new Matrix(3);
        matrix.set(0, 0, -3);
        matrix.set(0, 1, 5);
        matrix.set(0, 2, 0);
        matrix.set(1, 0, 1);
        matrix.set(1, 1, -2);
        matrix.set(1, 2, -7);
        matrix.set(2, 0, 0);
        matrix.set(2, 1, 1);
        matrix.set(2, 2, 1);
        Matrix matrix2 = new Matrix(3);
        matrix2.set(0, 0, -3);
        matrix2.set(0, 1, 5);
        matrix2.set(0, 2, 0);
        matrix2.set(1, 0, 1);
        matrix2.set(1, 1, -2);
        matrix2.set(1, 2, -7);
        matrix2.set(2, 0, 0);
        matrix2.set(2, 1, 1);
        matrix2.set(2, 2, 1);


        assertEquals(matrix, matrix2);
        matrix2.set(1, 2, -3);
        assertNotEquals(matrix, matrix2);
        matrix2.set(1, 2, -7);
        matrix2.set(2, 1, -7);
        assertNotEquals(matrix, matrix2);

    }

    @Test
    void testError1() {
        Matrix matrix = new Matrix(3);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> matrix.get(-1, 0));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> matrix.set(-1, 0, 1));
    }

    @Test
    void testError2() {
        Matrix matrix = new Matrix(3);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> matrix.get(1, -1));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> matrix.set(1, -1, 1));
    }

    @Test
    void testError3() {
        Matrix matrix = new Matrix(3);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> matrix.get(10, 0));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> matrix.set(10, 0, 1));
    }

    @Test
    void testError4() {
        Matrix matrix = new Matrix(3);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> matrix.get(1, 10));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> matrix.set(1, 10, 1));
    }

    @Test
    void multiply() {
        Matrix matrix = new Matrix(4);
        Matrix matrix2 = new Matrix(4);

        matrix.set(0, 0, 1);
        matrix.set(0, 1, 2);
        matrix.set(0, 2, 3);
        matrix.set(0, 3, 4);
        matrix.set(1, 0, 2);
        matrix.set(1, 1, 3);
        matrix.set(1, 2, 4);
        matrix.set(1, 3, 5);
        matrix.set(2, 0, 3);
        matrix.set(2, 1, 4);
        matrix.set(2, 2, 5);
        matrix.set(2, 3, 6);
        matrix.set(3, 0, 4);
        matrix.set(3, 1, 5);
        matrix.set(3, 2, 6);
        matrix.set(3, 3, 7);

        matrix2.set(0, 0, 0);
        matrix2.set(0, 1, 1);
        matrix2.set(0, 2, 2);
        matrix2.set(0, 3, 3);
        matrix2.set(1, 0, 1);
        matrix2.set(1, 1, 2);
        matrix2.set(1, 2, 3);
        matrix2.set(1, 3, 8);
        matrix2.set(2, 0, 2);
        matrix2.set(2, 1, 3);
        matrix2.set(2, 2, 8);
        matrix2.set(2, 3, 16);
        matrix2.set(3, 0, 4);
        matrix2.set(3, 1, 8);
        matrix2.set(3, 2, 16);
        matrix2.set(3, 3, 32);

        Matrix result = matrix.multiply(matrix2);

        System.out.println(result);

        assertEquals(31, result.get(1, 0));

        Matrix error = new Matrix(3);
        assertThrows(IllegalArgumentException.class, () -> matrix.multiply(error));

    }

    @Test
    void testMultiplyTuple() {
        Matrix matrix = new Matrix(4);

        matrix.set(0, 0, 1);
        matrix.set(0, 1, 2);
        matrix.set(0, 2, 3);
        matrix.set(0, 3, 4);
        matrix.set(1, 0, 2);
        matrix.set(1, 1, 4);
        matrix.set(1, 2, 4);
        matrix.set(1, 3, 2);
        matrix.set(2, 0, 8);
        matrix.set(2, 1, 6);
        matrix.set(2, 2, 4);
        matrix.set(2, 3, 1);
        matrix.set(3, 0, 0);
        matrix.set(3, 1, 0);
        matrix.set(3, 2, 0);
        matrix.set(3, 3, 1);

        Tuple tuple = new Tuple(1, 2, 3, 1);

        Tuple result = matrix.multiply(tuple);

        System.out.println(matrix);
        System.out.println(tuple);
        System.out.println(result);

        assertEquals(24, result.getY(), 0.0001);

        Matrix error = new Matrix(3);
        assertThrows(IllegalArgumentException.class, () -> error.multiply(tuple));

    }

    @Test
    void identity() {
        Matrix id = Matrix.getIdentityMatrix(2);
        assertEquals(1, id.get(0, 0));
        assertEquals(0, id.get(0, 1));
        assertEquals(0, id.get(1, 0));
        assertEquals(1, id.get(1, 1));
    }

    @Test
    void transpose() {
        Matrix matrix = new Matrix(4);
        matrix.set(0, 0, 0);
        matrix.set(0, 1, 8);
        matrix.set(0, 2, 3);
        matrix.set(0, 3, 0);
        matrix.set(1, 0, 9);
        matrix.set(1, 1, 8);
        matrix.set(1, 2, 0);
        matrix.set(1, 3, 8);
        matrix.set(2, 0, 1);
        matrix.set(2, 1, 8);
        matrix.set(2, 2, 5);
        matrix.set(2, 3, 3);
        matrix.set(3, 0, 0);
        matrix.set(3, 1, 0);
        matrix.set(3, 2, 5);
        matrix.set(3, 3, 8);

        System.out.println(matrix);
        System.out.println(matrix.transpose());

        assertEquals(8, matrix.get(1, 0));
        assertEquals(9, matrix.get(0, 1));
        Matrix id1 = Matrix.getIdentityMatrix(2);
        Matrix id2 = Matrix.getIdentityMatrix(2);
        assertEquals(id1, id2.transpose());
    }

    @Test
    void testEquals() {
        Matrix id1 = Matrix.getIdentityMatrix(2);
        Matrix id2 = Matrix.getIdentityMatrix(2);
        Matrix id3 = Matrix.getIdentityMatrix(2);
        Matrix id4 = Matrix.getIdentityMatrix(4);
        id3.set(1, 1, 2);

        assertEquals(id1, id2);
        assertNotEquals(id1, id3);
        assertNotEquals(id1, id4);
        assertEquals(id1, id1);
        assertNotEquals(id1, null);
        assertNotEquals(id1, new ArrayIndexOutOfBoundsException());
    }

    @Test
    void testHashCode() {
        Matrix id1 = Matrix.getIdentityMatrix(2);
        assertNotEquals(0, id1.hashCode());
    }

    @Test
    void testToString() {
        Matrix id1 = Matrix.getIdentityMatrix(2);
        assertTrue(id1.toString().startsWith("Matrix{dimension=2"));
    }

    @Test
    void determinant() {
        Matrix matrix = new Matrix(2);
        matrix.set(0, 0, 1);
        matrix.set(0, 1, -3);
        matrix.set(1, 0, 5);
        matrix.set(1, 1, 2);
        assertEquals(17, matrix.determinant());
    }

    @Test
    void subMatrix() {
        Matrix matrix = new Matrix(3);
        matrix.set(0, 0, 1);
        matrix.set(0, 1, 5);
        matrix.set(0, 2, 0);
        matrix.set(1, 0, -3);
        matrix.set(1, 1, 2);
        matrix.set(1, 2, 7);
        matrix.set(2, 0, 0);
        matrix.set(2, 1, 6);
        matrix.set(2, 2, -3);

        Matrix expected = new Matrix(2);
        expected.set(0, 0, -3);
        expected.set(0, 1, 2);
        expected.set(1, 0, 0);
        expected.set(1, 1, 6);

        Matrix result = matrix.subMatrix(0, 2);

        System.out.println(matrix);
        System.out.println(result);


        assertEquals(expected, result);
    }

    @Test
    void subMatrix2() {
        Matrix matrix = new Matrix(4);
        matrix.set(0, 0, -6);
        matrix.set(0, 1, 1);
        matrix.set(0, 2, 1);
        matrix.set(0, 3, 6);
        matrix.set(1, 0, -8);
        matrix.set(1, 1, 5);
        matrix.set(1, 2, 8);
        matrix.set(1, 3, 6);
        matrix.set(2, 0, -1);
        matrix.set(2, 1, 0);
        matrix.set(2, 2, -1);
        matrix.set(2, 3, 1);
        matrix.set(3, 0, -7);
        matrix.set(3, 1, 1);
        matrix.set(3, 2, -1);
        matrix.set(3, 3, 1);

        System.out.println(matrix);

        Matrix expected = new Matrix(3);
        expected.set(0, 0, -6);
        expected.set(0, 1, 1);
        expected.set(0, 2, 6);
        expected.set(1, 0, -8);
        expected.set(1, 1, 8);
        expected.set(1, 2, 6);
        expected.set(2, 0, -7);
        expected.set(2, 1, -1);
        expected.set(2, 2, 1);
        System.out.println(expected);

        Matrix result = matrix.subMatrix(2, 1);
        System.out.println(result);

        assertEquals(expected, result);
    }


    @Test
    void minor() {
        Matrix matrix = new Matrix(3);
        matrix.set(0, 0, 3);
        matrix.set(0, 1, 5);
        matrix.set(0, 2, 0);
        matrix.set(1, 0, 2);
        matrix.set(1, 1, -1);
        matrix.set(1, 2, -7);
        matrix.set(2, 0, 6);
        matrix.set(2, 1, -1);
        matrix.set(2, 2, 5);

        assertEquals(25, matrix.minor(1, 0));
    }

    @Test
    void cofactor() {
        Matrix matrix = new Matrix(3);
        matrix.set(0, 0, 3);
        matrix.set(0, 1, 5);
        matrix.set(0, 2, 0);
        matrix.set(1, 0, 2);
        matrix.set(1, 1, -1);
        matrix.set(1, 2, -7);
        matrix.set(2, 0, 6);
        matrix.set(2, 1, -1);
        matrix.set(2, 2, 5);

        assertEquals(-25, matrix.cofactor(1, 0));
        assertEquals(-12, matrix.cofactor(0, 0));
    }

    @Test
    void deepCopy() {
        Matrix matrix = new Matrix(3);
        matrix.set(0, 0, 3);
        matrix.set(0, 1, 5);
        matrix.set(0, 2, 0);
        matrix.set(1, 0, 2);
        matrix.set(1, 1, -1);
        matrix.set(1, 2, -7);
        matrix.set(2, 0, 6);
        matrix.set(2, 1, -1);
        matrix.set(2, 2, 5);

        Matrix matrix1 = new Matrix(matrix);

        assertEquals(matrix, matrix1);
    }
}