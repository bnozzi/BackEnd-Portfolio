package com.web.Portfolio.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.Portfolio.Model.Proyecto;

public interface ProyectoRepository extends JpaRepository<Proyecto,Long> {
    
}
