package com.web.Portfolio.Service;

import java.util.List;

import com.web.Portfolio.Model.Experiencia;

public interface InterExperienciaService {
    
    public List<Experiencia> getExperiencias();

    public Experiencia getExperiencia(long idExperiencia);

    public void addExperiencia(Experiencia experiencia);

    public void removeExperiencia(long idExperiencia);

    public void updateExperiencia( long id, Experiencia experiencia);

}
