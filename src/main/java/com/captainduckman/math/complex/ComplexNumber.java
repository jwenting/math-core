package com.captainduckman.math.complex;

/**
 * Represents a complex number.
 */
public class ComplexNumber {
    private double real;
    private double imaginary;

    /**
     * Create a new complex number.
     *
     * @param real      the real part
     * @param imaginary the imaginary part
     */
    public ComplexNumber(final double real, final double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    /**
     * Add a complex number.
     *
     * @param number the other number
     * @return the result
     */
    public ComplexNumber plus(final ComplexNumber number) {
        real += number.real;
        imaginary += number.imaginary;
        return this;
    }

}
