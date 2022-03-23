package com.example.calculator2.controller;

import com.example.calculator2.dto.CalculatorDto;
import com.example.calculator2.entity.Calculator;
import com.example.calculator2.service.CalculatorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */

@RestController
@RequestMapping("/api/v1/")
@Api(value = "Calculator resources")
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @PostMapping(value = "sum")
    @ApiOperation(value = "Calculate result using two value and operation and return Calculator entity", response = Calculator.class)
    public ResponseEntity<CalculatorDto> sum(@RequestBody CalculatorDto calculatorDto) {
        if (calculatorService.checkValuesAndOperation(calculatorDto)) {
            calculatorService.sum(calculatorDto);
            return new ResponseEntity<CalculatorDto>(calculatorDto, HttpStatus.OK);
        }

        return new ResponseEntity<CalculatorDto>(HttpStatus.BAD_REQUEST);
    }

//    @PostMapping(value = "sub")
//    @ApiOperation(value = "Calculate result using two value and operation and return Calculator entity", response = Calculator.class)
//    public Calculator sub(@RequestBody Calculator calculator) {
//        calculatorService.calculate(calculator);
//        return calculator;
//    }
}
