package com.fareye.training.customAnno;

import com.fareye.training.customAnno.DuplicateTitle;
import com.fareye.training.model.Todo;
import com.fareye.training.controller.TodoController;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class TitleValidator implements ConstraintValidator<DuplicateTitle, Todo> {

    @Override
    public void initialize(DuplicateTitle TodoTitle) {
    }

    @Override
    public boolean isValid(Todo todo, ConstraintValidatorContext cxt) {

        List<Todo> todos = TodoController.map.get(todo.getUser());
        String title = todo.getTitle();
        if(todos == null)return true;
        for(int i = 0; i < todos.size(); i++) {
            if (todos.get(i).getTitle().equals(title)) {
                System.out.println(todos.size());
                return false;
            }
        }
        return true;

    }
}