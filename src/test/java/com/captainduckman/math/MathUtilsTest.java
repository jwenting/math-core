package com.captainduckman.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilsTest {

    @Test
    void compare() {
        assertTrue(MathUtils.compare(Double.MIN_VALUE, Double.MIN_VALUE));
        assertTrue(MathUtils.compare(Double.MAX_VALUE, Double.MAX_VALUE));
        assertTrue(MathUtils.compare(0, 0));
        assertFalse(MathUtils.compare(0.1, 0.1 + MathUtils.PRECISION));
        assertFalse(MathUtils.compare(Double.NaN, Double.NaN));
        assertFalse(MathUtils.compare(Double.MIN_VALUE, Double.MAX_VALUE));
        assertFalse(MathUtils.compare(Double.MAX_VALUE, Double.MIN_VALUE));
        assertFalse(MathUtils.compare(1, 0));
        assertFalse(MathUtils.compare(0.1, 0.101 + MathUtils.PRECISION));
    }

    @Test
    void compareTo() {
        assertEquals(0, MathUtils.compareTo(0.0, 0.0));
        assertEquals(0, MathUtils.compareTo(Double.MIN_VALUE, Double.MIN_VALUE));
        assertEquals(0, MathUtils.compareTo(Double.MAX_VALUE, Double.MAX_VALUE));
        assertEquals(1, MathUtils.compareTo(1.0, 0.0));
        assertEquals(-1, MathUtils.compareTo(0.0, 1.0));
    }

}