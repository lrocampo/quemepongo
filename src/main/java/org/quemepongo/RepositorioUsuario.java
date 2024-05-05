package org.quemepongo;

import java.util.ArrayList;
import java.util.List;

public class RepositorioUsuario {
  private List<Usuario> usuarios = new ArrayList<>();
  private static final RepositorioUsuario instancia = new RepositorioUsuario();

  private RepositorioUsuario() {

  }

  public static RepositorioUsuario getInstancia() {
    return instancia;
  }

  public void agregarUsuario(Usuario usuario) {
    usuarios.add(usuario);
  }

  public void removerUsuario(Usuario usuario) {
    usuarios.remove(usuario);
  }

  public List<Usuario> todos() {
    return usuarios;
  }
}
