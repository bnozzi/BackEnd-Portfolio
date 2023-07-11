package com.web.Portfolio.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.Portfolio.Model.SobreMi;
import com.web.Portfolio.Model.Usuario;
import com.web.Portfolio.Repository.UserRepository;

@Service
public class UserService implements InterUserService {
    // Inyecto las dependencias de UserRepository
    @Autowired
    public UserRepository userRepo;

    @Override
    public Usuario getUser(Long id) {
        try {
            return userRepo.findById(id).orElse(null);
        } catch (Exception ex) {
            // Manejo de la excepción
            ex.printStackTrace();
            return null; // O devuelve un objeto nulo, dependiendo de tus requisitos
        }
    }

    @Override
    public void addUser(Usuario user) {
        try {
            userRepo.save(user);
        } catch (Exception ex) {
            // Manejo de la excepción
            ex.printStackTrace();
            // Otros pasos de manejo de excepciones, como devolver una respuesta de error
        }
    }

    @Override
    public void addAboutUser(SobreMi sobreMi) {
        // Lógica para agregar información sobre el usuario
    }

    @Override
    public Usuario getUserByEmail(String email) {
        try {
            return userRepo.findByEmail(email);
        } catch (Exception ex) {
            // Manejo de la excepción
            ex.printStackTrace();
            return null; // O devuelve un objeto nulo, dependiendo de tus requisitos
        }
    }
}
