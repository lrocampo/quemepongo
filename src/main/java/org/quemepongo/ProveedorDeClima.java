package org.quemepongo;

public class ProveedorDeClima {
  static ServicioClima clima;

  public static ServicioClima getClima() {
    return clima;
  }

  public static void setClima(ServicioClima clima) {
    ProveedorDeClima.clima = clima;
  }
}
