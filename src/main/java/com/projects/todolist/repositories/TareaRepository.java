package com.projects.todolist.repositories;

import com.projects.todolist.models.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TareaRepository extends JpaRepository<Tarea, Integer> {
}
