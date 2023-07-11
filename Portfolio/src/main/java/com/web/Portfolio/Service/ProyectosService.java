package com.web.Portfolio.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.Portfolio.Model.Proyecto;
import com.web.Portfolio.Model.Usuario;
import com.web.Portfolio.Repository.ProyectoRepository;
import com.web.Portfolio.Repository.UserRepository;

@Service
public class ProyectosService implements InterProyectoService {

    @Autowired
    public ProyectoRepository proyectoRepository;

    @Autowired
    public UserRepository userRepo;

    @Override
    public List<Proyecto> getAllProyects() {
        try {
            return proyectoRepository.findAll();
        } catch (Exception ex) {
            // Manejo de la excepción
            ex.printStackTrace();
            return null; // O devuelve una lista vacía, dependiendo de tus requisitos
        }
    }

    @Override
    public Proyecto getProyect(long id) {
        try {
            return proyectoRepository.findById(id).orElse(null);
        } catch (Exception ex) {
            // Manejo de la excepción
            ex.printStackTrace();
            return null; // O devuelve un objeto nulo, dependiendo de tus requisitos
        }
    }

    @Override
    public void addProyect(Proyecto proyect) {
        try {
            Usuario user = userRepo.findById((long) 151297).orElse(null);
            user.agregarProyecto(proyect);
            proyect.setUsuario(user);
            userRepo.flush();
            proyectoRepository.save(proyect);
        } catch (Exception ex) {
            // Manejo de la excepción
            ex.printStackTrace();
            // Otros pasos de manejo de excepciones, como devolver una respuesta de error
        }
    }

    @Override
    public void deleteProyect(Long id) {
        try {
            proyectoRepository.deleteById(id);
        } catch (Exception ex) {
            // Manejo de la excepción
            ex.printStackTrace();
            // Otros pasos de manejo de excepciones, como devolver una respuesta de error
        }
    }

    @Override
    public void updateProyect(long id, Proyecto proyect) {
        try {
            Proyecto proyecto = proyectoRepository.findById(id).orElse(null);

            if (proyecto != null) {
                proyecto.setImagenProyecto(proyect.getImagenProyecto());
                proyecto.setTitulo(proyect.getTitulo());
                proyecto.setDescripcion(proyect.getDescripcion());
                proyecto.setTecnologias(proyect.getTecnologias());
                proyecto.setUrl(proyect.getUrl());
                proyecto.setUrlRepositorio(proyect.getUrlRepositorio());

                proyectoRepository.flush();
                proyectoRepository.save(proyecto);
            }
        } catch (Exception ex) {
            // Manejo de la excepción
            ex.printStackTrace();
            // Otros pasos de manejo de excepciones, como devolver una respuesta de error
        }
    }

}
