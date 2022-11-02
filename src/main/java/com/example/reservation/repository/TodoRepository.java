package com.example.reservation.repository;

import com.example.reservation.entity.TodoEntity;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository  extends CrudRepository<TodoEntity, Long> {

}
