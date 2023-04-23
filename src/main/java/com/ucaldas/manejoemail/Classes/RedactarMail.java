package com.ucaldas.manejoemail.Classes;

import java.util.Scanner;

import com.ucaldas.manejoemail.Models.Mensaje;
import com.ucaldas.manejoemail.Models.Usuario;

public class RedactarMail {
  private Usuario usuario;
  private Scanner scanner;

  public RedactarMail(Usuario usuario, Scanner scanner) {
    this.usuario = usuario;
    this.scanner = scanner;
  }

  public void redactarMensaje() {
    System.out.println("Ingrese los destinatarios (separados por ;): ");
    String[] destinatarios = scanner.nextLine().split(";");
    System.out.println("Ingrese el asunto: ");
    String asunto = scanner.nextLine();
    System.out.println("Ingrese el mensaje: ");
    String mensaje = scanner.nextLine();
    Integer idMessage = usuario.getBandejaEntrada().size() + 1;
    Mensaje nuevoMensaje = new Mensaje(idMessage, usuario.getUsuario(), destinatarios, asunto, mensaje);
    usuario.agregarMensaje(nuevoMensaje);
    System.out.println("Mensaje enviado exitosamente.");
  }
}
