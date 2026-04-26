package com.example.btvn_2504.service.impl;

import com.example.btvn_2504.model.Todo;
import com.example.btvn_2504.repository.ITodoRepository;
import com.example.btvn_2504.service.ITodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements ITodoService {

    private final ITodoRepository todoRepository;

    @Override
    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    @Override
    public Todo save(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public Optional<Todo> findById(Long id) {
        return todoRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        todoRepository.deleteById(id);
    }

}
