package com.example.sysfoo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;

import com.example.sysfoo.service.SystemInfoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(SystemInfoController.class)
public class SystemInfoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SystemInfoService systemInfoService;

    @Test
    public void getVersionTest() throws Exception {
        when(systemInfoService.getAppVersion()).thenReturn("1.0.0");
        mockMvc.perform(get("/version"))
                .andExpect(status().isOk())
                .andExpect(content().string("1.0.0"));
    }
}
