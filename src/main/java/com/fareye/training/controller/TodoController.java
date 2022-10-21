package com.fareye.training.controller;

import com.fareye.training.model.Todo;
import com.fareye.training.service.TodoServices;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping(value = "/todo")
@CrossOrigin(origins = "http://localhost:3000")
public class TodoController {
    public static HashMap<String, List<Todo>> map = new HashMap<>();
    public TodoServices todoservices;
    @GetMapping (value = "/getlist")
    public List<Todo> getlist(@RequestParam("user") String user){
        return todoservices.get_user(user);
    }

    @PostMapping(value = "/create")
    public List<Todo> create(@RequestBody @Valid Todo todo){
        return todoservices.create(todo);
    }

    @DeleteMapping (value = "/delete")
    public List delete(@RequestParam("user") String user){
        return todoservices.delete(user);
    }

    @PutMapping (value = "/update")
    public Todo update(@RequestBody Todo todo){
        return todoservices.update(todo);
    }


}



//    public List<Todo> getlist(@RequestParam("user") String user){
//        return map.get(user);
//    }

//    @DeleteMapping (value = "/delete")
//    public List delete(@RequestParam("user") String user){
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


//    @PutMapping (value = "/update")
//    public Todo update(@RequestBody Todo todo){
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



//    @PostMapping(value = "/create")
//    public List<Todo> create(@RequestBody @Valid Todo todo){
//        todo.setCreatedDate(new Date());
//        todo.setStatus("incomplete");
//        String user = todo.getUser();
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
