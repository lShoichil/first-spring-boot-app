package com.example.reservation.service;

import com.example.reservation.entity.TodoEntity;
import com.example.reservation.entity.UserEntity;
import com.example.reservation.model.Todo;
import com.example.reservation.repository.TodoRepository;
import com.example.reservation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private UserRepository userRepository;

    public Todo createTodo (TodoEntity todo, Long userId) {
        UserEntity user = userRepository.findById(userId).get();
        todo.setUser(user);
        return Todo.toModel(todoRepository.save(todo));
    }

    public Todo completeTodo (Long Id) {
        TodoEntity todo = todoRepository.findById(Id).get();
        todo.setCompleted(!todo.getCompleted());
        return Todo.toModel(todoRepository.save(todo));
    }
}
