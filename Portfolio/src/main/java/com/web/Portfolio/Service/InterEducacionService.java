package com.web.Portfolio.Service;

import java.util.List;

import com.web.Portfolio.Model.Educacion;

public interface InterEducacionService {
    
    public List<Educacion> getAllEducations();

    public Educacion getEducation(long id);
    
    public void addEducation(Educacion educacion);   

    public void removeEducation(long id);

    public void updateEducation(long id, Educacion educacion);


}
