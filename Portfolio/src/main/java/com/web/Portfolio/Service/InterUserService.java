package com.web.Portfolio.Service;


import com.web.Portfolio.Model.SobreMi;
import com.web.Portfolio.Model.Usuario;

public interface InterUserService {

    public Usuario getUser(Long id) ;

    public void addUser(Usuario user);

    public void addAboutUser(SobreMi sobreMi);
}
