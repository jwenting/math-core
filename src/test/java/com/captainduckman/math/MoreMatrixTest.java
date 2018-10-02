package com.captainduckman.math;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("More Matrix Test")
class MoreMatrixTest extends AbstractMathTest {
    @Test
    void determinant2x2() {
        Matrix matrix = new Matrix(2);
        matrix.set(0, 0, 1);
        matrix.set(0, 1, 2);
        matrix.set(1, 0, -5);
        matrix.set(1, 1, 8);

        double determinant = matrix.determinant();
        System.out.println(determinant);
        assertEquals(18, determinant);

    }

    @Test
    void determinant3x3() {
        Matrix matrix = new Matrix(3);
        matrix.set(0, 0, 1);
        matrix.set(0, 1, 2);
        matrix.set(0, 2, 6);
        matrix.set(1, 0, -5);
        matrix.set(1, 1, 8);
        matrix.set(1, 2, -4);
        matrix.set(2, 0, 2);
        matrix.set(2, 1, 6);
        matrix.set(2, 2, 4);

        double cf1 = matrix.cofactor(0, 0);
        double cf2 = matrix.cofactor(0, 1);
        double cf3 = matrix.cofactor(0, 2);

        assertEquals(56, cf1);
        assertEquals(12, cf2);
        assertEquals(-46, cf3);

        double determinant = matrix.determinant();
        System.out.println(determinant);
        assertEquals(-196, determinant);

    }

    @Test
    void determinant4x4() {
        Matrix matrix = new Matrix(4);
        matrix.set(0, 0, -2);
        matrix.set(0, 1, -8);
        matrix.set(0, 2, 3);
        matrix.set(0, 3, 5);
        matrix.set(1, 0, -3);
        matrix.set(1, 1, 1);
        matrix.set(1, 2, 7);
        matrix.set(1, 3, 3);
        matrix.set(2, 0, 1);
        matrix.set(2, 1, 2);
        matrix.set(2, 2, -9);
        matrix.set(2, 3, 6);
        matrix.set(3, 0, -6);
        matrix.set(3, 1, 7);
        matrix.set(3, 2, 7);
        matrix.set(3, 3, -9);

        double cf1 = matrix.cofactor(0, 0);
        double cf2 = matrix.cofactor(0, 1);
        double cf3 = matrix.cofactor(0, 2);
        double cf4 = matrix.cofactor(0, 3);

        assertEquals(690, cf1);
        assertEquals(447, cf2);
        assertEquals(210, cf3);
        assertEquals(51, cf4);
        double determinant = matrix.determinant();
        System.out.println(determinant);
        assertEquals(-4071, determinant);
    }

    @Test
    void testInvertible1() {
        Matrix matrix = new Matrix(4);
        matrix.set(0, 0, 6);
        matrix.set(0, 1, 4);
        matrix.set(0, 2, 4);
        matrix.set(0, 3, 4);
        matrix.set(1, 0, 5);
        matrix.set(1, 1, 5);
        matrix.set(1, 2, 7);
        matrix.set(1, 3, 6);
        matrix.set(2, 0, 4);
        matrix.set(2, 1, -9);
        matrix.set(2, 2, 3);
        matrix.set(2, 3, -7);
        matrix.set(3, 0, 9);
        matrix.set(3, 1, 1);
        matrix.set(3, 2, 7);
        matrix.set(3, 3, -6);

        double determinant = matrix.determinant();
        System.out.println(determinant);
        assertEquals(-2120, determinant);

        assertTrue(matrix.isInvertible());

    }

    @Test
    void testInvertible2() {
        Matrix matrix = new Matrix(4);
        matrix.set(0, 0, -4);
        matrix.set(0, 1, 2);
        matrix.set(0, 2, -2);
        matrix.set(0, 3, -3);
        matrix.set(1, 0, 9);
        matrix.set(1, 1, 6);
        matrix.set(1, 2, 2);
        matrix.set(1, 3, 6);
        matrix.set(2, 0, 0);
        matrix.set(2, 1, -5);
        matrix.set(2, 2, 1);
        matrix.set(2, 3, -5);
        matrix.set(3, 0, 0);
        matrix.set(3, 1, 0);
        matrix.set(3, 2, 0);
        matrix.set(3, 3, 0);

        double determinant = matrix.determinant();
        System.out.println(determinant);
        assertEquals(0, determinant);

        assertFalse(matrix.isInvertible());
    }

    @Test
    void inverse() {
        Matrix matrix = new Matrix(4);
        matrix.set(0, 0, -5);
        matrix.set(0, 1, 2);
        matrix.set(0, 2, 6);
        matrix.set(0, 3, -8);
        matrix.set(1, 0, 1);
        matrix.set(1, 1, -5);
        matrix.set(1, 2, 1);
        matrix.set(1, 3, 8);
        matrix.set(2, 0, 7);
        matrix.set(2, 1, 7);
        matrix.set(2, 2, -6);
        matrix.set(2, 3, -7);
        matrix.set(3, 0, 1);
        matrix.set(3, 1, -3);
        matrix.set(3, 2, 7);
        matrix.set(3, 3, 4);

        Matrix result = matrix.inverse();

        Matrix expected = new Matrix(4);
        expected.set(0, 0, .21805);
        expected.set(0, 1, .45113);
        expected.set(0, 2, .24060);
        expected.set(0, 3, -.045113);
        expected.set(1, 0, -.80827);
        expected.set(1, 1, -1.45677);
        expected.set(1, 2, -.44361);
        expected.set(1, 3, .52068);
        expected.set(2, 0, -.07895);
        expected.set(2, 1, -.22368);
        expected.set(2, 2, -.05263);
        expected.set(2, 3, .19737);
        expected.set(3, 0, -.52256);
        expected.set(3, 1, -.81391);
        expected.set(3, 2, -.30075);
        expected.set(3, 3, .30639);

        assertEquals(expected, result);
    }

    @Test
    void inverse2() {
        Matrix matrix = new Matrix(4);
        matrix.set(0, 0, 8);
        matrix.set(0, 1, -5);
        matrix.set(0, 2, 9);
        matrix.set(0, 3, 2);
        matrix.set(1, 0, 7);
        matrix.set(1, 1, 5);
        matrix.set(1, 2, 6);
        matrix.set(1, 3, 1);
        matrix.set(2, 0, -6);
        matrix.set(2, 1, 0);
        matrix.set(2, 2, 9);
        matrix.set(2, 3, 6);
        matrix.set(3, 0, -3);
        matrix.set(3, 1, 0);
        matrix.set(3, 2, -9);
        matrix.set(3, 3, -4);

        Matrix result = matrix.inverse();

        Matrix expected = new Matrix(4);
        expected.set(0, 0, -.15385);
        expected.set(0, 1, -.15385);
        expected.set(0, 2, -.28205);
        expected.set(0, 3, -.53846);
        expected.set(1, 0, -.07692);
        expected.set(1, 1, .12308);
        expected.set(1, 2, .02564);
        expected.set(1, 3, .03077);
        expected.set(2, 0, .35897);
        expected.set(2, 1, .35897);
        expected.set(2, 2, .43590);
        expected.set(2, 3, .92308);
        expected.set(3, 0, -.69231);
        expected.set(3, 1, -.69231);
        expected.set(3, 2, -.76923);
        expected.set(3, 3, -1.92308);

        assertEquals(expected, result);
    }

    @Test
    void inverse3() {
        Matrix matrix = new Matrix(4);
        matrix.set(0, 0, 9);
        matrix.set(0, 1, 3);
        matrix.set(0, 2, 0);
        matrix.set(0, 3, 9);
        matrix.set(1, 0, -5);
        matrix.set(1, 1, -2);
        matrix.set(1, 2, -6);
        matrix.set(1, 3, -3);
        matrix.set(2, 0, -4);
        matrix.set(2, 1, 9);
        matrix.set(2, 2, 6);
        matrix.set(2, 3, 4);
        matrix.set(3, 0, -7);
        matrix.set(3, 1, 6);
        matrix.set(3, 2, 6);
        matrix.set(3, 3, 2);

        Matrix result = matrix.inverse();

        Matrix expected = new Matrix(4);
        expected.set(0, 0, -.04074);
        expected.set(0, 1, -.07778);
        expected.set(0, 2, .14444);
        expected.set(0, 3, -.22222);
        expected.set(1, 0, -.07778);
        expected.set(1, 1, .03333);
        expected.set(1, 2, .36667);
        expected.set(1, 3, -.33333);
        expected.set(2, 0, -.02901);
        expected.set(2, 1, -.1463);
        expected.set(2, 2, -.10926);
        expected.set(2, 3, .12963);
        expected.set(3, 0, .17778);
        expected.set(3, 1, .06667);
        expected.set(3, 2, -.26667);
        expected.set(3, 3, .33333);

        assertEquals(expected, result);
    }

    @Test
    void multInverse() {
        Matrix matrix = new Matrix(4);
        matrix.set(0, 0, 9);
        matrix.set(0, 1, 3);
        matrix.set(0, 2, 0);
        matrix.set(0, 3, 9);
        matrix.set(1, 0, -5);
        matrix.set(1, 1, -2);
        matrix.set(1, 2, -6);
        matrix.set(1, 3, -3);
        matrix.set(2, 0, -4);
        matrix.set(2, 1, 9);
        matrix.set(2, 2, 6);
        matrix.set(2, 3, 4);
        matrix.set(3, 0, -7);
        matrix.set(3, 1, 6);
        matrix.set(3, 2, 6);
        matrix.set(3, 3, 2);

        Matrix matrix2 = new Matrix(4);
        matrix2.set(0, 0, 1.9);
        matrix2.set(0, 1, 1);
        matrix2.set(0, 2, .2);
        matrix2.set(0, 3, 9.1);
        matrix2.set(1, 0, -.5);
        matrix2.set(1, 1, -1.2);
        matrix2.set(1, 2, -3.6);
        matrix2.set(1, 3, -1.3);
        matrix2.set(2, 0, -4.1);
        matrix2.set(2, 1, 2.9);
        matrix2.set(2, 2, 6.4);
        matrix2.set(2, 3, 5.4);
        matrix2.set(3, 0, -2.7);
        matrix2.set(3, 1, 1.6);
        matrix2.set(3, 2, 6.43);
        matrix2.set(3, 3, -2.32);

        Matrix c = matrix.multiply(matrix2);

        Matrix result = c.multiply(matrix2.inverse());

        assertEquals(matrix, result);
    }

    @Test
    void testInverse3() {
        Matrix matrix = Matrix.getIdentityMatrix(4);
        matrix.set(1, 1, Math.cos((Math.PI) / 4));
        matrix.set(1, 2, -Math.sin((Math.PI) / 4));
        matrix.set(2, 1, Math.sin((Math.PI) / 4));
        matrix.set(2, 2, Math.cos((Math.PI) / 4));

        System.out.println(matrix);

        Matrix result = matrix.inverse();

        System.out.println(result);
    }

}