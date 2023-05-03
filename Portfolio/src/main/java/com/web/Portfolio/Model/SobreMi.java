
package com.web.Portfolio.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

/**
 * Class SobreMi
 */
@Getter
@Setter
@Entity

public class SobreMi {

  //
  // Fields
  //
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  
  
  @OneToOne(mappedBy = "sobreMi")
  @JsonIgnore
  private Usuario usuario;

  private String imagenPerfil;
  private String bannerImagen;
  @Column(length = 1000)
  private String descripcion;

  //
  // Constructors
  //
  public SobreMi() {
  };

  //
  // Methods
  //

  //
  // Accessor methods
  //

  // Other methods
  //

}
