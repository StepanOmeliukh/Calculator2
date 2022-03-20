package com.example.calculator2.service.Impl;

import com.example.calculator2.entity.Calculator;
import com.example.calculator2.repository.CalculatorRepository;
import com.example.calculator2.service.CalculatorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Autowired
    CalculatorRepository calculatorRepository;

    @Override
    public void save(Calculator calculator) {
        log.info("In CalculatorServiceImpl save {}", calculator);
        calculatorRepository.save(calculator);
    }

    @Override
    public Calculator calculate(Calculator calculator) {
        if (calculator.getFirstValue() != null
                && calculator.getSecondValue() != null
                && calculator.getOperation() != null) {
            switch (calculator.getOperation()) {
                case "sum" :
                    sum(calculator);
                    break;
                case "sub" :
                    sub(calculator);
                    break;
                case "div" :
                    div(calculator);
                    break;
                case "mul" :
                    mul(calculator);
                    break;
                default:
                    break;
            }
        }
        return calculator;
    }

    public void sum(Calculator calculator) {
        Double sum = calculator.getFirstValue() + calculator.getSecondValue();
        calculator.setResult(sum);
        save(calculator);
        log.info("Sum, result: {}", sum);
    }

    public void sub(Calculator calculator) {
        Double sub = calculator.getFirstValue() - calculator.getSecondValue();
        calculator.setResult(sub);
        save(calculator);
        log.info("Sub, result: {}", sub);
    }

    public void div(Calculator calculator) {
        if (calculator.getSecondValue() == 0) {
            log.info("Div method. You can't divide on zero");
            return;
        }
        Double div = calculator.getFirstValue() / calculator.getSecondValue();
        calculator.setResult(div);
        save(calculator);
        log.info("Div, result: {}", div);
    }

    public void mul(Calculator calculator) {
        Double mul = calculator.getFirstValue() * calculator.getSecondValue();
        calculator.setResult(mul);
        save(calculator);
        log.info("Mul, result: {}", mul);
    }
}
