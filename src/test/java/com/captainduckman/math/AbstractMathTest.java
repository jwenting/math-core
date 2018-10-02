package com.captainduckman.math;

import static java.lang.StrictMath.abs;

public abstract class AbstractMathTest {
    protected static final double DEFAULT_PRECISION = 0.0001;

    protected boolean compare(double expected, double actual) {
        return compare(expected, actual, DEFAULT_PRECISION);
    }

    protected boolean compare(double expected, double actual, double precision) {
        double diff = abs(expected - actual);
        return diff < precision;
    }
}
