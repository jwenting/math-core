package com.captainduckman.math.cucumber;

import com.captainduckman.math.complex.ComplexNumber;
import cucumber.api.java8.En;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComplexNumberSteps implements En {
    private ComplexNumber number;
    private ComplexNumber result;

    public ComplexNumberSteps() {
        Given("A complex number {double}, {double}", (Double real, Double imaginary) -> {
            number = new ComplexNumber(real, imaginary);
        });
        When("adding a complex number {double}, {double}", (Double real, Double imaginary) -> {
            ComplexNumber other = new ComplexNumber(real, imaginary);
            result = number.plus(other);
        });
        Then("the result should be {double}, {double}", (Double real, Double imaginary) -> {
            ComplexNumber expected = new ComplexNumber(real, imaginary);
            assertEquals(expected, number);
        });
        When("subtracting a complex number {double}, {double}", (Double real, Double imaginary) -> {
            ComplexNumber other = new ComplexNumber(real, imaginary);
            result = number.minus(other);
        });
        When("multiplying with a complex number {double}, {double}", (Double real, Double imaginary) -> {
            ComplexNumber other = new ComplexNumber(real, imaginary);
            result = number.multiply(other);
        });
        When("we take the conjugate", () -> {
            result = number.conjugate();
        });
        When("dividing by a complex number {double}, {double}", (Double real, Double imaginary) -> {
            ComplexNumber other = new ComplexNumber(real, imaginary);
            result = number.divide(other);
        });
    }
}
