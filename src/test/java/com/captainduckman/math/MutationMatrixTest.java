package com.captainduckman.math;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class MutationMatrixTest {
    @Test
    @DisplayName("Construction")
    void construct() {
        MockMutationMatrix matrix = new MockMutationMatrix();
        MutationMatrix mutationMatrix = new MutationMatrix(matrix);
        assertEquals(matrix.matrix, mutationMatrix.matrix);
    }

    @Test
    @DisplayName("matrix multiplication")
    void multiply() {
        MockMutationMatrix matrix = new MockMutationMatrix();
        MockMutationMatrix matrix2 = new MockMutationMatrix();
        matrix.getMatrix().set(1, 0, 2);
        matrix.getMatrix().set(1, 1, 5.3);
        matrix.getMatrix().set(1, 2, 5);
        matrix.getMatrix().set(1, 3, 1.4);
        matrix2.getMatrix().set(1, 0, 4);
        matrix2.getMatrix().set(1, 1, 1.4);
        matrix2.getMatrix().set(1, 2, 4.1);
        matrix2.getMatrix().set(1, 3, -4);
        MutationMatrix mutationMatrix = new MutationMatrix(matrix).cross(matrix2);
        Matrix expected = new Matrix(4);
        expected.set(0, 0, 1);
        expected.set(0, 1, 0);
        expected.set(0, 2, 0);
        expected.set(0, 3, 0);
        expected.set(1, 0, 23.2);
        expected.set(1, 1, 7.42);
        expected.set(1, 2, 26.73);
        expected.set(1, 3, -19.8);
        expected.set(2, 0, 0);
        expected.set(2, 1, 0);
        expected.set(2, 2, 1);
        expected.set(2, 3, 0);
        expected.set(3, 0, 0);
        expected.set(3, 1, 0);
        expected.set(3, 2, 0);
        expected.set(3, 3, 1);
        assertEquals(expected, mutationMatrix.matrix);

    }

    @Test
    void testMultiplyPoint() {
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

        MockMutationMatrix mutationMatrix = new MockMutationMatrix(matrix);

        Point point = new Point(1, 2, 3);

        Point result = mutationMatrix.multiply(point);

        assertEquals(24, result.getY(), 0.0001);

    }

    @Test
    void testMultiplyVector() {
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

        MockMutationMatrix mutationMatrix = new MockMutationMatrix(matrix);

        Vector point = new Vector(1, 2, 3);

        Vector result = mutationMatrix.multiply(point);

        assertEquals(22, result.getY(), 0.0001);

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

        MutationMatrix mutationMatrix = new MockMutationMatrix(matrix);
        System.out.println(mutationMatrix);
        System.out.println(mutationMatrix.transpose());

        assertEquals(8, mutationMatrix.getMatrix().get(1, 0));
        assertEquals(9, mutationMatrix.getMatrix().get(0, 1));
    }


    @Test
    void testEquals() {
        MutationMatrix id1 = new MockMutationMatrix();
        MutationMatrix id2 = new MockMutationMatrix();
        MutationMatrix id3 = new MockMutationMatrix();
        id3.getMatrix().set(1, 1, 2);

        assertEquals(id1, id2);
        assertNotEquals(id1, id3);
        assertEquals(id1, id1);
        assertNotEquals(id1, null);
        assertNotEquals(id1, new ArrayIndexOutOfBoundsException());
    }

    @Test
    void testHashCode() {
        MutationMatrix id1 = new MockMutationMatrix();
        assertNotEquals(0, id1.hashCode());
    }
}

