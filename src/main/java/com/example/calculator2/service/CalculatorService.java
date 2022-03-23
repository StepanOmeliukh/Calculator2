package com.example.calculator2.service;

import com.example.calculator2.dto.CalculatorDto;

/**
 *
 */
public interface CalculatorService {

    boolean checkValuesAndOperation(CalculatorDto calculatorDto);

    void sum(CalculatorDto calculatorDto);

    void sub(CalculatorDto calculatorDto);

    void div(CalculatorDto calculatorDto);

    void mul(CalculatorDto calculatorDto);
}
