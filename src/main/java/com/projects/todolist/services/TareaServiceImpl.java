package com.projects.todolist.services;

import com.projects.todolist.models.Tarea;
import com.projects.todolist.repositories.TareaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TareaServiceImpl implements TareaService {

    private TareaRepository tareaRepository;
    public TareaServiceImpl(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    @Override
    public Tarea agregarTarea(Tarea tarea) {
        tareaRepository.save(tarea);
        return tarea;
    }

    @Override
    public Tarea actualizarTarea(Tarea tarea) {
        tareaRepository.save(tarea);
        return tarea;
    }

    @Override
    public Tarea eliminarTarea(Tarea tarea) {
        tareaRepository.delete(tarea);
        return tarea;
    }

    @Override
    public Tarea buscarTarea(Tarea tarea) {
        return tareaRepository.findById(tarea.getId()).orElse(null);
    }

    @Override
    public String obtenerFechaActual() {
        LocalDate today = LocalDate.now();
        return today.toString();
    }
}
