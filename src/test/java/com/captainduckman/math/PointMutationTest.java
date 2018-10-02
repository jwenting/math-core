package com.captainduckman.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PointMutationTest extends AbstractMathTest {

    @Test
    void translate() {
        TranslationMatrix translationMatrix = new TranslationMatrix(1, 2, 3);
        Point point = new Point(2, 3, 4);
        Point result = point.translate(translationMatrix);
        Point expected = new Point(3, 5, 7);
        assertEquals(expected, result);
    }

    @Test
    void rotateX() {
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
    void rotateY() {
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
    void rotateZ() {
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
    void scale() {
        ScalingMatrix scalingMatrix = new ScalingMatrix(2, 3, 4);
        Point point = new Point(-4, 6, 8);
        Point expected = new Point(-8, 18, 32);
        Point result = point.scale(scalingMatrix);
        assertEquals(expected, result);
    }

    @Test
    void shear() {
        ShearingMatrix matrix = new ShearingMatrix(0, 0, 1, 0, 0, 0);
        Point point = new Point(2, 3, 4);
        Point result = point.shear(matrix);
        Point expected = new Point(2, 5, 4);
        assertEquals(expected, result);
    }

    @Test
    void chainingTest() {
        Point point = new Point(1, 0, 1);
        RotationMatrixX rotationMatrix = new RotationMatrixX(Math.PI / 2);
        ScalingMatrix scalingMatrix = new ScalingMatrix(5, 5, 5);
        TranslationMatrix translationMatrix = new TranslationMatrix(10, 5, 7);

        Point translate = point.rotateX(rotationMatrix).scale(scalingMatrix).translate(translationMatrix);
        System.out.println(translate);
        Point expected = new Point(15, 0, 7);
        assertEquals(expected, translate);
    }
}