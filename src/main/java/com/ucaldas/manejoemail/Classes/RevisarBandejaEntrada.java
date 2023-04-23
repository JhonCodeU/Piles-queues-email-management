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
      int i = 1;
      for (Mensaje mensaje : pilaMensajes) {
        System.out.println(i + ". " + mensaje.getRemitente() + " - " + mensaje.getAsunto());
        i++;
      }
    }
  }

  public Mensaje seleccionarMensaje(int numeroMensaje) {
    Stack<Mensaje> pilaMensajes = usuario.getBandejaEntrada();
    if (pilaMensajes.empty()) {
      System.out.println("No hay mensajes en la bandeja de entrada.");
      return null;
    } else {
      int i = 1;
      for (Mensaje mensaje : pilaMensajes) {
        if (i == numeroMensaje) {
          return mensaje;
        }
        i++;
      }
      System.out.println("No se encontró el mensaje con número " + numeroMensaje + ".");
      return null;
    }
  }
}
