package com.example.calculator2.service.Impl;

import com.example.calculator2.dto.CalculatorDto;
import com.example.calculator2.entity.Calculator;
import com.example.calculator2.repository.CalculatorRepository;
import com.example.calculator2.service.CalculatorService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class CalculatorServiceImpl implements CalculatorService {

    private final CalculatorRepository repository;
    private final Calculator calculator;

    private final ModelMapper modelMapper;

//    @Override
//    public Calculator calculate(Calculator calculator) {
//        if (calculator.getFirstValue() != null
//                && calculator.getSecondValue() != null
//                && calculator.getOperation() != null) {
//            switch (calculator.getOperation()) {
//                case "sum" :
//                    sum(calculator);
//                    break;
//                case "sub" :
//                    sub(calculator);
//                    break;
//                case "div" :
//                    div(calculator);
//                    break;
//                case "mul" :
//                    mul(calculator);
//                    break;
//                default:
//                    break;
//            }
//        }
//        return calculator;
//    }

    public boolean checkValuesAndOperation(CalculatorDto calculatorDto) {
        if (calculatorDto.getFirstValue() != null
                && calculatorDto.getSecondValue() != null
                && calculatorDto.getOperation() != null)
            return true;
        return false;
    }

    public void sum(CalculatorDto calculatorDto) {
        Double sum = calculatorDto.getFirstValue() + calculatorDto.getSecondValue();
        calculatorDto.setResult(sum);
//        repository.save(calculatorDto);
        log.info("Sum, result: {}", sum);
    }

    public void sub(CalculatorDto calculatorDto) {
        Double sub = calculatorDto.getFirstValue() - calculatorDto.getSecondValue();
        calculatorDto.setResult(sub);
//        repository.save(calculatorDto);
        log.info("Sub, result: {}", sub);
    }

    public void div(CalculatorDto calculatorDto) {
        if (calculatorDto.getSecondValue() == 0) {
            log.info("Div method. You can't divide on zero");
            return;
        }
        Double div = calculatorDto.getFirstValue() / calculatorDto.getSecondValue();
        calculatorDto.setResult(div);
//        repository.save(calculatorDto);
        log.info("Div, result: {}", div);
    }

    public void mul(CalculatorDto calculatorDto) {
        Double mul = calculatorDto.getFirstValue() * calculatorDto.getSecondValue();
        calculatorDto.setResult(mul);
//        repository.save(calculatorDto);
        log.info("Mul, result: {}", mul);
    }

//    public void saveDataToDB(CalculatorDto calculatorDto) {
//        modelMapper.map(calculatorDto, Calculator.class);
//        modelMapper.map(repository.save(calculator));
//    }
}
