package com.example.calculator2.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;


/**\
 * JavaBean domain object that represents Calculator.
 */
@Entity
@Table(name = "calculator")
@ApiModel(value = "Calculator entity")
public class Calculator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty(value = "first value for calculation")
    @Column(name = "first_values")
    private Double firstValue;

    @ApiModelProperty(value = "second value for calculation")
    @Column(name = "second_value")
    private Double secondValue;

    @ApiModelProperty(value = "operation for calculation")
    @Column(name = "operation")
    private String operation;

    @ApiModelProperty(value = "result of calculation")
    @Column(name = "result")
    private Double result;
}
