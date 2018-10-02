package com.captainduckman.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ScalingMatrixTest extends AbstractMathTest {

    @Test
    void construct() {
        ScalingMatrix scalingMatrix = new ScalingMatrix(2, 3, 4);
        ScalingMatrix second = new ScalingMatrix(scalingMatrix);
        assertEquals(scalingMatrix, second);
    }

    @Test
    void scale() {
        ScalingMatrix scalingMatrix = new ScalingMatrix(2, 3, 4);
        Vector vector = new Vector(-4, 6, 8);
        Vector expected = new Vector(-8, 18, 32);
        Vector result = vector.scale(scalingMatrix);
        assertEquals(expected, result);
    }

    @Test
    void inverse() {
        ScalingMatrix scalingMatrix = new ScalingMatrix(2, 3, 4);
        scalingMatrix = (ScalingMatrix) scalingMatrix.inverse();
        Vector vector = new Vector(-4, 6, 8);
        Vector expected = new Vector(-2, 2, 2);
        Vector result = vector.scale(scalingMatrix);
        assertEquals(expected, result);
    }

    @Test
    void reflectX() {
        ScalingMatrix scalingMatrix = new ScalingMatrix(-1, 1, 1);
        Vector vector = new Vector(-4, 6, 8);
        Vector expected = new Vector(4, 6, 8);
        Vector result = vector.scale(scalingMatrix);
        assertEquals(expected, result);
    }

    @Test
    void reflectY() {
        ScalingMatrix scalingMatrix = new ScalingMatrix(1, -1, 1);
        Vector vector = new Vector(-4, 6, 8);
        Vector expected = new Vector(-4, -6, 8);
        Vector result = vector.scale(scalingMatrix);
        assertEquals(expected, result);

    }

    @Test
    void reflectZ() {
        ScalingMatrix scalingMatrix = new ScalingMatrix(1, 1, -1);
        Vector vector = new Vector(-4, 6, 8);
        Vector expected = new Vector(-4, 6, -8);
        Vector result = vector.scale(scalingMatrix);
        assertEquals(expected, result);

    }
}