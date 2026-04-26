package com.example.btvn_2504.service;

import com.example.btvn_2504.model.Todo;

import java.util.List;
import java.util.Optional;

public interface ITodoService {
    List<Todo> findAll();
    Todo save(Todo todo);
    Optional<Todo> findById(Long id);
    void deleteById(Long id);
}
