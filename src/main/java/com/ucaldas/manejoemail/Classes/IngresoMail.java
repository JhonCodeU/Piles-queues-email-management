package com.ucaldas.manejoemail.Classes;

import java.util.Scanner;

import com.ucaldas.manejoemail.Models.Usuario;

public class IngresoMail {
  private RegistroEmail registro;
  private Scanner scanner;

  public IngresoMail(RegistroEmail registro, Scanner scanner) {
    this.registro = registro;
    this.scanner = scanner;
  }

  public Usuario ingresarMail() {

    System.out.print("Ingrese usuario: ");
    String usuario = scanner.nextLine();

    System.out.print("Ingrese contraseña: ");
    String contrasena = scanner.nextLine();

    for (Usuario u : registro.getUsuarios()) {
      if (u.getUsuario().equals(usuario) && u.getContrasena().equals(contrasena)) {
        System.out.println("----------------------------------------------------------");
        System.out.println("Bienvenido, " + u.getNombre() + " " + u.getApellidos() + "!");
        System.out.println("----------------------------------------------------------");
        return u;
      }
    }
    System.out.println("Usuario o contraseña incorrectos.");
    return null;
  }
}
