package com.project.success.controller;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.*;

import com.project.success.application.UserService;
import com.project.success.model.User;
import org.apache.catalina.Group;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService userService;

    @Test
    public void list() throws Exception {

        List<User> users = new ArrayList<>();
        users.add(User.builder().email("test@test.com").name("test").build());

        given(userService.getUsers()).willReturn(users);
        mvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("test")));
    }

    @Test
    public void create() throws Exception {
        mvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"email\":\"admin@admin.com\", \"name\":\"Admin\"}"))
                .andExpect(status().isCreated());


        String email = "admin@admin.com";
        String name = "Admin";
        String password = "22222";

        verify(userService).addUser(email, name, password);
    }


}