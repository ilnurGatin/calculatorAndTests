package com.skypro.calculator.controller;

import com.skypro.calculator.service.CalculatorService;
import com.skypro.exception.DivideByZeroException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("")
    public String greeting() {
        return "Добро пожаловать в калькулятор!";
    }

    @GetMapping("/plus")
    public String plus(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
        int answer = calculatorService.plus(num1, num2);
        return String.format("%d + %d = %d", num1, num2, answer);
    }

    @GetMapping("/minus")
    public String minus(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
        int answer = calculatorService.minus(num1, num2);
        return String.format("%d - %d = %d", num1, num2, answer);
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
        int answer = calculatorService.multiply(num1, num2);
        return String.format("%d * %d = %d", num1, num2, answer);
    }

    @GetMapping("/divide")
    public String divide(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
        int answer = calculatorService.divide(num1, num2);
        return String.format("%d / %d = %d", num1, num2, answer);
    }

    @ExceptionHandler(value = DivideByZeroException.class)
    public ResponseEntity<String> divideByZeroHandler(DivideByZeroException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
