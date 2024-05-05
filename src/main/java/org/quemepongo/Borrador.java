package org.quemepongo;

import static java.util.Objects.requireNonNull;

public class Borrador {
  private TipoPrenda tipoPrenda;
  private Material material;
  private Color colorPrincipal;
  private Color colorSecundario = null;
  private Trama trama = Trama.LISA;

  public Borrador(TipoPrenda tipoPrenda) {
    this.tipoPrenda = requireNonNull(tipoPrenda);
  }

  public void especificarMaterial(Material material) {
    this.validarMaterialConsistenteConTipoDePrenda(material);
    this.material = requireNonNull(material);
  }

  private void validarMaterialConsistenteConTipoDePrenda(Material material) {
    if(tipoPrenda == TipoPrenda.CAMISA_MANGAS_CORTAS && material == Material.CUERO) {
      throw new RuntimeException("El material es inconsistente");
    }
  }

  public void especificarTrama(Trama trama) {
    this.trama = trama != null ? trama : Trama.LISA;
  }

  public void especificarColorPrincipal(Color colorPrincipal) {
    this.colorPrincipal = requireNonNull(colorPrincipal);
  }

  public void especificarColorSecundario(Color colorSecundario) {
    this.colorSecundario = colorSecundario;
  }

  public Prenda crearPrenda() {
    requireNonNull(tipoPrenda);
    requireNonNull(material);
    requireNonNull(colorPrincipal);
    return new Prenda(tipoPrenda, material, colorPrincipal, colorSecundario, trama);
  }
}
