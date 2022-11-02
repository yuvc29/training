package com.fareye.training.controller;

import com.fareye.training.model.User;
import com.fareye.training.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
//import org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

//@RunWith(SpringRunner.class)
@SpringBootTest
class UserControllerTest {

    @MockBean
    UserRepository repository;// = Mockito.mock(UserRepository.class);
    @Autowired
    UserController controller = new UserController();
    @Test
    void create() {
//        User user = new User();
//        user.setFirstName("John");
//        user.setLastName("Doe");
//        user.setEmail("john@gmail.com");
//        user.setPassword("abcd");
//        user.setRole("User");
//        user.setGit_id("example");
//        Mockito.when(repository.save(user)).thenReturn(user);
//        User response = controller.create(user);
//        // assertEquals(response.getStatusCode(), HttpStatus.OK);
//        assertEquals(response.getEmail(), user.getEmail());
    }

    @Test
    void get_avatar() {
    }

    @Test
    void getuser() {
    }

    @Test
    void deleteuser() {
    }

    @Test
    void update() {
    }
}