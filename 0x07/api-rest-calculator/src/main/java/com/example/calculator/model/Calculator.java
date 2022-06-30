package com.example.calculator.model;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;

public class Calculator {

    public Double sum(Double number1, Double number2) {

        if (!numbersAreValid(number1, number2))
            throw new NullPointerException("Número 1 e número 2 são obrigatórios.");

        return number1 + number2;
    }

    public Double sub(Double number1, Double number2) {
        if (!numbersAreValid(number1, number2))
            throw new NullPointerException("Número 1 e número 2 são obrigatórios.");

        return number1 - number2;
    }

    public Double divide (Double number1, Double number2)  {

        if (!numbersAreValid(number1, number2))
            throw new NullPointerException("Número 1 e número 2 são obrigatórios.");

        if (number2 == 0)
            throw new ArithmeticException("Divisão por zero não é permitido.");

        return number1 / number2;
    }

    public Integer factorial(Integer factorial) {

        if (factorial == null)
            throw new NullPointerException("Número é obrigatório.");

        Integer result = 1;

        for (int i = factorial; i > 1; i--){
            result = result * i;
        }

        return result;
    }

    public Integer integerToBinary(Integer integer) {
        return Integer.parseInt(Integer.toBinaryString(integer));
    }

    public String integerToHexadecimal(Integer integer) {
        return Integer.toHexString(integer).toUpperCase();
    }

    public int calculeDayBetweenDate(LocalDate date1, LocalDate date2) {
        return Period.between(date1, date2).getDays();
    }

    public boolean numbersAreValid(Double number1, Double number2){
        if (number1 == null || number2 == null)
            return false;

        return true;
    }

    public boolean numberIsValid(Integer number){
        if (number == null)
            return false;

        return true;
    }

}