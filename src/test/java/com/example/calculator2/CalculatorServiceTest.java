package com.example.calculator2;

import com.example.calculator2.dto.CalculatorDto;
import com.example.calculator2.entity.Calculator;
import com.example.calculator2.service.Impl.CalculatorServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class CalculatorServiceTest {
    @Autowired
    @InjectMocks
    private CalculatorServiceImpl service;
    private CalculatorDto dto1;
    private CalculatorDto dto2;
    private Optional<CalculatorDto> dto3;
    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator(1L, 5.0, 3.0, "sum", 7.0);
        dto1 = CalculatorDto.builder()
                .firstValue(5.0)
                .secondValue(2.0)
                .build();
        dto2 = CalculatorDto.builder()
                .firstValue(6.0)
                .secondValue(0.0)
                .build();
    }

    @Test
    public void sumTest() {
        CalculatorDto calculatorDto = service.sum(dto1);

        Assertions.assertEquals("sum", calculatorDto.getOperation());
        Assertions.assertEquals(Double.valueOf(7.0), calculatorDto.getResult());
    }

    @Test
    public void subTest() {
        CalculatorDto calculatorDto = service.sub(dto1);

        Assertions.assertEquals("sub", calculatorDto.getOperation());
        Assertions.assertEquals(Double.valueOf(3.0), calculatorDto.getResult());
    }

    @Test
    public void divTest() {
        CalculatorDto calculatorDto = service.div(dto1);

        Assertions.assertEquals("div", calculatorDto.getOperation());
        Assertions.assertEquals(Double.valueOf(2.5), calculatorDto.getResult());
    }

    @Test()
    public void divOnZeroTest() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            service.div(dto2);
        });

        Assertions.assertTrue(exception.getMessage().contains("You can't devide on zero"));
    }

    @Test
    public void mulTest() {
        CalculatorDto calculatorDto = service.mul(dto1);

        Assertions.assertEquals("mul", calculatorDto.getOperation());
        Assertions.assertEquals(Double.valueOf(10.0), calculatorDto.getResult());
    }

//    @Test
//    public void getAllCalculatesTest() {
//        List<CalculatorDto> list = new ArrayList<>();
//    }
//
//    @Test
//    public void getCalculatesByIdTest() {
//        dto3 = Optional.ofNullable(CalculatorDto.builder()
//                .firstValue(5.0)
//                .secondValue(1.0)
//                .operation("sum")
//                .result(6.0)
//                .build());
//        Assertions.assertEquals(dto3, service.getCalculatesById(1L));
//    }

}
