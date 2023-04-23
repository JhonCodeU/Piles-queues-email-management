package com.ucaldas.manejoemail.Classes;

public class ListaEnlazadaDinamica<T> {
  private Nodo<T> primero;
  private Nodo<T> ultimo;
  private int tamano;

  public ListaEnlazadaDinamica() {
    this.primero = null;
    this.ultimo = null;
    this.tamano = 0;
  }

  public boolean estaVacia() {
    return this.primero == null;
  }

  public int tamano() {
    return this.tamano;
  }

  public void agregarAlInicio(T elemento) {
    Nodo<T> nuevo = new Nodo<>(elemento);
    if (estaVacia()) {
      this.primero = nuevo;
      this.ultimo = nuevo;
    } else {
      nuevo.siguiente = this.primero;
      this.primero = nuevo;
    }
    this.tamano++;
  }

  public void agregarAlFinal(T elemento) {
    Nodo<T> nuevo = new Nodo<>(elemento);
    if (estaVacia()) {
      this.primero = nuevo;
      this.ultimo = nuevo;
    } else {
      this.ultimo.siguiente = nuevo;
      this.ultimo = nuevo;
    }
    this.tamano++;
  }

  public T obtener(int indice) {
    if (indice < 0 || indice >= tamano) {
      throw new IndexOutOfBoundsException("Indice fuera de rango");
    }
    Nodo<T> actual = this.primero;
    int i = 0;
    while (i < indice) {
      actual = actual.siguiente;
      i++;
    }
    return actual.elemento;
  }

  public void insertarFinal(T dato) {
    Nodo<T> nuevoNodo = new Nodo<>(dato);
    if (estaVacia()) {
      primero = nuevoNodo;
      ultimo = nuevoNodo;
    } else {
      ultimo.siguiente = nuevoNodo;
      ultimo = nuevoNodo;
    }
    tamano++;
  }

  private static class Nodo<T> {
    private T elemento;
    private Nodo<T> siguiente;

    public Nodo(T elemento) {
      this.elemento = elemento;
      this.siguiente = null;
    }
  }
}
