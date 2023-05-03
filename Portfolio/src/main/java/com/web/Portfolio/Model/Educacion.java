package com.web.Portfolio.Model;


import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

/**
 * Class Educacion
 */

@Getter @Setter
@Entity
public class Educacion {

  //
  // Fields
  //
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  
  @ManyToOne
  @JsonIgnore
  private Usuario usuario;
  
  private String titulo;
  private String imagen;
  private Date tiempoDesde;
  private Date tiempoHasta;
  private Boolean Actualmente;
  @Column(length = 1000)
  private String descripcion;
  
  //
  // Constructors
  //
  public Educacion () { };
  

}
