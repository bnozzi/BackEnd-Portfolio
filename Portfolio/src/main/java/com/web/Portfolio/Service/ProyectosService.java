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
        return proyectoRepository.findAll();
    }

    @Override
    public Proyecto getProyect(long id) {
        return proyectoRepository.findById(id).orElse(null);
    }

    @Override
    public void addProyect(Proyecto proyect) {
        Usuario user = userRepo.findById((long) 151297).orElse(null);
        user.agregarProyecto(proyect);
        proyect.setUsuario(user);
        userRepo.flush();
        proyectoRepository.save(proyect);

    }

    @Override
    public void deleteProyect(Long id) {
        proyectoRepository.deleteById(id);

    }

    @Override
    public void updateProyect(long id, Proyecto proyect) {
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
    }

}
