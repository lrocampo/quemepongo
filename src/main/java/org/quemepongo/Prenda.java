package org.quemepongo;

import static java.util.Objects.requireNonNull;

public class Prenda {
  private Tipo tipoPrenda;
  private String material;
  private Color colorPrincipal;
  private Color colorSecundario;

  public Prenda(Tipo tipo, String material, Color colorPrincipal, Color colorSecundario) {
    this.tipoPrenda = requireNonNull(tipo, "tipo de prenda es obligatorio");
    this.material = requireNonNull(material, "material es obligatorio");
    this.colorPrincipal = requireNonNull(colorPrincipal, "color principal es obligatorio");
    this.colorSecundario = colorSecundario;
  }

  public Tipo getTipoPrenda() {
    return tipoPrenda;
  }

  public String getMaterial() {
    return material;
  }

  public Color getColorPrincipal() {
    return colorPrincipal;
  }

  public Color getColorSecundario() {
    return colorSecundario;
  }
}
