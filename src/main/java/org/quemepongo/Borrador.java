package org.quemepongo;

import static java.util.Objects.requireNonNull;

public class Borrador {
  private TipoPrenda tipoPrenda;
  private Material material;
  private Color colorPrincipal;
  private Color colorSecundario = null;
  private Trama trama = Trama.LISA;
  private Formalidad formalidad;

  public Borrador(TipoPrenda tipoPrenda) {
    this.tipoPrenda = requireNonNull(tipoPrenda);
  }

  public Borrador especificarMaterial(Material material) {
    this.validarMaterialConsistenteConTipoDePrenda(material);
    this.material = requireNonNull(material);
    return this;
  }

  private void validarMaterialConsistenteConTipoDePrenda(Material material) {
    if(tipoPrenda == TipoPrenda.CAMISA_MANGAS_CORTAS && material == Material.CUERO) {
      throw new RuntimeException("El material es inconsistente");
    }
  }

  public Borrador especificarTrama(Trama trama) {
    this.trama = trama != null ? trama : Trama.LISA;
    return this;
  }

  public Borrador especificarColorPrincipal(Color colorPrincipal) {
    this.colorPrincipal = requireNonNull(colorPrincipal);
    return this;
  }

  public Borrador especificarColorSecundario(Color colorSecundario) {
    this.colorSecundario = colorSecundario;
    return this;
  }

  public Borrador especificarFormalidad(Formalidad formalidad) {
    this.formalidad = formalidad;
    return this;
  }

  public Prenda crearPrenda() {
    requireNonNull(tipoPrenda);
    requireNonNull(material);
    requireNonNull(colorPrincipal);
    return new Prenda(tipoPrenda, material, colorPrincipal, colorSecundario, trama, formalidad);
  }
}
