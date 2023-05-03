
package com.web.Portfolio.Model;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;

/**
 * Class Proyecto
 */
@Getter
@Setter
@Entity

public class Proyecto {

  //
  // Fields
  //
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  
  @ManyToOne
  @JsonIgnore
  private Usuario usuario;
  private String imagenProyecto;
  private String titulo;
  @Column(length = 5000)
  private String descripcion;
  private List<String> tecnologias;
  private String url;
  private String urlRepositorio;

  //
  // Constructors
  //
  public Proyecto() {
  };

  

}
