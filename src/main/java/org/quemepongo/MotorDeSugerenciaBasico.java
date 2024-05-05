package org.quemepongo;


import java.util.List;

public class MotorDeSugerenciaBasico extends MotorDeSugerencias {

  @Override
  protected List<Prenda> prendasFiltradas(Usuario usuario, List<Prenda> prendas) {
    return prendas;
  }
}
