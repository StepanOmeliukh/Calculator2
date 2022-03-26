package com.example.calculator2.dto;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CalculatorDto {
    private Double firstValue;
    private Double secondValue;
    private String operation;
    private Double result;
}
