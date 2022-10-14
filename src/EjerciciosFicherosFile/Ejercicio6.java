/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjerciciosFicherosFile;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author vic 
 * Realiza el programa add2022_06.java que realiza las siguientes
 * operaciones:
 *
 * 1/- Solicita una ruta a un directorio del sistema de archivos. El prigrama no
 * continúa hasta que no se introduzca por teclado una ruta a un directorio
 * existente.
 *
 * 2/- Solicita una extensión de archivo, formada por tres o cuatro letras. No
 * continúa el programa hasta que no se introduzca una combinación de tres o
 * cuatro caracteres alfabéticos y/o números.
 *
 * 3/- Muestra de forma tabulada la siguiente información: nombre, tamaño en
 * bytes y ruta de todos los archivos que tienen la extensión introducida por
 * teclado y están contenidos en el directorio introducido.
 */
public class Ejercicio6 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String ruta;
        File fichero;
        File[] archivos;
        do {
            System.out.println("Introduce la ruta deseada: ");
            ruta = sc.nextLine();
            fichero = new File(ruta);
            // Condiciones expuestas en el enunciado
        } while (ruta == null && !esValido(ruta) && !fichero.exists());
        String extension;
        do {
            System.out.println("Introduce una extension de archivo (3 o 4 caracteres)");
            extension = sc.nextLine();
            // Comprobamos que la extensión tenga 3 o 4 caracteres y se corresponda con
            // letras
        } while (extension.length() > 4 || extension.length() < 3 && !comprobarExt(extension));

        // Guardamos los objetos File incluidos en el directorio de la ruta en un array
        // "archivos"
        archivos = fichero.listFiles();
        //Invoco al método diseñado para mostrar información de los archivos
        mostrarInfoArchivos(archivos, extension);

        sc.close();
    }

    public static boolean esValido(String ruta) {
        boolean resultado = true;
        // Hay que incluir también el espacio para que reconozca carpetas con nombre
        // compuesto
        return resultado = ruta.matches("[[a-zA-Z0-9]|[:/-_\\.\\\\ ]]+");
    }

    // Método para comprobar la integridad de la extensión de los archivos
    public static boolean comprobarExt(String cadena) {
        boolean resultado = true;
        resultado = cadena.matches("[a-zA-Z0-9]*");
        return resultado;
    }

    public static void mostrarInfoArchivos(File fichero[], String extension) {
        int contador = 0;
        // Diseño de las expresión regular a usar
        System.out.printf("%32s\t%16s\t %48s\t\n", "NOMBRE", "TAMAÑO", "RUTA");
        System.out.printf("%32s\t%16s\t %48s\t\n", "------", "------", "----");
        for (File file : fichero) {
            // Filtro archivos en el array y que coincida la extensión
            if (file.isFile() && (obtenerExt(file.getName()).endsWith(extension))) {
                System.out.printf("%32s\t%16s\t %48s\t\n", file.getName(), file.length() / 1024 + "KB",
                        file.getAbsoluteFile());
                         //getParentFile si quisiéramos mostrar el direcotorio padre del archivo
                        //file.getParentFile();
                contador++;
            }
        }
        System.out.println();
        if (contador == 0) {
            // caracteres Unicode para entrecomillar el valor de la variable extensión
            System.out
                    .println("El directorio no contiene archivos con la extensión " + '\u0022' + extension + '\u0022');
        }
    }

    // Método para mostrar la extensión del archivo
    public static String obtenerExt(String ruta) {
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
