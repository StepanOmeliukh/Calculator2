package com.example.calculator2.service.Impl;

import com.example.calculator2.dto.CalculatorDto;
import com.example.calculator2.entity.Calculator;
import com.example.calculator2.repository.CalculatorRepository;
import com.example.calculator2.service.CalculatorService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class CalculatorServiceImpl implements CalculatorService {

    private final CalculatorRepository repository;

    private final ModelMapper modelMapper;

    public CalculatorDto sum(CalculatorDto calculatorDto) {
        Double sum = calculatorDto.getFirstValue() + calculatorDto.getSecondValue();
        calculatorDto.setResult(sum);
        calculatorDto.setOperation("sum");
        saveDataToDB(calculatorDto);
        log.info("Method sum calculate sum of two values and return result {}", calculatorDto.getResult());
        return calculatorDto;
    }

    public CalculatorDto sub(CalculatorDto calculatorDto) {
        Double sub = calculatorDto.getFirstValue() - calculatorDto.getSecondValue();
        calculatorDto.setResult(sub);
        calculatorDto.setOperation("sub");
        saveDataToDB(calculatorDto);
        log.info("Method sub calculate sum of two values and return result {}", calculatorDto.getResult());
        return calculatorDto;
    }

    public CalculatorDto div(CalculatorDto calculatorDto) throws IllegalArgumentException {
        if (calculatorDto.getSecondValue() == 0) {
            log.info("Method div can't calculate division on zero");
            throw new IllegalArgumentException("You can't devide on zero");
        }
        Double div = calculatorDto.getFirstValue() / calculatorDto.getSecondValue();
        calculatorDto.setResult(div);
        calculatorDto.setOperation("div");
        saveDataToDB(calculatorDto);
        log.info("Method div calculate sum of two values and return result {}", calculatorDto.getResult());
        return calculatorDto;
    }

    public CalculatorDto mul(CalculatorDto calculatorDto) {
        Double mul = calculatorDto.getFirstValue() * calculatorDto.getSecondValue();
        calculatorDto.setResult(mul);
        calculatorDto.setOperation("mul");
        saveDataToDB(calculatorDto);
        log.info("Method mul calculate sum of two values and return result {}", calculatorDto.getResult());
        return calculatorDto;
    }

    public List<CalculatorDto> getAllCalculates() {
        List<Calculator> calculators = repository.findAll();
        return Arrays.asList(modelMapper.map(calculators, CalculatorDto[].class));
    }

    public Optional<CalculatorDto> getCalculatesById(Long id) {
        return repository.findById(id)
                .map(calculator -> new CalculatorDto(
                        calculator.getFirstValue(),
                        calculator.getSecondValue(),
                        calculator.getOperation(),
                        calculator.getResult()
                ));
    }

    public boolean checkValues(CalculatorDto calculatorDto) {
        return calculatorDto.getFirstValue() != null
                && calculatorDto.getSecondValue() != null;
    }

    public void saveDataToDB(CalculatorDto calculatorDto) {
        Calculator calculator = modelMapper.map(calculatorDto, Calculator.class);
        repository.save(calculator);
    }
}
