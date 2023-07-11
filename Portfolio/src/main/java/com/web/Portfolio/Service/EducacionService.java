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
        try {
            return eduRepo.findAll();
        } catch (Exception ex) {
            // Manejo de la excepción
            ex.printStackTrace();
            return null; // O devuelve una lista vacía, dependiendo de tus requisitos
        }
    }

    @Override
    public Educacion getEducation(long id) {
        try {
            return eduRepo.findById(id).orElse(null);
        } catch (Exception ex) {
            // Manejo de la excepción
            ex.printStackTrace();
            return null; // O devuelve un objeto nulo, dependiendo de tus requisitos
        }
    }

    @Override
    public void addEducation(Educacion educacion) {
        try {
            Usuario user = userRepo.findById((long) 151297).orElse(null);
            user.agregarEducacion(educacion);
            educacion.setUsuario(user);
            userRepo.flush();
            eduRepo.save(educacion);
        } catch (Exception ex) {
            // Manejo de la excepción
            ex.printStackTrace();
            // Otros pasos de manejo de excepciones, como devolver una respuesta de error
        }
    }

    @Override
    public void removeEducation(long id) {
        try {
            eduRepo.deleteById(id);
            eduRepo.flush();
        } catch (Exception ex) {
            // Manejo de la excepción
            ex.printStackTrace();
            // Otros pasos de manejo de excepciones, como devolver una respuesta de error
        }
    }

    @Override
    public void updateEducation(long id, Educacion educacion) {
        try {
            Educacion edu = eduRepo.findById(id).orElse(null);
            if (edu != null) {
                edu.setTitulo(educacion.getTitulo());
                edu.setDescripcion(educacion.getDescripcion());
                edu.setTiempoDesde(educacion.getTiempoDesde());
                edu.setTiempoHasta(educacion.getTiempoHasta());
                edu.setImagen(educacion.getImagen());
                edu.setUsuario(educacion.getUsuario());
                edu.setActualmente(educacion.getActualmente());
                edu.setLinkCertificate(educacion.getLinkCertificate());
                eduRepo.flush();
                eduRepo.save(edu);
            }
        } catch (Exception ex) {
            // Manejo de la excepción
            ex.printStackTrace();
            // Otros pasos de manejo de excepciones, como devolver una respuesta de error
        }
    }
}
