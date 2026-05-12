package com.universidad.tareas_api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/tareas")
public class TareaController {

    private final List<Tarea> tareas = new ArrayList<>();

    @PostMapping
    public Tarea crearTarea(@RequestBody Tarea tarea) {

        tarea.setId((long) (tareas.size() + 1));

        tareas.add(tarea);

        return tarea;
    }

    @GetMapping("/{id}")
    public Tarea obtenerTarea(@PathVariable Long id) {

        return tareas.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElseThrow(() ->
    new ResponseStatusException(HttpStatus.NOT_FOUND)
);
    }

    @PatchMapping("/{id}/completar")
    public Tarea completarTarea(@PathVariable Long id) {

        Tarea tarea = tareas.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElseThrow(() ->
    new ResponseStatusException(HttpStatus.NOT_FOUND)
);

        tarea.setCompletada(true);

        return tarea;
    }
}