package com.web.Portfolio.Model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

/**
 * Class Experiencia
 */
@Getter @Setter
@Entity

public class Experiencia {

  //
  // Fields
  //
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  
  @ManyToOne
  private Usuario usuario;
  private String nombreEmpresa;
  private Date tiempoDesde;
  private Date tiempoHasta;
  private String detalle;
  private Boolean trabajoActual;
  
  //
  // Constructors
  //
  public Experiencia () { };
  
  //
  // Methods
  //


  
  //
  // Other methods
  //

}
