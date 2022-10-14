
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjerciciosFicherosFile;

import java.io.File;
import java.util.Scanner;

import java.util.Scanner;

import java.io.File;
import java.util.List;

/**
 *
 * @author vic 
 * Crea un programa java add2022_05.java que realice las siguientes
 * operaciones: 
 * 1/-Pedir al usuario una entrada por teclado (ruta).
 *
 * Indicar al usuario: 
 * 2/- Si existe una ruta en el sistema que coincida con la
 * entrada recogida por teclado. Si no existe el programa finaliza.
 *
 * 3/- Si la ruta corresponde a un archivo o a un directorio.
 *
 * 4/- Si la ruta corresponde a un directorio, mostrar por pantalla, de forma
 * tabulada (estilo tabla), la lista de objetos contenidos en el directorio,
 * mostrando primero los archivos y luego los directorios.
 *
 * 5/- Para los directorios mostrar de forma tabulada la palabra directorio y
 * luego el nombre del directorio. Para los archivos, de forma tabulada la
 * palabra archivo, el nombre, la extensión y el tamaño en bytes de cada uno. Si
 * la cadena recogida por teclado es la ruta a un archivo, mostrar por pantalla
 * de forma tabulada el nombre, la extensión y el tamaño en bytes del archivo.
 */
public class Ejercicio5 {

    public static void main(String[] args) {
        File[] ficheros = null;
        File archivo = null;
        System.out.println("Introduce el nombre de la ruta");
        Scanner sc = new Scanner(System.in);
        String ruta = sc.nextLine();
        archivo = new File(ruta);
        // 1-Comprobamos que la ruta existe
        if (archivo.getAbsoluteFile().exists() && esValido(ruta)) {
            System.out.println("La ruta existe y es " + archivo.getAbsolutePath());
            //2- Comprobación de si el archivo es directorio
            if (archivo != null && archivo.isDirectory()) {
                System.out.println("La ruta apunta a un directorio\n");
                ficheros = archivo.listFiles();
                if (ficheros == null || ficheros.length == 0) {
                    System.out.println("No hay elementos en el directorio " + archivo.getName());
                }
                System.out.println("========================");
                System.out.println("= LISTADO DE FICHEROS: =");
                System.out.println("========================");
                System.out.println();
                // Primero mostramos de forma tabulada el nombre de los archivos
                mostrarArchivo(ficheros);
                System.out.println();
                // Luego los directorios
                mostrarDirectorio(ficheros);

            }
            // 2-Comprobación de si es un archivo y mostrar su ruta
            if (archivo != null && archivo.isFile()) {
                System.out.println("La ruta se corresponde con un archivo y es " + archivo.getAbsolutePath());
            }
            // 1- Opción con la que finaliza el programa si no existe ruta válida
        } else {
            System.out.println("La ruta no existe");

            sc.close();
        }
    }

    //Método para mostrar los directorios con su nombre en disposición de tabla
    private static void mostrarDirectorio(File[] ficheros) {
        for (int i = 0; i < ficheros.length; i++) {
            if (ficheros[i].isDirectory()) {
                System.out.printf("%16s\t%32s\n", "Directorio", ficheros[i].getName());
            }
        }
    }

    //Método para listar los archivos con nombre y tamaño en disposición de tabla
    private static void mostrarArchivo(File[] ficheros) {
        System.out.printf("%16s\t%32s\t %16s\t\n", "TIPO", "NOMBRE", "TAMAÑO");
        System.out.printf("%16s\t%32s\t %16s\t\n", "----", "------", "------");
        for (int i = 0; i < ficheros.length; i++) {
            if (ficheros[i].isFile()) {
                System.out.printf("%16s\t%32s\t %16s\t\n", "Archivo", ficheros[i].getName(), ficheros[i].length() / 1024 + "KB");
            }
        }
    }

    // Método para comprobar que la sintaxis de la url o archivo se corresponde con
    // los caracteres permitidos
    public static boolean esValido(String ruta) {
        boolean resultado = true;
        //Hay que incluir también el espacio para que reconozca carpetas con nombre compuesto
        return resultado = ruta.matches("[[a-zA-Z0-9]|[:/-_\\.\\\\ ]]+");
    }

    // Método para mostrar la extensión del archivo
    private static String obtenerExtension(String ruta) {
        int indicePunto = ruta.lastIndexOf('.');
        String extension = "";
        if (indicePunto > 0) {
            extension = ruta.substring(ruta.lastIndexOf('.'));
            if (extension.length() > 8) {
                return "sin_extension";
            } else {
                return extension;
            }
        } else {
            return "sin_extension";
        }
    }
}
