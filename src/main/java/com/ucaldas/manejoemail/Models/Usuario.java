package com.ucaldas.manejoemail.Models;

import java.util.Stack;

public class Usuario {
  private String nombre;
  private String apellidos;
  private String codigo;
  private String usuarioEmail;
  private String contrasena;
  private Stack<Mensaje> bandejaEntrada; // agregamos la lista de mensajes

  public Usuario(String nombre, String apellidos, String codigo, String emailUcaldas, String contrasena) {
    this.nombre = nombre;
    this.apellidos = apellidos;
    this.codigo = codigo;
    this.usuarioEmail = emailUcaldas;
    this.contrasena = contrasena;
    this.bandejaEntrada = new Stack<>(); // inicializamos la lista de mensajes
  }

  public boolean verificarUsuarioEmail() {
    // Verificar si el correo es de la universidad de caldas
    // Debe tener el dominio @ucaldas.edu.co
    if (usuarioEmail.contains("@ucaldas.edu.co")) {
      return true;
    } else {
      return false;
    }
  }

  // Getters y setters de los atributos
  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellidos() {
    return apellidos;
  }

  public void setApellidos(String apellidos) {
    this.apellidos = apellidos;
  }

  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  public String getUsuario() {
    return usuarioEmail;
  }

  public void setUsuario(String usuario) {
    this.usuarioEmail = usuario;
  }

  public String getContrasena() {
    return contrasena;
  }

  public void setContrasena(String contrasena) {
    this.contrasena = contrasena;
  }

  // método para agregar mensajes a la bandeja de entrada
  public void agregarMensaje(Mensaje mensaje) {
    bandejaEntrada.push(mensaje);
  }

  // método para obtener la bandeja de entrada
  public Stack<Mensaje> getBandejaEntrada() {
    return bandejaEntrada;
  }

  // método para obtener el número de mensajes en la bandeja de entrada
  public int getNumeroMensajes() {
    return bandejaEntrada.size();
  }
}
