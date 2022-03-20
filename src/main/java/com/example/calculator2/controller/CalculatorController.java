package com.example.calculator2.controller;

import com.example.calculator2.entity.Calculator;
import com.example.calculator2.service.CalculatorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 *
 */

@RestController
@RequestMapping("/api/v1/")
@Api(value = "Calculator resources")
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @PostMapping(value = "calc")
    @ApiOperation(value = "Calculate result using two value and operation and return Calculator entity", response = Calculator.class)
    public Calculator calculate(@RequestBody Calculator calculator) {
        calculatorService.calculate(calculator);
        return calculator;
    }
}
