package org.quemepongo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

public class PrendaTest {

  @Test
  public void puedoSaberElTipoDeUnaPrenda() {
    assertEquals("ZAPATO", zapato().getTipoPrenda().toString());
  }

  @Test
  public void puedoSaberLaCategoriaDeUnaPrenda() {
    assertEquals("CALZADO", zapato().getTipoPrenda().getCategoria().toString());
  }

  @Test
  public void puedoSaberElMaterialDeUnaPrenda() {
    assertEquals("CUERO", zapato().getMaterial().toString());
  }

  @Test
  public void puedoSaberElColorPrincipalDeUnaPrenda() {
    assertEquals("Color{rojo=10, verde=10, azul=10}", zapato().getColorPrincipal().toString());
  }

  @Test
  public void puedoSaberElColorSecundarioDeUnaPrenda() {
    assertEquals("Color{rojo=20, verde=20, azul=20}", zapatoConColorOpcional().getColorSecundario().toString());
  }

  @Test
  public void puedoSaberLaTramaDeUnaPrenda() {
    assertEquals("LISA", zapato().getTrama().toString());
  }

  @Test
  public void noPuedeHaberUnaPrendaSinTipoYSinCategoria() {
    assertThrows(NullPointerException.class, () -> new Borrador(null).crearPrenda());
  }

  @Test
  public void noPuedeHaberUnaPrendaSinColorPrincipal() {
    assertThrows(NullPointerException.class, this::zapatoSinColorPrincipal);
  }

  @Test
  public void elColorSecundarioEsOpcional() {
    assertNull(zapato().getColorSecundario());
  }

  @Test
  public void laTramaNoEsObligatoriaYEsLisaPorDefecto() {
    assertEquals("LISA", zapato().getTrama().toString());
  }

  private Prenda zapato() {
    Borrador borrador = new Borrador(TipoPrenda.ZAPATO);
    borrador.especificarMaterial(Material.CUERO);
    borrador.especificarColorPrincipal(colorPrincipal());
    return borrador.crearPrenda();
  }
  
  private Prenda zapatoConColorOpcional() {
    Borrador borrador = new Borrador(TipoPrenda.ZAPATO);
    borrador.especificarMaterial(Material.CUERO);
    borrador.especificarColorPrincipal(colorPrincipal());
    borrador.especificarColorSecundario(colorSecundario());
    return borrador.crearPrenda();
  }

  private Prenda zapatoSinColorPrincipal() {
    Borrador borrador = new Borrador(TipoPrenda.ZAPATO);
    borrador.especificarMaterial(Material.CUERO);
    return borrador.crearPrenda();
  }
  
  private Color colorPrincipal() {
    return new Color(10, 10, 10);
  }
  
  private Color colorSecundario() {
    return new Color(20, 20, 20);
  }
}