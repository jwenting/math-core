package com.captainduckman.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VectorMutationTest extends AbstractMathTest {

    @Test
    void translate() {
        TranslationMatrix translationMatrix = new TranslationMatrix(1, 2, 3);
        Vector vector = new Vector(2, 3, 4);
        Vector result = vector.translate(translationMatrix);
        Vector expected = new Vector(3, 5, 7);
        assertEquals(expected, result);
    }

    @Test
    void rotateX() {
        RotationMatrixX matrix = new RotationMatrixX(Math.PI / 4);
        Vector vector = new Vector(0, 1, 0);
        Vector result = vector.rotateX(matrix);
        Vector expected = new Vector(0, Math.sqrt(2) / 2, Math.sqrt(2) / 2);
        assertEquals(expected, result);
        matrix = new RotationMatrixX(Math.PI / 2);
        vector = new Vector(0, 1, 0);
        result = vector.rotateX(matrix);
        expected = new Vector(0, 0, 1);
        assertEquals(expected, result);
    }

    @Test
    void rotateY() {
        RotationMatrixY matrix = new RotationMatrixY(Math.PI / 4);
        Vector vector = new Vector(0, 0, 1);
        Vector result = vector.rotateY(matrix);
        Vector expected = new Vector(Math.sqrt(2) / 2, 0, Math.sqrt(2) / 2);
        assertEquals(expected, result);
        matrix = new RotationMatrixY(Math.PI / 2);
        vector = new Vector(0, 0, 1);
        result = vector.rotateY(matrix);
        expected = new Vector(1, 0, 0);
        assertEquals(expected, result);
    }

    @Test
    void rotateZ() {
        RotationMatrixZ matrix = new RotationMatrixZ(Math.PI / 4);
        Vector vector = new Vector(1, 0, 0);
        Vector result = vector.rotateZ(matrix);
        Vector expected = new Vector(Math.sqrt(2) / 2, Math.sqrt(2) / 2, 0);
        assertEquals(expected, result);
        matrix = new RotationMatrixZ(Math.PI / 2);
        vector = new Vector(1, 0, 0);
        result = vector.rotateZ(matrix);
        expected = new Vector(0, 1, 0);
        assertEquals(expected, result);
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
    void shear() {
        ShearingMatrix matrix = new ShearingMatrix(0, 0, 1, 0, 0, 0);
        Vector vector = new Vector(2, 3, 4);
        Vector result = vector.shear(matrix);
        Vector expected = new Vector(2, 5, 4);
        assertEquals(expected, result);
    }

    @Test
    void chainingTest() {
        Vector vector = new Vector(1, 0, 1);
        RotationMatrixX rotationMatrix = new RotationMatrixX(Math.PI / 2);
        ScalingMatrix scalingMatrix = new ScalingMatrix(5, 5, 5);
        TranslationMatrix translationMatrix = new TranslationMatrix(10, 5, 7);

        Vector translate = vector.rotateX(rotationMatrix).scale(scalingMatrix).translate(translationMatrix);
        System.out.println(translate);
        Vector expected = new Vector(15, 0, 7);
        assertEquals(expected, translate);
    }    
}