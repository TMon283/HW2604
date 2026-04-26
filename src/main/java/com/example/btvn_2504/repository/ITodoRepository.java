package com.example.btvn_2504.repository;

import com.example.btvn_2504.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITodoRepository extends JpaRepository<Todo, Long> {
}

