package com.captainduckman.math.complex;

import com.captainduckman.math.MathUtils;

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
     * Copies one ComplexNumber to make another.
     *
     * @param other the original
     */
    public ComplexNumber(ComplexNumber other) {
        this.imaginary = other.imaginary;
        this.real = other.real;
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

    /**
     * Substract a complex number.
     *
     * @param number the number to subtract
     * @return the result
     */
    public ComplexNumber minus(final ComplexNumber number) {
        real -= number.real;
        imaginary -= number.imaginary;
        return this;
    }

    public double getReal() {
        return real;
    }

    public void setReal(final double real) {
        this.real = real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public void setImaginary(final double imaginary) {
        this.imaginary = imaginary;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ComplexNumber that = (ComplexNumber) o;

        return MathUtils.compare(real, that.real) && MathUtils.compare(imaginary, that.imaginary);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(real);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(imaginary);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "ComplexNumber{" +
                "real=" + real +
                ", imaginary=" + imaginary +
                '}';
    }

    /**
     * Multiplication.
     *
     * @param other the complex number to be multiplied with
     * @return this after multiplication with the other
     */
    public ComplexNumber multiply(final ComplexNumber other) {
        double temp = (this.real * other.real) - (this.imaginary * other.imaginary);
        this.imaginary = this.real * other.imaginary + this.imaginary * other.real;
        this.real = temp;
        return this;
    }

    /**
     * Take the conjugate of the complex number.
     *
     * @return this after multiplying the imaginary part by -1
     */
    public ComplexNumber conjugate() {
        imaginary = -imaginary;
        return this;
    }

    /**
     * Divide by another ComplexNumber.
     *
     * @param other the other number
     * @return this, after division
     */
    public ComplexNumber divide(final ComplexNumber other) {
        ComplexNumber otherConjugate = new ComplexNumber(other).conjugate();
        ComplexNumber top = new ComplexNumber(this).multiply(otherConjugate);
        ComplexNumber bottom = new ComplexNumber(other).multiply(otherConjugate);
        real = top.real / bottom.real;
        imaginary = top.imaginary / bottom.real;
        return this;

    }
}
