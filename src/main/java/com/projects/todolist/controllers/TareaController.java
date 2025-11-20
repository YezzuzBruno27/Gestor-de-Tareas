package com.projects.todolist.controllers;

import com.projects.todolist.models.Tarea;
import com.projects.todolist.services.TareaService;
import com.projects.todolist.services.TareaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TareaController {

    private TareaService tareaService;
    TareaController(TareaService tareaService) {
        this.tareaService = tareaService;
    }

    @GetMapping("/agregarTarea")
    private String agregarTarea(){
        return "agregar";
    }

    @PostMapping("/agregarTarea")
    private String agregarTarea(@RequestParam String nombre,
                                @RequestParam String descripcion, Model model){
        Tarea tarea = new Tarea();
        tarea.setNombre(nombre);
        tarea.setDescripcion(descripcion);
        tarea.setFechaCreacion(tareaService.obtenerFechaActual());
        tarea.setEstado("CREADO");
        tareaService.agregarTarea(tarea);
        model.addAttribute("tarea",tarea);
        return "exito";
    }

    @GetMapping("/actualizarTarea/{id}")
    private String actualizarTarea(@PathVariable Integer id,
                                   Model model){
        Tarea tarea = new Tarea();
        tarea.setId(id);
        tarea = tareaService.buscarTarea(tarea);
        model.addAttribute("tarea",tarea);
        return "actualizar";
    }

    @PostMapping("/actualizarTarea")
    private String actualizarTarea(@RequestParam String nombre,
                                   @RequestParam String descripcion, Model model,
                                   @RequestParam Integer id,
                                   @RequestParam String estado,
                                   Model model2
                                   )
    {
        Tarea tarea = new Tarea();
        tarea.setNombre(nombre);
        tarea.setDescripcion(descripcion);
        tarea.setId(id);
        tarea.setEstado(estado);
        tarea.setFechaCreacion(tareaService.obtenerFechaActual());
        tareaService.actualizarTarea(tarea);
        model2.addAttribute("tarea",tarea);
        return "exito_actualizar";
    }



}
