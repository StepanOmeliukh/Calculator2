package com.example.calculator2.service;

import com.example.calculator2.dto.CalculatorDto;

import java.util.List;
import java.util.Optional;

public interface CalculatorService {

    boolean checkValues(CalculatorDto calculatorDto);

    CalculatorDto sum(CalculatorDto calculatorDto);

    CalculatorDto sub(CalculatorDto calculatorDto);

    CalculatorDto div(CalculatorDto calculatorDto);

    CalculatorDto mul(CalculatorDto calculatorDto);

    List<CalculatorDto> getAllCalculates();

    Optional<CalculatorDto> getCalculatesById(Long id);

}
