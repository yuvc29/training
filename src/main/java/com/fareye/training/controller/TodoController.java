package com.fareye.training.controller;

import com.fareye.training.customAnno.TitleValidator;
import com.fareye.training.model.Todo;
import com.fareye.training.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping(value = "/todo")
@CrossOrigin(origins = "http://localhost:3000")
public class TodoController {
    @Autowired
    public TodoRepository todoRepository;

    @InitBinder("Title")
    protected void initTitleBinder(WebDataBinder binder){
        binder.addValidators((Validator) new TitleValidator(todoRepository));
    }
    @GetMapping(value = "/getlist")
    public List<Todo> getlist(@RequestParam("email") String email){
        return todoRepository.findAllByEmail(email);
    }
    @DeleteMapping (value = "/delete")
    public Map<String, Boolean> delete(@RequestParam("email") String email){
        String title = "";
        for(int i = 0; i < email.length(); i++){
            if(Character.compare(email.charAt(i), ' ') == 0){
                title = email.substring(i+1, email.length() );
                email = email.substring(0, i);
                break;
            }
        }
        todoRepository.deleteByTitleAndEmail(title, email);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }


    @PutMapping (value = "/update")
    public Todo update(@RequestBody @Valid Todo todo){ //////////////////////// @Valid
        Todo to_be_updated = todoRepository.findByTitleAndEmail(todo.getTitle(), todo.getEmail());
        to_be_updated.setBody(todo.getBody());
        to_be_updated.setStatus(todo.getStatus());
        to_be_updated.setModifiedDate(new Date());
        to_be_updated.setDueDate(todo.getDueDate());
        final Todo updated = todoRepository.save(to_be_updated);
        return updated;
    }


    @PostMapping(value = "/create")
    public Todo create(@RequestBody @Valid Todo todo){
        todo.setCreatedDate(new Date());
        todo.setStatus("incomplete");
        todoRepository.save(todo);
        //return todoRepository.findAllByEmail(todo.getEmail());
        return todo;
    }
}