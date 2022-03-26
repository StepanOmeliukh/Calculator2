package com.example.calculator2;

import com.example.calculator2.dto.CalculatorDto;
import com.example.calculator2.service.CalculatorService;
import lombok.AllArgsConstructor;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@SpringBootTest()
@AutoConfigureMockMvc
@AllArgsConstructor
public class CalculatorControllerTest {

    @Autowired
    private final MockMvc mockMvc;

    @MockBean
    private final CalculatorService calculatorService;

    @Test
    public void sumControllerTest() throws Exception {
        when(calculatorService.sum(CalculatorDto.builder()
                .firstValue(2.0)
                .secondValue(5.0)
                .build()))
                .thenReturn(CalculatorDto.builder()
                        .firstValue(2.0)
                        .secondValue(5.0)
                        .result(7.0)
                        .operation("sum")
                        .build());

        this.mockMvc.perform(post("/api/v1/sum")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.firstValue").value(2.0))
                .andExpect(jsonPath("$.secondValue").value(5.0))
                .andExpect(jsonPath("$.result").value(7.0));
    }

}
