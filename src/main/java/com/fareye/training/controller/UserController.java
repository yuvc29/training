package com.fareye.training.controller;

import com.fareye.training.exception.ResourceNotFoundException;
import com.fareye.training.model.User;
import com.fareye.training.repository.UserRepository;
// import com.fareye.training.service.UserService;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import jdk.internal.dynalink.support.NameCodec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
// import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.*;


@RestController
@RequestMapping(value = "/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController{

    @Autowired
    public UserRepository userRepository;

    @PostMapping(value = "/create")
    public User create(@RequestBody User user) {
        String avatar = get_avatar(user.getGit_id()) ;
//        if(avatar.length() == 0)throw new ResourceNotFoundException("Git Id not found");
        user.setVerified(true);
        user.setCreated(new Date());
        user.setActive(true);
        user.setPassword(String.valueOf(user.getPassword().hashCode()));
        //user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setAvatar( avatar );
        user.setRole("User");
        return userRepository.save(user);
    }

    public String get_avatar(String git_id) {
        RestTemplate restTemplate = new RestTemplate();
        String gituser  = restTemplate.getForObject("https://api.github.com/users/" + git_id, String.class);
        JsonObject gituser_json = new JsonParser().parse(gituser).getAsJsonObject();
        if(gituser_json.has("avatar_url")) return gituser_json.get("avatar_url").getAsString();
        return "";
    }

    @GetMapping(value = "/getusers")
    public List<User> getusers(){
        return userRepository.findAll();
    }

    @PutMapping(value  = "/update")
    public ResponseEntity<User> update(@RequestBody User user){
        String avatar = get_avatar(user.getGit_id()) ;
 //       if(avatar.length() == 0)throw new ResourceNotFoundException();
        User to_be_updated = userRepository.findByEmail(user.getEmail());
        to_be_updated.setModified(new Date());
        to_be_updated.setFirstName(user.getFirstName());
        to_be_updated.setLastName(user.getLastName());
        to_be_updated.setPassword(String.valueOf(user.getPassword().hashCode()));
        to_be_updated.setRole(user.getRole());
        to_be_updated.setActive(user.isActive());
        to_be_updated.setGit_id(user.getGit_id());
        to_be_updated.setAvatar(avatar);
        final User updated = userRepository.save(to_be_updated);
        return ResponseEntity.ok(updated);
    }
    @DeleteMapping(value  = "/deleteuser")
    public Map<String, Boolean> deleteuser(@RequestParam("user") String user) {
        userRepository.deleteByEmail(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.email = email;
//        this.verified = verified;
//        this.created = created;
//        this.modified = modified;
//        this.git_id = git_id;
//        this.avatar = avatar;
//        this.password = password;
//        this.role = role;
//        this.active = active;

