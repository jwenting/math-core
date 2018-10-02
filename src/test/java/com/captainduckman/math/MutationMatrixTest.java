package com.captainduckman.math;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

}

