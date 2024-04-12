package org.quemepongo;

public class Atuendo {
  Prenda parteSuperior;
  Prenda calzado;
  Prenda parteInferior;
  Prenda accesorio;

  public Atuendo(Prenda parteSuperior, Prenda calzado, Prenda parteInferior, Prenda accesorio) {
    this.validarCamposRequeridos(parteSuperior, calzado, parteInferior, accesorio);
    this.parteSuperior = parteSuperior;
    this.calzado = calzado;
    this.parteInferior = parteInferior;
    this.accesorio = accesorio;
  }

  private void validarCamposRequeridos(Prenda parteSuperior, Prenda calzado, Prenda parteInferior, Prenda accesorio) {
    if (parteSuperior == null) {
      throw new CampoRequeridoException("La parte superior es obligatoria");
    }
    if (parteInferior == null) {
      throw new CampoRequeridoException("La parte inferior es obligatoria");
    }
    if (calzado == null) {
      throw new CampoRequeridoException("El calzado es obligatorio");
    }
    if (accesorio == null) {
      throw new CampoRequeridoException("El accesorio es obligatorio");
    }
  }
}
