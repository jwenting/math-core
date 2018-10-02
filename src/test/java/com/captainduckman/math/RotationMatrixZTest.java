package com.captainduckman.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RotationMatrixZTest extends AbstractMathTest {


    @Test
    void execute() {
        RotationMatrixZ matrix = new RotationMatrixZ(Math.PI / 4);
        Point point = new Point(1, 0, 0);
        Point result = point.rotateZ(matrix);
        Point expected = new Point(Math.sqrt(2) / 2, Math.sqrt(2) / 2, 0);
        assertEquals(expected, result);
        matrix = new RotationMatrixZ(Math.PI / 2);
        point = new Point(1, 0, 0);
        result = point.rotateZ(matrix);
        expected = new Point(0, 1, 0);
        assertEquals(expected, result);
    }

    @Test
    void executeInverse() {
        RotationMatrixZ matrix = new RotationMatrixZ(Math.PI / 4);
        matrix = (RotationMatrixZ) matrix.inverse();
        Point point = new Point(1, 0, 0);
        Point result = point.rotateZ(matrix);
        Point expected = new Point(Math.sqrt(2) / 2, -Math.sqrt(2) / 2, 0);
        assertEquals(expected, result);

    }
}