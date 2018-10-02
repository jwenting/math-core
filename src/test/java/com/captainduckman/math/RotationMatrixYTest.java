package com.captainduckman.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RotationMatrixYTest extends AbstractMathTest {

    @Test
    void execute() {
        RotationMatrixY matrix = new RotationMatrixY(Math.PI / 4);
        Point point = new Point(0, 0, 1);
        Point result = point.rotateY(matrix);
        Point expected = new Point(Math.sqrt(2) / 2, 0, Math.sqrt(2) / 2);
        assertEquals(expected, result);
        matrix = new RotationMatrixY(Math.PI / 2);
        point = new Point(0, 0, 1);
        result = point.rotateY(matrix);
        expected = new Point(1, 0, 0);
        assertEquals(expected, result);
    }

    @Test
    void executeInverse() {
        RotationMatrixY matrix = new RotationMatrixY(Math.PI / 4);
        matrix = (RotationMatrixY) matrix.inverse();
        Point point = new Point(0, 0, 1);
        Point result = point.rotateY(matrix);
        Point expected = new Point(-Math.sqrt(2) / 2, 0, Math.sqrt(2) / 2);
        assertEquals(expected, result);

    }
}