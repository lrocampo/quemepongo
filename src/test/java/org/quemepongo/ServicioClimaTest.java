package org.quemepongo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.quemepongo.api.AccuWeatherAPI;

public class ServicioClimaTest {
  @Test
  void soloObtengoSugerenciasAptasParaElClimaActual() {
    assertEquals(1, usuario().sugerencias().size());
  }

  private ServicioClima servicioClimaAccuWeather() {
    return new ServicioAccuWeather(12L,25,new AccuWeatherAPI(), LocalDateTime.now());
  }

  private Color color() {
    return new Color(10, 10, 10);
  }

  private Prenda unaParteSuperiorParaElFrio() {
    return new Borrador(TipoPrenda.REMERA_MANGAS_LARGAS)
        .especificarMaterial(Material.ALGODON)
        .especificarColorPrincipal(new Color(10,10,10))
        .especificarFormalidad(Formalidad.FORMAL)
        .crearPrenda();
  }

  private Prenda unaParteSuperior() {
    return new Borrador(TipoPrenda.CAMISA_MANGAS_CORTAS)
        .especificarMaterial(Material.ALGODON)
        .especificarColorPrincipal(new Color(10,10,10))
        .especificarFormalidad(Formalidad.FORMAL)
        .crearPrenda();
  }

  private Prenda unaParteInferior() {
    return new Borrador(TipoPrenda.PANTALON)
        .especificarMaterial(Material.ALGODON)
        .especificarColorPrincipal(color())
        .especificarFormalidad(Formalidad.FORMAL)
        .crearPrenda();
  }

  private Prenda unCalzado() {
    return new Borrador(TipoPrenda.ZAPATO)
        .especificarMaterial(Material.CUERO)
        .especificarColorPrincipal(color())
        .especificarFormalidad(Formalidad.FORMAL)
        .crearPrenda();
  }

  private List<Prenda> prendas() {
    return List.of(unaParteSuperior(),
        unaParteSuperiorParaElFrio(),
        unaParteInferior(),
        unCalzado());
  }

  private Usuario usuario() {
    return new Usuario(prendas(), 23, servicioClimaAccuWeather(), new MotorDeSugerenciaBasico());
  }
}
