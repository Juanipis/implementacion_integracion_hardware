package com.sebas_seguimiento.seguimiento1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sebas_seguimiento.seguimiento1.model.Estudiante;
import com.sebas_seguimiento.seguimiento1.services.IEstudianteService;

@RestController
@RequestMapping("/estudiante")
public class EstudianteController {
    @Autowired
    private IEstudianteService estudianteService;

    @GetMapping("/listar")
    public List<Estudiante> listar() {
        return estudianteService.findAll();
    }

    @GetMapping("/listar/{id}")
    public Estudiante listarPorId(@PathVariable Long id) {
        return estudianteService.findById(id);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Long id) {
        estudianteService.deleteById(id);
    }

    @PostMapping("/actualizar/{id}")
    public Estudiante guardar(@PathVariable Long id, @RequestBody Estudiante estudiante) {
        Estudiante estudianteActual = estudianteService.findById(id);
        if(estudianteActual != null) {
            estudianteActual.setNombre(estudiante.getNombre());
            estudianteActual.setApellido(estudiante.getApellido());
            estudianteActual.setEmail(estudiante.getEmail());
            estudianteActual.setTelefono(estudiante.getTelefono());
            estudianteService.save(estudianteActual);
        }
        return estudianteService.save(estudianteActual);
    }

    @PutMapping("/guardar")
    public void actualizar(@RequestBody Estudiante estudiante) {
        estudianteService.save(estudiante);
    }
}
