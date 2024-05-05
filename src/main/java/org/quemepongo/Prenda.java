package org.quemepongo;

import static java.util.Objects.requireNonNull;

public class Prenda {
  Tipo tipoPrenda;
  String material;
  Color colorPrincipal;
  Color colorSecundario;

  public Prenda(Tipo tipo, String material, Color colorPrincipal, Color colorSecundario) {
    this.tipoPrenda = requireNonNull(tipo, "tipo de prenda es obligatorio");
    this.material = requireNonNull(material, "material es obligatorio");
    this.colorPrincipal = requireNonNull(colorPrincipal, "color principal es obligatorio");
    this.colorSecundario = colorSecundario;
  }
}
