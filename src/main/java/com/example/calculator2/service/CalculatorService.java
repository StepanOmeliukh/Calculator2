package com.example.calculator2.service;

import com.example.calculator2.entity.Calculator;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

/**
 *
 */
public interface CalculatorService {

    void save(Calculator calculator);
    Calculator calculate(Calculator calculator);
}
