package org.quemepongo;

public class Color {
  private int rojo;
  private int verde;
  private int azul;

  public Color(int rojo, int verde, int azul) {
    this.rojo = rojo;
    this.verde = verde;
    this.azul = azul;
  }

  @Override
  public String toString() {
    return "Color{" +
        "rojo=" + rojo +
        ", verde=" + verde +
        ", azul=" + azul +
        '}';
  }
}
