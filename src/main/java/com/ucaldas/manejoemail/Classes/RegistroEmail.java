package com.ucaldas.manejoemail.Classes;

import java.util.LinkedList;
import com.ucaldas.manejoemail.Models.Usuario;

public class RegistroEmail {
  private LinkedList<Usuario> usuarios;

  public RegistroEmail() {
    usuarios = new LinkedList<>();
  }

  public LinkedList<Usuario> getUsuarios() {
    return usuarios;
  }

  public void agregarUsuario(Usuario usuario) {
    if (!existeUsuario(usuario.getUsuario())) {
      usuarios.offer(usuario);
      System.out.println("Usuario agregado a la lista.");
    } else {
      System.out.println("El usuario ya existe en la lista.");
    }
  }

  private boolean existeUsuario(String usuario) {
    for (Usuario u : usuarios) {
      if (u.getUsuario().equals(usuario)) {
        return true;
      }
    }
    return false;
  }
}
