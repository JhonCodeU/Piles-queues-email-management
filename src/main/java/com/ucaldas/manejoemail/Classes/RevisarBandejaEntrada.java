package com.ucaldas.manejoemail.Classes;

import java.util.Stack;

import com.ucaldas.manejoemail.Models.Mensaje;
import com.ucaldas.manejoemail.Models.Usuario;

public class RevisarBandejaEntrada {
  private Usuario usuario;

  public RevisarBandejaEntrada(Usuario usuario) {
    this.usuario = usuario;
  }

  public void mostrarMensajes() {
    Stack<Mensaje> pilaMensajes = usuario.getBandejaEntrada();
    System.out.println("Mensajes en bandeja de entrada:");
    if (pilaMensajes.empty()) {
      System.out.println("No hay mensajes en la bandeja de entrada.");
    } else {
      for (Mensaje mensaje : pilaMensajes) {
        System.out.println(mensaje.getId() + ": " + mensaje.getRemitente() + " - " + mensaje.getAsunto());
      }
    }
  }

  public Mensaje seleccionarMensaje(int numeroMensaje) {
    Stack<Mensaje> pilaMensajes = usuario.getBandejaEntrada();
    if (pilaMensajes.empty()) {
      System.out.println("No hay mensajes en la bandeja de entrada.");
      return null;
    } else {
      for (Mensaje mensaje : pilaMensajes) {
        if (mensaje.getId() == numeroMensaje) {
          return mensaje;
        }
      }
      System.out.println("No se encontró el mensaje con número " + numeroMensaje + ".");
      return null;
    }
  }
}
