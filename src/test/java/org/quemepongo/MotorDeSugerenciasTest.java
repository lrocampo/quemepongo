package org.quemepongo;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.quemepongo.api.AccuWeatherAPI;

public class MotorDeSugerenciasTest {
  @Test
  void deberiaGenerarTodasLasSugerenciasPosibles() {
    Usuario usuario = new Usuario(prendas(), 23, servicioClimaAccuWeather(), new MotorDeSugerenciaBasico());
    assertEquals(8, usuario.sugerencias().size());
  }

  @Test
  void noDeberiaGenerarTodasLasSugerencias() {
    Usuario usuario = new Usuario(pocasPrendas(), 23, servicioClimaAccuWeather(), new MotorDeSugerenciaBasico());
    assertEquals(0, usuario.sugerencias().size());
  }

  @Test
  void deberiaGenerarUnaSugerencia() {
    Usuario usuario = new Usuario(prendas(), 23, servicioClimaAccuWeather(), new MotorDeSugerenciaBasico());
    assertDoesNotThrow(usuario::sugerencia);
  }

  @Test
  void noDeberiaGenerarUnaSugerencia() {
    Usuario usuario = new Usuario(pocasPrendas(), 23, servicioClimaAccuWeather(), new MotorDeSugerenciaBasico());
    assertThrows(RuntimeException.class, usuario::sugerencia);
  }

  @Test
  void deberiaGenerarTodasLasSugerenciasPosiblesSiendoViejo() {
    Usuario usuario = new Usuario(prendas(), 56, servicioClimaAccuWeather(), new MotorDeSugerenciasFormal());
    assertEquals(1, usuario.sugerencias().size());
  }

  @Test
  void deberiaGenerarTodasLasSugerenciasPosiblesSiendoNoTanViejo() {
    Usuario usuario = new Usuario(prendas(), 55, servicioClimaAccuWeather(), new MotorDeSugerenciasFormal());
    assertEquals(8, usuario.sugerencias().size());
  }

  private Prenda unaParteSuperior(Formalidad formalidad) {
    return new Borrador(TipoPrenda.CAMISA_MANGAS_CORTAS)
        .especificarMaterial(Material.ALGODON)
        .especificarColorPrincipal(new Color(10, 10, 10))
        .especificarFormalidad(formalidad)
        .crearPrenda();
  }

  private Prenda unaParteInferior(Formalidad formalidad) {
    return new Borrador(TipoPrenda.PANTALON)
        .especificarMaterial(Material.ALGODON)
        .especificarColorPrincipal(color())
        .especificarFormalidad(formalidad)
        .crearPrenda();
  }

  private Prenda unCalzado(Formalidad formalidad) {
    return new Borrador(TipoPrenda.ZAPATO)
        .especificarMaterial(Material.CUERO)
        .especificarColorPrincipal(color())
        .especificarFormalidad(formalidad)
        .crearPrenda();
  }

  private Color color() {
    return new Color(10, 10, 10);
  }

  private List<Prenda> prendas() {
    return List.of(unaParteSuperior(Formalidad.FORMAL),
        unaParteInferior(Formalidad.FORMAL),
        unCalzado(Formalidad.FORMAL),
        unaParteSuperior(Formalidad.NEUTRA),
        unaParteInferior(Formalidad.NEUTRA),
        unCalzado(Formalidad.NEUTRA));
  }

  private List<Prenda> pocasPrendas() {
    return List.of(unaParteSuperior(Formalidad.INFORMAL),
        unaParteInferior(Formalidad.INFORMAL));
  }

  private ServicioClima servicioClimaAccuWeather() {
    return new ServicioAccuWeather(12L,25,new AccuWeatherAPI(), LocalDateTime.now());
  }
}
