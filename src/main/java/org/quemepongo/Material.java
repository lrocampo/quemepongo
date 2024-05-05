package org.quemepongo;

public class Material {
  private String nombre;
  private Trama trama;

  public Material(String nombre, Trama trama) {
    this.nombre = nombre;
    this.trama = trama;
  }

  public Trama getTrama() {
    return trama;
  }

  public String getNombre() {
    return nombre;
  }
}
