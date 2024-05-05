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
    assertEquals("Cuero", zapato().getMaterial().getNombre());
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
  public void noPuedeHaberUnaPrendaSinTipo() {
    assertThrows(NullPointerException.class, () -> new Prenda(null, cuero(), colorPrincipal(), null, null));
  }

  @Test
  public void noPuedeHaberUnaPrendaSinCategoria() {
    assertThrows(NullPointerException.class, () -> new Prenda(Tipo.ZAPATO, null, colorPrincipal(), null, null));
  }

  @Test
  public void noPuedeHaberUnaPrendaSinColorPrincipal() {
    assertThrows(NullPointerException.class, () -> new Prenda(Tipo.ZAPATO, cuero(), null, null, null));
  }

  @Test
  public void elColorSecundarioEsOpcional() {
    assertNull(zapato().getColorSecundario());
  }

  private Prenda zapato() {
    return new Prenda(Tipo.ZAPATO, cuero(), colorPrincipal(), null, Trama.LISA);
  }
  
  private Prenda zapatoConColorOpcional() {
    return new Prenda(Tipo.ZAPATO, cuero(), colorPrincipal(), colorSecundario(), null);
  }
  
  private Color colorPrincipal() {
    return new Color(10, 10, 10);
  }
  
  private Color colorSecundario() {
    return new Color(20, 20, 20);
  }

  private Material cuero() {
    return new Material("Cuero", Trama.LISA);
  }

}