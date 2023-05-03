package com.web.Portfolio.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.Portfolio.Model.RedSocial;
import com.web.Portfolio.Model.Usuario;
import com.web.Portfolio.Repository.RedSocialRepository;
import com.web.Portfolio.Repository.UserRepository;

@Service
public class RedSocialService implements InterRedSocialService {

    @Autowired
    public RedSocialRepository redSocialRepository;

    @Autowired
    public UserRepository userRepo;

    @Override
    public List<RedSocial> getSocialsNetworks() {
        return redSocialRepository.findAll();
    }

    @Override
    public RedSocial getRedSocial(long id) {
        return redSocialRepository.findById(id).orElse(null);
    }

    @Override
    public void addRedSocial(RedSocial redSocial) {
        Usuario user = userRepo.findById((long)151297).orElse(null);
        if (user != null) {
            user.getRedSocial().add(redSocial);
            redSocial.setUsuario(user);
            userRepo.flush();
            redSocialRepository.save(redSocial);
        }
    }

    @Override
    public void deleteRedSocial(long id) {
        redSocialRepository.deleteById(id);
    }


    @Override
    public void updateRedSocial(RedSocial redSocial) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateRedSocial'");
    }

}
