package com.example.calculator2.controller;

import com.example.calculator2.dto.CalculatorDto;
import com.example.calculator2.entity.Calculator;
import com.example.calculator2.service.CalculatorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Rest Controller
 */

@RestController
@RequestMapping("/api/v1/")
@Api(value = "Calculator resources")
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @PostMapping("sum")
    @ApiOperation(value = "Calculate result using two value and operation and return Calculator entity", response = Calculator.class)
    public ResponseEntity<CalculatorDto> sum(@RequestBody CalculatorDto calculatorDto) {
        if (calculatorService.checkValues(calculatorDto)) {
            calculatorService.sum(calculatorDto);
            return new ResponseEntity<CalculatorDto>(calculatorDto, HttpStatus.OK);
        }

        return new ResponseEntity<CalculatorDto>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("sub")
    @ApiOperation(value = "Calculate result using two value and operation and return Calculator entity", response = Calculator.class)
    public ResponseEntity<CalculatorDto> sub(@RequestBody CalculatorDto calculatorDto) {
        if (calculatorService.checkValues(calculatorDto)) {
            calculatorService.sub(calculatorDto);
            return new ResponseEntity<CalculatorDto>(calculatorDto, HttpStatus.OK);
        }
        return new ResponseEntity<CalculatorDto>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("div")
    @ApiOperation(value = "Calculate result using two value and operation and return Calculator entity", response = Calculator.class)
    public ResponseEntity<CalculatorDto> div(@RequestBody CalculatorDto calculatorDto) {
        if (calculatorService.checkValues(calculatorDto)) {
            try {
                calculatorService.div(calculatorDto);
                return new ResponseEntity<CalculatorDto>(calculatorDto, HttpStatus.OK);
            } catch (IllegalArgumentException e) {
                return new ResponseEntity<CalculatorDto>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<CalculatorDto>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("mul")
    @ApiOperation(value = "Calculate result using two value and operation and return Calculator entity", response = Calculator.class)
    public ResponseEntity<CalculatorDto> mul(@RequestBody CalculatorDto calculatorDto) {
        if (calculatorService.checkValues(calculatorDto)) {
            calculatorService.mul(calculatorDto);
            return new ResponseEntity<CalculatorDto>(calculatorDto, HttpStatus.OK);
        }

        return new ResponseEntity<CalculatorDto>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("calculations")
    public ResponseEntity<List<CalculatorDto>> getAllCalculates() {
        List<CalculatorDto> calculatorDtos = calculatorService.getAllCalculates();
        if (calculatorDtos.isEmpty())
            return new ResponseEntity<List<CalculatorDto>>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<List<CalculatorDto>>(calculatorDtos, HttpStatus.OK);
    }

    @GetMapping("calculation")
    public ResponseEntity<Optional<CalculatorDto>> getCalculatorById(@RequestParam Long id) {
        if (id.equals(null))
            return new ResponseEntity<Optional<CalculatorDto>>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<Optional<CalculatorDto>>(calculatorService.getCalculatesById(id), HttpStatus.OK);
    }
}
