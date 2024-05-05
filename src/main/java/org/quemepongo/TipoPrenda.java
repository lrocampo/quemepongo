package org.quemepongo;

public enum TipoPrenda {
  ZAPATO(Categoria.CALZADO, 30),
  CAMISA_MANGAS_CORTAS(Categoria.PARTE_SUPERIOR, 40),
  PANTALON(Categoria.PARTE_INFERIOR, 30),
  REMERA_MANGAS_LARGAS(Categoria.PARTE_SUPERIOR, 20);

  private final Categoria categoria;
  private final Integer temperaturaMaxima;

  TipoPrenda(Categoria categoria, Integer temperaturaMaxima) {
    this.categoria = categoria;
    this.temperaturaMaxima = temperaturaMaxima;
  }

  public Categoria getCategoria() {
    return categoria;
  }

  public Integer getTemperaturaMaxima() {
    return temperaturaMaxima;
  }
}
