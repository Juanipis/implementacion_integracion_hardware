package com.sebas_seguimiento.seguimiento1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sebas_seguimiento.seguimiento1.dao.IEstudianteDAO;
import com.sebas_seguimiento.seguimiento1.model.Estudiante;

@Service
public class EstudianteService implements IEstudianteService{
    @Autowired
    private IEstudianteDAO estudianteDAO;

    @Override
    public List<Estudiante> findAll() {
        return  estudianteDAO.findAll();
    }

    @Override
    public Estudiante findById(Long id) {
        return estudianteDAO.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        estudianteDAO.deleteById(id);
    }

    @Override
    public Estudiante save(Estudiante estudiante) {
        return estudianteDAO.save(estudiante);
    }
    
}
