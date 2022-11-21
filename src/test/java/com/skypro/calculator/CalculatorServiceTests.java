package com.skypro.calculator;

import com.skypro.calculator.service.CalculatorService;
import com.skypro.exception.DivideByZeroException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorServiceTests {
    private final CalculatorService calculatorService = new CalculatorService();

    @ParameterizedTest
    @MethodSource("plusTestSuit")
    public void plus(int num1, int num2, int result) {
        assertEquals(result, calculatorService.plus(num1, num2));
    }

    @ParameterizedTest
    @MethodSource("minusTestSuit")
    public void minus(int num1, int num2, int result) {
        assertEquals(result, calculatorService.minus(num1, num2));
    }

    @ParameterizedTest
    @MethodSource("multiplyTestSuit")
    public void multiiply(int num1, int num2, int result) {
        assertEquals(result, calculatorService.multiply(num1, num2));
    }

    @ParameterizedTest
    @MethodSource("divideTestSuit")
    public void divide(int num1, int num2, int result) {
        assertEquals(result, calculatorService.divide(num1, num2));
    }

    @Test
    public void divideByZeroThrowsException() {
        assertThrows(DivideByZeroException.class, () -> calculatorService.divide(1, 0));
    }
    public static List<Arguments> plusTestSuit() {
        return List.of(
                Arguments.of(-9,-2,-11),
                Arguments.of(-2,2,0),
                Arguments.of(99,2,101));
    }

    public static List<Arguments> minusTestSuit() {
        return List.of(
                Arguments.of(-9,-2,-7),
                Arguments.of(-2,2,-4),
                Arguments.of(101,2,99));
    }

    public static List<Arguments> multiplyTestSuit() {
        return List.of(
                Arguments.of(-9,-2,18),
                Arguments.of(-2,2,-4),
                Arguments.of(99,2,198));
    }

    public static List<Arguments> divideTestSuit() {
        return List.of(
                Arguments.of(-9,-3,3),
                Arguments.of(-2,2,-1),
                Arguments.of(99,9,11));
    }

}
