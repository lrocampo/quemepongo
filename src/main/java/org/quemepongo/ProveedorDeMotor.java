package org.quemepongo;

public class ProveedorDeMotor {
  static MotorDeSugerencias motor;

  public static MotorDeSugerencias getMotor() {
    return motor;
  }

  public static void setMotor(MotorDeSugerencias motor) {
    ProveedorDeMotor.motor = motor;
    RepositorioUsuario.getInstancia()
        .todos().forEach((usuario) -> usuario.setMotorDeSugerencias(motor));
  }
}
