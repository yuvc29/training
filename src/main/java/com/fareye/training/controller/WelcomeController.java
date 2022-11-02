package com.fareye.training.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String welcome() {
        return "Welcome to Todo App";
    }
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserName(Authentication authentication) {
        return "You are authenticated as " + authentication.getName();
    }
}
