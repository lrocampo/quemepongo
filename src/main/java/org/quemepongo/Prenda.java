package org.quemepongo;

import static java.util.Objects.requireNonNull;

public class Prenda {
  private Tipo tipoPrenda;
  private Material material;
  private Color colorPrincipal;
  private Color colorSecundario;
  private Trama trama;

  public Prenda(Tipo tipo, Material material, Color colorPrincipal, Color colorSecundario,
                Trama trama) {
    this.tipoPrenda = requireNonNull(tipo, "tipo de prenda es obligatorio");
    this.material = requireNonNull(material, "material es obligatorio");
    this.colorPrincipal = requireNonNull(colorPrincipal, "color principal es obligatorio");
    this.colorSecundario = colorSecundario;
    this.trama = trama;
  }

  public Tipo getTipoPrenda() {
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
}
