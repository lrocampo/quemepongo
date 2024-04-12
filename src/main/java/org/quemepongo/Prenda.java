package org.quemepongo;

public class Prenda {
  Tipo tipo;
  String material;
  Color colorPrincipal;
  Color colorSecundario;

  public Prenda(Tipo tipo, String material, Color colorPrincipal, Color colorSecundario) {
    validarCamposRequeridos(tipo, material, colorPrincipal);
    this.tipo = tipo;
    this.material = material;
    this.colorPrincipal = colorPrincipal;
    this.colorSecundario = colorSecundario;
  }

  private void validarCamposRequeridos(Tipo tipo, String material, Color colorPrincipal) {
    if (tipo == null) {
      throw new IllegalArgumentException("El tipo es obligatorio");
    }
    if (material == null) {
      throw new IllegalArgumentException("El material es obligatorio");
    }
    if (colorPrincipal == null) {
      throw new IllegalArgumentException("El color principal es obligatorio");
    }
  }
}
