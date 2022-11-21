package com.skypro.calculator.service;

import com.skypro.exception.DivideByZeroException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class CalculatorService {


    public int plus(int num1, int num2) {
        int answer = num1 + num2;
        return answer;
    }

    public int minus(int num1, int num2) {
        int answer = num1 - num2;
        return answer;
    }

    public int multiply(int num1, int num2) {
        int answer = num1 * num2;
        return answer;
    }

    public int divide(int num1, int num2) {
        if (num2 == 0) {
            throw new DivideByZeroException("На ноль делить нельзя!");
        }
        int answer = num1 / num2;
        return answer;
    }
}
