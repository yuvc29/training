package com.fareye.training.service;

import com.fareye.training.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Repository {
    List<User> users = new ArrayList<>();

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public HashMap<String, User> getMap() {
        return map;
    }

    public void setMap(HashMap<String, User> map) {
        this.map = map;
    }

    HashMap<String, User> map = new HashMap<>();
}
