Feature: complex number tests

  Scenario: complex numbers can support subtraction and addition
    Given A complex number 1.0, -2.0
    When adding a complex number 0.3, 1.5
    Then the result should be 1.3, -0.5

    Given A complex number 1.0, -2.0
    When subtracting a complex number 0.3, 1.5
    Then the result should be 0.7, -3.5

  Scenario: complex numbers should support multiplication and division
    Given A complex number 3.0, 2.0
    When multiplying with a complex number 1.0, 7.0
    Then the result should be -11.0, 23.0

    Given A complex number 3.0, 2.0
    When we take the conjugate
    Then the result should be 3.0, -2.0

    Given A complex number 2.0, 3.0
    When dividing by a complex number 4.0, -5.0
    Then the result should be -0.17073, 0.53659
