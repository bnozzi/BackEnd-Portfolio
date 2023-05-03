package com.web.Portfolio.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.Portfolio.Model.SobreMi;
import com.web.Portfolio.Model.Usuario;
import com.web.Portfolio.Repository.SobreMiRepository;
@Service
public class SobreMiService implements InterSobreMiService {

    @Autowired
    public SobreMiRepository sobreMiRepository;

    @Override
    public SobreMi getAboutMe(long id) {
        return sobreMiRepository.findById(id).orElse(null);
    }

    @Override
    public void editAboutMe(long id) {
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
