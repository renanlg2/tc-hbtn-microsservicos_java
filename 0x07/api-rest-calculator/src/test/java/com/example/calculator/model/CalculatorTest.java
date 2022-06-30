package com.example.calculator.model;

import com.example.calculator.model.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class CalculatorTest {
    private Calculator calc = new Calculator();

    @Test
    void sumTest() {
        Assertions.assertEquals(5, calc.sum(2D, 3D));
    }

    @Test
    public void numbersNullSumTest() {
        Assertions.assertThrows(NullPointerException.class, () -> calc.sum(null, null));
    }

    @Test
    void subTest() {
        Assertions.assertEquals(6, calc.sub(10D,4D));
    }

    @Test
    void divideTest() {
        Assertions.assertEquals(5, calc.divide(10D, 2D));
    }

    @Test
    public void divisionByZeroTest() {
        Assertions.assertThrows(ArithmeticException.class, () -> calc.divide(10D,0D));
    }

    @Test
    void factorialTest() {
        Assertions.assertEquals(6, calc.factorial(3));
    }

    @Test
    void integerToBinaryTest() {
        Assertions.assertEquals(10100, calc.integerToBinary(20));
    }

    @Test
    void integerToHexadecimalTest() {
        Assertions.assertEquals("AA", calc.integerToHexadecimal(170));
    }

    @Test
    void calculeDayBetweenDateTest() {
        LocalDate d1 = LocalDate.of(2020, 3, 15);
        LocalDate d2 = LocalDate.of(2020, 3, 19);

        Assertions.assertEquals(4, calc.calculeDayBetweenDate(d1, d2));
    }
}
