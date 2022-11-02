//
//package com.fareye.training.controller;
//
//        import com.fareye.training.model.User;
//        import com.google.gson.JsonObject;
//        import com.google.gson.JsonParser;
//        import org.springframework.web.bind.annotation.*;
//        import org.springframework.web.client.RestTemplate;
//
//        import java.util.ArrayList;
//        import java.util.Date;
//        import java.util.HashMap;
//        import java.util.List;
//
//
//@RestController
//@RequestMapping(value = "/user")
//public class User_controller{
//    List<User> users = new ArrayList<>();
//    HashMap<String, User> map = new HashMap<>();
//
//    @PostMapping(value = "/create")
//    public User create(@RequestBody User user){
//        user.setVerified(true);
//        user.setCreated(new Date());
//        user.setActive(true);
//        user.setPassword(String.valueOf(user.getPassword().hashCode()));
//        user.setAvatar( get_avatar(user.getGit_id()) );
//
//        users.add(user);
//        map.put(user.getEmail(), user );
//        return user;
//    }
//
//    public String get_avatar(String git_id){
//        RestTemplate restTemplate = new RestTemplate();
//        String gituser  = restTemplate.getForObject(
//                "https://api.github.com/users/" + git_id, String.class
//        );
//        JsonObject gituser_json = new JsonParser().parse(gituser).getAsJsonObject();
//        return gituser_json.get("avatar_url").getAsString();
//    }
//
//    @GetMapping(value = "/getuser")
//    public User getuser(@RequestParam("user") String user){
//        return map.get(user);
//    }
//
////    public User getuser(@RequestParam("user") String user){
////        return map.get(user);
////    }
//
//    @DeleteMapping(value  = "/deleteuser")
//    public int deleteuser(@RequestParam("user") String user){
//        map.remove(user);
//        System.out.print(map.size()); //map.size()
//        return map.size();
//    }
//
//    @PutMapping(value  = "/update")
//    public User update(@RequestBody User user){
//        User to_be_updated = map.get(user.getEmail());
//        to_be_updated.setModified(new Date());
//        to_be_updated.setFirstName(user.getFirstName());
//        to_be_updated.setLastName(user.getLastName());
//        return to_be_updated;
//    }
//}
//
////        private String firstName;
////        private String lastName;
////        private String email;
////        private boolean verified;
////        private Date created;
////        private Date modified;
////        private String password;
////        private String role;
////        private boolean active;
//
//
