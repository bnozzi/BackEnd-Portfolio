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
        Usuario user = userRepo.findById((long) 151297).orElse(null);
        return user.getSobreMi();
    }

    @Override
    public void editAboutMe(SobreMi sobreMi) {
        Usuario user = userRepo.findById((long) 151297).orElse(null);
        user.setSobreMi(sobreMi);
        userRepo.flush();
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
