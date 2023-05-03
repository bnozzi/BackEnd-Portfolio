package com.web.Portfolio.Service;

import java.util.List;

import com.web.Portfolio.Model.Proyecto;

public interface InterProyectoService {

    public List<Proyecto> getAllProyects();

    public Proyecto getProyect(long id);

    public void addProyect(Proyecto proyect);

    public void deleteProyect(Long id);

    public void updateProyect(long id, Proyecto proyect);

}
