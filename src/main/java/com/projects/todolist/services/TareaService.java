package com.projects.todolist.services;

import com.projects.todolist.models.Tarea;

public interface TareaService {
    public Tarea agregarTarea(Tarea tarea);
    public Tarea actualizarTarea(Tarea tarea);
    public Tarea eliminarTarea(Tarea tarea);
    public Tarea buscarTarea(Tarea tarea);
    public String obtenerFechaActual();
}
