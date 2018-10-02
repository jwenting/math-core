package com.captainduckman.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShearingMatrixTest extends AbstractMathTest {

    @Test
    void execute() {
        ShearingMatrix matrix = new ShearingMatrix(1, 0, 0, 0, 0, 0);
        Point point = new Point(2, 3, 4);
        Point result = point.shear(matrix);
        Point expected = new Point(5, 3, 4);
        assertEquals(expected, result);
    }

    @Test
    void execute2() {
        ShearingMatrix matrix = new ShearingMatrix(0, 1, 0, 0, 0, 0);
        Point point = new Point(2, 3, 4);
        Point result = point.shear(matrix);
        Point expected = new Point(6, 3, 4);
        assertEquals(expected, result);
    }

    @Test
    void execute3() {
        ShearingMatrix matrix = new ShearingMatrix(0, 0, 1, 0, 0, 0);
        Point point = new Point(2, 3, 4);
        Point result = point.shear(matrix);
        Point expected = new Point(2, 5, 4);
        assertEquals(expected, result);
    }

    @Test
    void execute4() {
        ShearingMatrix matrix = new ShearingMatrix(0, 0, 0, 1, 0, 0);
        Point point = new Point(2, 3, 4);
        Point result = point.shear(matrix);
        Point expected = new Point(2, 7, 4);
        assertEquals(expected, result);
    }

    @Test
    void execute5() {
        ShearingMatrix matrix = new ShearingMatrix(0, 0, 0, 0, 1, 0);
        Point point = new Point(2, 3, 4);
        Point result = point.shear(matrix);
        Point expected = new Point(2, 3, 6);
        assertEquals(expected, result);
    }

    @Test
    void execute6() {
        ShearingMatrix matrix = new ShearingMatrix(0, 0, 0, 0, 0, 1);
        Point point = new Point(2, 3, 4);
        Point result = point.shear(matrix);
        Point expected = new Point(2, 3, 7);
        assertEquals(expected, result);
    }

    @Test
    void inverse() {
    }
}