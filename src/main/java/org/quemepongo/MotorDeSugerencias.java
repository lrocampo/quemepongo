package org.quemepongo;

import com.google.common.collect.Lists;
import java.util.List;

public abstract class MotorDeSugerencias {
  protected abstract List<Prenda> prendasFiltradas(Usuario usuario, List<Prenda> prendas);

  protected List<Sugerencia> generarSugerencias(Usuario usuario, List<Prenda> prendas) {
    List<Prenda> superiores = prendasFiltradas(usuario, prendas).stream().filter(Prenda::esSuperior).toList();

    List<Prenda> inferiores = prendasFiltradas(usuario, prendas).stream().filter(Prenda::esInferior).toList();

    List<Prenda> calzados = prendasFiltradas(usuario, prendas).stream().filter(Prenda::esCalzado).toList();

    List<List<Prenda>> combinaciones = Lists.cartesianProduct(superiores, inferiores, calzados);

    return combinaciones.stream().map(
            (tupla) -> new Sugerencia(tupla.get(0), tupla.get(1), tupla.get(2)))
        .toList();
  }

  public Sugerencia generarSugerencia(Usuario usuario, List<Prenda> prendas) {
    return generarSugerencias(usuario, prendas).stream().findAny().
        orElseThrow(() -> new RuntimeException("No hay prendas suficientes para generar una sugerencia"));
  }
}
