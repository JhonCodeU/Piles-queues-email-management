/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.ucaldas.manejoemail;

import java.util.Scanner;

import com.ucaldas.manejoemail.Classes.IngresoMail;
import com.ucaldas.manejoemail.Classes.RedactarMail;
import com.ucaldas.manejoemail.Classes.RegistroEmail;
import com.ucaldas.manejoemail.Classes.RevisarBandejaEntrada;
import com.ucaldas.manejoemail.Models.Usuario;

/**
 *
 * System.out.println("Nombre: " + JhonUser.getNombre());
 * 
 * @author johnca
 */
public class ManejoEmail {

    public static void main(String[] args) {
        RegistroEmail registro = new RegistroEmail();
        Usuario usuario1 = new Usuario("Juan", "Pérez", "jperez", "jperez@ucaldas.edu.co", "password");
        Usuario usuario2 = new Usuario("María", "García", "mgarcia", "mgarcia@ucaldas.edu.co", "admin");
        registro.agregarUsuario(usuario1);
        registro.agregarUsuario(usuario2);

        Scanner scanner = new Scanner(System.in);
        IngresoMail ingresoMail = new IngresoMail(registro, scanner);
        Usuario usuarioAutenticado = ingresoMail.ingresarMail();

        if (usuarioAutenticado != null) {
            // Mostrar opciones para el usuario autenticado
            System.out.println("Opciones para el usuario autenticado:");
            System.out.println("1. Revisar bandeja de entrada");
            System.out.println("2. Redactar un correo");

            int opcion = leerEntero("Ingrese una opción: ", scanner);
            switch (opcion) {
                case 1:
                    RevisarBandejaEntrada revisarBandejaEntrada = new RevisarBandejaEntrada(usuarioAutenticado);
                    revisarBandejaEntrada.mostrarMensajes();
                    break;
                case 2:
                    System.out.println("Redactar correo");
                    // Aquí se puede crear la lógica para enviar un correo
                    RedactarMail redactarMail = new RedactarMail(usuarioAutenticado, scanner);
                    redactarMail.redactarMensaje();
                    // ver bandeja de entrada
                    RevisarBandejaEntrada revisarBandejaEntrada2 = new RevisarBandejaEntrada(usuarioAutenticado);
                    revisarBandejaEntrada2.mostrarMensajes();
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
        scanner.close();
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
