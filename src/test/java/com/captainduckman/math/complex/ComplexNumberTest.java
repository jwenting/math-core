package com.captainduckman.math.complex;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ComplexNumberTest {

    @Test
    void plus() {
        ComplexNumber c1 = new ComplexNumber(1, 2.5);
        ComplexNumber c2 = new ComplexNumber(0.5, -0.5);
        c1 = c1.plus(c2);
        assertEquals(1.5, c1.getReal());
        assertEquals(2.0, c1.getImaginary());
    }

    @Test
    void minus() {
        ComplexNumber c1 = new ComplexNumber(1, 2.5);
        ComplexNumber c2 = new ComplexNumber(0.5, -0.5);
        c1 = c1.minus(c2);
        assertEquals(0.5, c1.getReal());
        assertEquals(3.0, c1.getImaginary());
    }

    @Test
    void someTest() {
        ComplexNumber c1 = new ComplexNumber(0, 0);
        ComplexNumber c2 = new ComplexNumber(0.5, -0.5);

        ComplexNumber result = c1.multiply(c1).plus(c2);
        assertEquals(new ComplexNumber(0.5, -0.5), result);
    }
}