package com.fareye.training.customAnno;

import com.fareye.training.customAnno.DuplicateTitle;
import com.fareye.training.model.Todo;
import com.fareye.training.controller.TodoController;
import com.fareye.training.repository.TodoRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

@Configuration
public class TitleValidator implements ConstraintValidator<DuplicateTitle, Todo> {

    TodoRepository todoRepository;
    public TitleValidator(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }
    @Override
    public void initialize(DuplicateTitle TodoTitle) {
    }


    @Override
    public boolean isValid(Todo todo, ConstraintValidatorContext cxt) {
        Todo present = todoRepository.findByTitleAndEmail(todo.getTitle(),todo.getEmail());
        if(present == null)return true;
        return false;
    }
}