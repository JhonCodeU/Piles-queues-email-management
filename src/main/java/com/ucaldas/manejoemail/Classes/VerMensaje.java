package com.ucaldas.manejoemail.Classes;

import com.ucaldas.manejoemail.Models.Mensaje;

public class VerMensaje {

  public static void verMensaje(Mensaje mensaje) {
    System.out.println("***************************************");
    System.out.println("Id del Mensaje: " + mensaje.getId());
    System.out.println("De: " + mensaje.getRemitente());
    System.out.println("Para: " + String.join(",", mensaje.getDestinatarios()));
    System.out.println("Asunto: " + mensaje.getAsunto());
    System.out.println("Mensaje: " + mensaje.getMensaje());
    System.out.println("***************************************");
  }
}
