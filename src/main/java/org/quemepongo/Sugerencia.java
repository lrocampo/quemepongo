package org.quemepongo;

import java.util.stream.Stream;

public class Sugerencia {
  private Prenda superior;
  private Prenda inferior;
  private Prenda calzado;

  public Sugerencia(Prenda superior, Prenda inferior, Prenda calzado) {
    this.superior = superior;
    this.inferior = inferior;
    this.calzado = calzado;
  }

  public Prenda getSuperior() {
    return superior;
  }

  public Prenda getInferior() {
    return inferior;
  }

  public Prenda getCalzado() {
    return calzado;
  }

  public boolean esAptaTemperatura(Integer temperatura) {
    return Stream.of(superior, inferior, calzado)
        .allMatch(prenda -> prenda.esAptaTemperatura(temperatura));
  }
}
