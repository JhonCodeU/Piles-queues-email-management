/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.ucaldas.manejoemail;

import java.util.Scanner;

import com.ucaldas.manejoemail.Classes.IngresoMail;
import com.ucaldas.manejoemail.Classes.RedactarMail;
import com.ucaldas.manejoemail.Classes.RegistroEmail;
import com.ucaldas.manejoemail.Classes.RevisarBandejaEntrada;
import com.ucaldas.manejoemail.Classes.VerMensaje;
import com.ucaldas.manejoemail.Models.Mensaje;
import com.ucaldas.manejoemail.Models.Usuario;

/**
 *
 * 
 * @author johnca
 */
public class ManejoEmail {

    public static void main(String[] args) {
        RegistroEmail registro = new RegistroEmail();
        Usuario usuario1 = new Usuario("Juan", "Pérez", "jperez", "jperez@ucaldas.edu.co", "password");
        Usuario usuario2 = new Usuario("María", "García", "mgarcia", "mgarcia@ucaldas.edu.co", "admin");
        Usuario usuario3 = new Usuario("Carlos", "Gómez", "cgomez", "carlos@ucaldas.edu.co", "1234");
        Usuario usuario4 = new Usuario("Valentina", "González", "vgonzalez", "vale@ucaldas.edu.co", "1234");
        registro.agregarUsuario(usuario1);
        registro.agregarUsuario(usuario2);
        registro.agregarUsuario(usuario3);
        registro.agregarUsuario(usuario4);

        Scanner scanner = new Scanner(System.in);
        IngresoMail ingresoMail = new IngresoMail(registro, scanner);
        Usuario usuarioAutenticado = ingresoMail.ingresarMail();

        if (usuarioAutenticado != null) {
            // Mostrar opciones para el usuario autenticado
            Boolean salir = false;
            while (!salir) {
                System.out.println();
                System.out.println("Opciones para el usuario autenticado:");
                System.out.println("1. Revisar bandeja de entrada");
                System.out.println("2. Redactar un correo");
                System.out.println("3. Ver mensaje");
                System.out.println("4. Salir");
                System.out.println();

                int opcion = leerEntero("Ingrese una opción: ", scanner);
                Menu(opcion, usuarioAutenticado, scanner);
                if (opcion == 4)
                    salir = true;
            }
        }
        scanner.close();
    }

    public static void Menu(Integer opcion, Usuario usuarioAutenticado, Scanner scanner) {

        System.out.println();

        switch (opcion) {
            case 1:
                // ver bandeja de entrada
                RevisarBandejaEntrada revisarBandejaEntrada = new RevisarBandejaEntrada(usuarioAutenticado);
                revisarBandejaEntrada.mostrarMensajes();
                break;
            case 2:
                System.out.println("Redactar correo");
                System.out.println();
                // Aquí se puede crear la lógica para enviar un correo
                RedactarMail redactarMail = new RedactarMail(usuarioAutenticado, scanner);
                redactarMail.redactarMensaje();
                break;
            case 3:
                // seleccionar mensaje
                RevisarBandejaEntrada revisarBandejaEntrada2 = new RevisarBandejaEntrada(usuarioAutenticado);
                int numeroMensaje = leerEntero("Ingrese el número del mensaje a ver: ", scanner);
                Mensaje mensaje = revisarBandejaEntrada2.seleccionarMensaje(numeroMensaje);
                // ver mensaje
                try {
                    revisarBandejaEntrada2.mostrarMensajes();
                    VerMensaje.verMensaje(mensaje);
                } catch (Exception e) {
                    System.out.println("No se encontró el mensaje con número " + numeroMensaje + ".");
                }
                break;
            case 4:
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }

    }

    public static int leerEntero(String mensaje, Scanner scanner) {
        int entero = 0;
        boolean entradaValida = false;
        while (!entradaValida) {
            System.out.print(mensaje);
            if (scanner.hasNextInt()) {
                entero = scanner.nextInt();
                entradaValida = true;
            } else {
                System.out.println("Entrada inválida. Por favor ingrese un número entero.");
                scanner.nextLine();
            }
        }
        return entero;
    }

}
