package com.example.calculator.controller;

import com.example.calculator.model.Calculator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@Api(value = "API REST Calculator")
@RestController
@RequestMapping(value = "/calculator")
public class CalculatorController {

    @ApiOperation(value = "Welcome Message")
    @GetMapping("/welcome")
    public String messageWelcome(){
        return "Bem vindo à CALCULATOR API REST.";
    }

    @ApiOperation(value = "Sum Two Numbers")
    @GetMapping("/addNumbers")
    public String addNumbers(@RequestParam(name = "number1") Double n1, @RequestParam(name = "number2") Double n2){
        return Double.toString(new Calculator().sum(n1,n2));
    }

    @ApiOperation(value = "Subtract Two Numbers")
    @GetMapping("/subNumbers")
    public String subNumbers(@RequestParam(name = "number1") Double n1, @RequestParam(name = "number2") Double n2){
        return Double.toString(new Calculator().sub(n1,n2));
    }

    @ApiOperation(value = "Divide Two Numbers")
    @GetMapping("/divideNumbers")
    public String divideNumbers(@RequestParam(name = "number1") Double n1, @RequestParam(name = "number2") Double n2){
        return Double.toString(new Calculator().divide(n1,n2));
    }

    @ApiOperation(value = "Calculate a factorial of a number")
    @GetMapping("/factorial")
    public String factorial(@RequestParam(name = "factorial") Integer factorial){
        return Integer.toString(new Calculator().factorial(factorial));
    }

    @ApiOperation(value = "Calculate the quantity of days between two dates")
    @GetMapping("/calculeDayBetweenDate")
    public String calculeDayBetweenDate(
            @RequestParam("date1") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate d1,
            @RequestParam("date2") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate d2){
        return Integer.toString(new Calculator().calculeDayBetweenDate(d1, d2));
    }

    @ApiOperation(value = "Convert an Integer to its Binary value")
    @GetMapping("/integerToBinary")
    public String integerToBinary(@RequestParam(name = "number1") Integer n1){
        return Integer.toString(new Calculator().integerToBinary(n1));
    }

    @ApiOperation(value = "Convert an Integer to its Hexadecimal value")
    @GetMapping("/integerToHexadecimal")
    public String integerToHexadecimal(@RequestParam(name = "number1") Integer n1){
        return new Calculator().integerToHexadecimal(n1);
    }
}
