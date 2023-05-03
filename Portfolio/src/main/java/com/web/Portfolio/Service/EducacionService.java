package com.web.Portfolio.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.Portfolio.Model.Educacion;
import com.web.Portfolio.Model.Usuario;
import com.web.Portfolio.Repository.EducacionRepository;
import com.web.Portfolio.Repository.UserRepository;

@Service
public class EducacionService implements InterEducacionService {

    @Autowired
    public EducacionRepository eduRepo;

    @Autowired
    public UserRepository userRepo;

    @Override
    public List<Educacion> getAllEducations() {
        return eduRepo.findAll();
    }

    @Override
    public Educacion getEducation(long id) {
        return eduRepo.findById(id).orElse(null);
    }

    @Override
    public void addEducation(Educacion educacion) {
        Usuario user = userRepo.findById((long) 151297).orElse(null);
        user.agregarEducacion(educacion);
        educacion.setUsuario(user);
        userRepo.flush();
        eduRepo.save(educacion);
    }

    @Override
    public void removeEducation(long id) {
        eduRepo.deleteById(id);
        eduRepo.flush();

    }

    @Override
    public void updateEducation(long id, Educacion educacion) {
        Educacion edu = eduRepo.findById(id).orElse(null);
        
        if (edu != null) {
            edu.setTitulo(educacion.getTitulo());
            edu.setDescripcion(educacion.getDescripcion());
            edu.setTiempoDesde(educacion.getTiempoDesde());
            edu.setTiempoHasta(educacion.getTiempoHasta());
            edu.setImagen(educacion.getImagen());
            edu.setUsuario(educacion.getUsuario());
            edu.setActualmente(educacion.getActualmente());
            eduRepo.flush();
            eduRepo.save(edu);
        }
    }

}
