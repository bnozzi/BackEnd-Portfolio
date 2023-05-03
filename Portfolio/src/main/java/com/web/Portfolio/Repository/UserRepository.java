package com.web.Portfolio.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.Portfolio.Model.Usuario;

public interface UserRepository extends JpaRepository<Usuario,Long> {
    
}
