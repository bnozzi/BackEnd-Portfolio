package com.web.Portfolio.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.Portfolio.Model.SobreMi;
import com.web.Portfolio.Model.Usuario;
import com.web.Portfolio.Repository.UserRepository;

@Service
public class UserService implements InterUserService {
    //inyecto las dependencias de user Repository
    @Autowired
    public UserRepository userRepo;

    @Override
    public Usuario getUser(Long id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public void addUser(Usuario user) {
        userRepo.save(user);

    }

    @Override
    public void addAboutUser(SobreMi sobreMi) {

    }

    @Override
    public Usuario getUserByEmail(String email) {
        return userRepo.findByEmail(email);

    }

    



}
