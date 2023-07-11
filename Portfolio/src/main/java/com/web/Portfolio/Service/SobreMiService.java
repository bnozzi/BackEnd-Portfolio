package com.web.Portfolio.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.Portfolio.Model.SobreMi;
import com.web.Portfolio.Model.Usuario;
import com.web.Portfolio.Repository.SobreMiRepository;
import com.web.Portfolio.Repository.UserRepository;
@Service
public class SobreMiService implements InterSobreMiService {

    @Autowired
    public SobreMiRepository sobreMiRepository;

    @Autowired
    public UserRepository userRepo;

    @Override
    public SobreMi getAboutMe() {
        try {
            Usuario user = userRepo.findById((long) 151297).orElse(null);
            return user.getSobreMi();
        } catch (Exception ex) {
            // Manejo de la excepción
            ex.printStackTrace();
            return null; // O devuelve un objeto nulo, dependiendo de tus requisitos
        }
    }

    @Override
    public void editAboutMe(SobreMi sobreMi) {
        try {
            Usuario user = userRepo.findById((long) 151297).orElse(null);
            user.setSobreMi(sobreMi);
            userRepo.flush();
        } catch (Exception ex) {
            // Manejo de la excepción
            ex.printStackTrace();
            // Otros pasos de manejo de excepciones, como devolver una respuesta de error
        }
    }

    @Autowired
    public UserService uService;
    //! delete this method 
    @Override
    public void addSobreMi(SobreMi sobreMi) {
        Usuario user= uService.getUser((long) 151297);
        user.setSobreMi(sobreMi);
        sobreMi.setUsuario(user);
        uService.userRepo.flush();

        sobreMiRepository.save(sobreMi);
    }
    
}
