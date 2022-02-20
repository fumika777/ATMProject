package com.github.ATMproject.controller;

import com.github.ATMproject.services.ClientService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ClientControllerTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    ClientRestController clientRestController;

    @Test
    public void loginTest() throws Exception {
        this.mvc.perform(get("http://localhost:8081/login?cardNumber=4000001234567899&PIN=1012")).andDo(print()).andExpect(status().isOk());
    }
    @Test
    public void getBalance() throws Exception {
        this.mvc.perform(get("http://localhost:8081/getBalance?cardNumber=4000001234567899")).andDo(print()).andExpect(status().isOk());
    }
    @Test
    public void logout() throws Exception {
        this.mvc.perform(get("http://localhost:8081/logout")).andDo(print()).andExpect(status().isOk());
    }
}
