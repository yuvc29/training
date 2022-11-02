//package com.fareye.training.service;
//
//import com.fareye.training.model.User;
//import com.fareye.training.repository.UserRepository;
//import com.google.gson.JsonObject;
//import com.google.gson.JsonParser;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.Date;
//import java.util.stream.Collectors;
//
//@Service
//public class UserServiceImpl implements UserService{
//
//    @Autowired
//    UserRepository userRepository;
//    private BCryptPasswordEncoder passwordEncoder;
//
//    public UserServiceImpl(UserRepository userRepository) {
//        super();
//        this.userRepository = userRepository;
//    }
//    @Override
//    public User save(User user) {
//        String avatar = get_avatar(user.getGit_id()) ;
////        if(avatar.length() == 0)throw new ResourceNotFoundException("Git Id not found");
//        user.setVerified(true);
//        user.setCreated(new Date());
//        user.setActive(true);
//        // user.setPassword(String.valueOf(user.getPassword().hashCode()));
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        user.setAvatar( avatar );
//        user.setRole("User");
//        return userRepository.save(user);
//    }
//
//    public String get_avatar(String git_id) {
//        RestTemplate restTemplate = new RestTemplate();
//        String gituser  = restTemplate.getForObject("https://api.github.com/users/" + git_id, String.class);
//        JsonObject gituser_json = new JsonParser().parse(gituser).getAsJsonObject();
//        if(gituser_json.has("avatar_url")) return gituser_json.get("avatar_url").getAsString();
//        return "";
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        User user = userRepository.findByEmail(username);
//        if(user == null) {
//            throw new UsernameNotFoundException("Invalid username or password.");
//        }
//        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(
//                new ArrayList<String>(){{add(user.getRole());}}
//        ));
//
//    }
//
//    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(ArrayList<String> roles){
//        return roles.stream().map(role -> new SimpleGrantedAuthority(role)).collect(Collectors.toList());
//    }
//}
