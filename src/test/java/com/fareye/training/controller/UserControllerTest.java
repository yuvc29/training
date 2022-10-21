package com.fareye.training.controller;

import com.fareye.training.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.mockito.Mock;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class UserControllerTest {

    @Test
    void create() {
        UserController userController = new UserController();
        User input  = new User();
        input.setLastName("Doe");
        input.setAvatar("https://avatars.githubusercontent.com/u/57936?v=4");
        input.setEmail("john.doe@gmail.com");
        input.setFirstName("John");
        User res = userController.create(input);
        assertEquals(input.getEmail(), res.getEmail());
    }


    @Test
    void getuser() {
        UserController userController = new UserController();
        User input = new User();
        input.setLastName("Doe");
        input.setEmail("john.doe@gmail.com");
        input.setFirstName("Jonh");
        // when(userController.map.get("john.doe@gmail.com")).thenReturn(input);
        User res = userController.getuser("john.doe@gmail.com");
        assertEquals(input.getEmail(), res.getEmail());
    }

    @Test
    void deleteuser() {
        UserController userController = new UserController();
        User input = new User();
        input.setLastName("Doe");
        input.setEmail("john.doe@gmail.com");
        input.setFirstName("Jonh");

        // when(userController.map.remove("john.doe@gmail.com")).thenReturn(input);
        int res = userController.deleteuser("john.doe@gmail.com");
        assertEquals(0, res);

    }

    @Test
    void update() {
        UserController userController = new UserController();
        User input = new User();
        input.setLastName("Doe");
        input.setAvatar("https://avatars.githubusercontent.com/u/57936?v=4");
        input.setEmail("john.doe@gmail.com");
        input.setFirstName("John");
        // when(userController.map.get("john.doe@gmail.com")).thenReturn(input);
        User res = userController.update(input);
        assertEquals(input.getEmail(), res.getEmail());
    }
}