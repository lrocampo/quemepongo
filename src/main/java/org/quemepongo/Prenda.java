package org.quemepongo;

import static java.util.Objects.requireNonNull;

public class Prenda {
  private TipoPrenda tipoPrenda;
  private Material material;
  private Color colorPrincipal;
  private Color colorSecundario;
  private Trama trama;
  private Formalidad formalidad;

  public Prenda(TipoPrenda tipo, Material material, Color colorPrincipal, Color colorSecundario,
                Trama trama, Formalidad formalidad) {
    this.tipoPrenda = tipo;
    this.material = material;
    this.colorPrincipal = colorPrincipal;
    this.colorSecundario = colorSecundario;
    this.trama = trama;
    this.formalidad = formalidad;
  }

  public TipoPrenda getTipoPrenda() {
    return tipoPrenda;
  }

  public Material getMaterial() {
    return material;
  }

  public Color getColorPrincipal() {
    return colorPrincipal;
  }

  public Color getColorSecundario() {
    return colorSecundario;
  }

  public Trama getTrama() {
    return trama;
  }

  public boolean esSuperior() {
    return this.tipoPrenda.getCategoria() == Categoria.PARTE_SUPERIOR;
  }

  public boolean esInferior() {
    return this.tipoPrenda.getCategoria() == Categoria.PARTE_INFERIOR;
  }

  public boolean esCalzado() {
    return this.tipoPrenda.getCategoria() == Categoria.CALZADO;
  }

  public boolean esFormal() {
    return this.formalidad == Formalidad.FORMAL;
  }

  public boolean esInformal() {
    return this.formalidad == Formalidad.INFORMAL;
  }
}
