package com.captainduckman.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RotationMatrixXTest extends AbstractMathTest {

    @Test
    void execute() {
        RotationMatrixX matrix = new RotationMatrixX(Math.PI / 4);
        Point point = new Point(0, 1, 0);
        Point result = point.rotateX(matrix);
        Point expected = new Point(0, Math.sqrt(2) / 2, Math.sqrt(2) / 2);
        assertEquals(expected, result);
        matrix = new RotationMatrixX(Math.PI / 2);
        point = new Point(0, 1, 0);
        result = point.rotateX(matrix);
        expected = new Point(0, 0, 1);
        assertEquals(expected, result);
    }

    @Test
    void executeInverse() {
        RotationMatrixX matrix = new RotationMatrixX(Math.PI / 4);
        matrix = (RotationMatrixX) matrix.inverse();
        Point point = new Point(0, 1, 0);
        Point result = point.rotateX(matrix);
        Point expected = new Point(0, Math.sqrt(2) / 2, -Math.sqrt(2) / 2);
        assertEquals(expected, result);
    }
}