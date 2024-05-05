package org.quemepongo;

import java.util.List;

public class MotorDeSugerenciasFormal extends MotorDeSugerencias {

  @Override
  protected List<Prenda> prendasFiltradas(Usuario usuario, List<Prenda> prendas) {
    return usuario.esMayor(55) ? prendas.stream().filter(Prenda::esFormal).toList() : prendas;
  }
}
