package org.quemepongo;

public enum TipoPrenda {
  ZAPATO(Categoria.CALZADO),
  CAMISA_MANGAS_CORTAS(Categoria.PARTE_SUPERIOR),
  PANTALON(Categoria.PARTE_INFERIOR);

  private final Categoria categoria;

  TipoPrenda(Categoria categoria) {
    this.categoria = categoria;
  }

  public Categoria getCategoria() {
    return categoria;
  }
}