//package com.fareye.training.service;
//
//import com.fareye.training.model.Todo;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//
//public class TodoServices {
//    public static HashMap<String, List<Todo>> map = new HashMap<>();
//    public List<Todo> get_user(String user){
//        return map.get(user);
//    }
//    public List delete(String user){
//        String title = "";
//        for(int i = 0; i < user.length(); i++){
//            if(Character.compare(user.charAt(i), ' ') == 0){
//                title = user.substring(i+1, user.length() );
//                user = user.substring(0, i);
//                break;
//            }
//        }
//        System.out.println(title);
//        // List<Todo>new_list = new ArrayList<>();
//        for(int i = 0; i < map.get(user).size(); i++){
//            if(map.get(user).get(i).getTitle().equals(title) ){
//                map.get(user).remove(i);
//            }
//            // else new_list.add(map.get(user).get(i));
//        }
//        return map.get(user);
//        //return new_list;
//    }
//
//    public Todo update(Todo todo){
//        List<Todo> list = map.get(todo.getUser());
//        int to_update = 0; // = new Todo();
//        for(int i = 0; i < list.size(); i++){
//            if(list.get(i).getTitle() == todo.getTitle()){
//                to_update = i;
//                break;
//            }
//        }
//        list.set(to_update, todo);
//        return list.get(to_update);
//    }
//
//    public List<Todo> create( @Valid Todo todo){
//        todo.setCreatedDate(new Date());
//        todo.setStatus("incomplete");
//        String email = todo.getEmail();
//        if(map.containsKey(user)){
//            map.get(user).add(todo);
//        }
//        else {
//            List<Todo> todoList = new ArrayList<>();
//            todoList.add(todo);
//            map.put(user, todoList);
//        }
//        return map.get(user);
//    }
//}
