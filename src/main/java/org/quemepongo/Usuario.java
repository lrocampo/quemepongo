package org.quemepongo;

import java.util.List;


public class Usuario {
  private List<Prenda> prendas;
  private MotorDeSugerencias motorDeSugerencias;
  private ServicioClima servicioClima;
  private Integer edad;

  public Usuario(List<Prenda> prendas, Integer edad, ServicioClima servicioClima, MotorDeSugerencias motorDeSugerencias) {
    this.prendas = prendas;
    this.edad = edad;
    this.servicioClima = servicioClima;
    this.motorDeSugerencias = motorDeSugerencias;
  }


  public void setMotorDeSugerencias(MotorDeSugerencias motorDeSugerencias) {
    this.motorDeSugerencias = motorDeSugerencias;
  }

  public boolean esMayor(Integer edad) {
    return this.edad > edad;
  }

  public List<Sugerencia> sugerencias() {
    Integer temperatura = servicioClima.temperaturaActual();
    return motorDeSugerencias.generarSugerencias(this, prendas).stream().filter(
        sugerencia -> sugerencia.esAptaTemperatura(temperatura)).toList();
  }

  public Sugerencia sugerencia() {
    Sugerencia sugerencia = motorDeSugerencias.generarSugerencia(this, prendas);
    if(sugerencia.esAptaTemperatura(servicioClima.temperaturaActual())) {
      return sugerencia;
    } else {
      throw new RuntimeException("No hay sugerencias aptas para la temperatura actual");
    }
  }
}
