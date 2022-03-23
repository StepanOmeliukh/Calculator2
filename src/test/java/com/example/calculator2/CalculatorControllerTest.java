//package com.example.calculator2;
//
//import com.example.calculator2.controller.CalculatorController;
//import com.example.calculator2.entity.Calculator;
//import com.example.calculator2.service.CalculatorService;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.BeforeClass;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.hamcrest.Matchers.hasSize;
//import static org.hamcrest.Matchers.is;
//import static org.mockito.BDDMockito.given;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@Slf4j
//@RunWith(SpringRunner.class)
//@WebMvcTest(CalculatorController.class)
//public class CalculatorControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private CalculatorService service;
//
//    @BeforeClass
//    public static void setUp() {
//        log.info("Start CalculatorControllerTest");
//    }
//
//    @Test
//    public void createRecordTest() throws Exception {
//        Calculator calculator = Calculator.builder()
//                .id(1L)
//                .firstValue(1.0)
//                .secondValue(2.0)
//                .operation("sum")
//                .result(3.0)
//                .build();
//
//        given(service.calculate(Calculator.builder()
//                .id(1L)
//                .firstValue(1.0)
//                .secondValue(2.0)
//                .operation("sum")
//                .result(3.0)
//                .build())
//        )
//                .willReturn(calculator);
//
//        mockMvc.perform(post("/api/v1/calc")
//                .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(1)))
//                .andExpect(jsonPath("$[0].result", is(calculator.getResult())));
//    }
//}
