package org.quemepongo;

import java.util.List;


public class Usuario {
  private List<Prenda> prendas;
  private MotorDeSugerencias motorDeSugerencias;
  private Integer edad;

  public Usuario(List<Prenda> prendas, Integer edad, MotorDeSugerencias motorDeSugerencias) {
    this.prendas = prendas;
    this.edad = edad;
    this.motorDeSugerencias = motorDeSugerencias;
  }


  public void setMotorDeSugerencias(MotorDeSugerencias motorDeSugerencias) {
    this.motorDeSugerencias = motorDeSugerencias;
  }

  public boolean esMayor(Integer edad) {
    return this.edad > edad;
  }

  public List<Sugerencia> sugerencias() {
    return motorDeSugerencias.generarSugerencias(this, prendas);
  }

  public Sugerencia sugerencia() {
    return motorDeSugerencias.generarSugerencia(this, prendas);
  }
}
