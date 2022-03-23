package com.example.calculator2.repository;

import com.example.calculator2.entity.Calculator;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for {@link Calculator} class.
 */
public interface CalculatorRepository extends JpaRepository<Calculator, Long> {
}
