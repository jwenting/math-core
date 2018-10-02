package com.captainduckman.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TranslationMatrixTest extends AbstractMathTest {

    @Test
    void construct() {
        TranslationMatrix translationMatrix = new TranslationMatrix(2, 3, 4);
        TranslationMatrix second = new TranslationMatrix(translationMatrix);
        assertEquals(translationMatrix, second);
    }

    @Test
    void translate() {
        TranslationMatrix translationMatrix = new TranslationMatrix(1, 2, 3);
        Point point = new Point(2, 3, 4);
        Point result = point.translate(translationMatrix);
        Point expected = new Point(3, 5, 7);
        assertEquals(expected, result);
    }

    @Test
    void translate2() {
        TranslationMatrix translationMatrix = new TranslationMatrix(5, -3, 2);
        translationMatrix = (TranslationMatrix) translationMatrix.inverse();
        Point point = new Point(-3, 4, 5);
        Point result = point.translate(translationMatrix);
        Point expected = new Point(-8, 7, 3);
        assertEquals(expected, result);
    }

    @Test
    void testToString() {
        TranslationMatrix translationMatrix = new TranslationMatrix(5, -3, 2);
        String string = translationMatrix.toString();
        assertTrue(string.startsWith("TranslationMatrix{matrix="));
    }
}