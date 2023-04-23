package com.ucaldas.manejoemail.Models;

public class Mensaje {
  private Integer id;
  private String remitente;
  private String[] destinatarios;
  private String asunto;
  private String mensaje;

  public Mensaje(Integer id, String remitente, String[] destinatarios, String asunto, String mensaje) {
    this.id = id;
    this.remitente = remitente;
    this.destinatarios = destinatarios;
    this.asunto = asunto;
    this.mensaje = mensaje;
  }

  public Integer getId() {
    return id;
  }

  public String getRemitente() {
    return remitente;
  }

  public String[] getDestinatarios() {
    return destinatarios;
  }

  public String getAsunto() {
    return asunto;
  }

  public String getMensaje() {
    return mensaje;
  }
}
