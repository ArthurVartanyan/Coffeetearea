//package ru.coffeetearea.controller;
//
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import ru.coffeetearea.CoffeeTeArea;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
////@SpringBootTest
//@RunWith(SpringRunner.class)
//@WebMvcTest(UserController.class)
////@ContextConfiguration(classes= CoffeeTeArea.class)
//@AutoConfigureMockMvc(addFilters = false)
//public class UserControllerTest {
//
//    private MockMvc mockMvc;
//
//    @Autowired
//    public void setMockMvc(MockMvc mockMvc) {
//        this.mockMvc = mockMvc;
//    }
//
//
//    @Test
//    void info() throws Exception {
//
//        this.mockMvc.perform(get("/users/info"))
//                .andDo(print())
//                .andExpect(status().isOk());
//    }
//}