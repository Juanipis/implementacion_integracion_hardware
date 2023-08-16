package com.sebas_seguimiento.seguimiento1.services;

import java.util.List;

import com.sebas_seguimiento.seguimiento1.model.Estudiante;


public interface IEstudianteService {
    public List<Estudiante> findAll();
    public Estudiante findById(Long id);
    public void deleteById(Long id);
    public Estudiante save(Estudiante estudiante);
}
