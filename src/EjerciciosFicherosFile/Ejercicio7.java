/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjerciciosFicherosFile;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author vic Modificar el programa add2022_05.java (Listado) para obtener el
 * programa add2022_07.java (ListadoRecursivo) que al ejecutarse muestra de
 * forma recursiva todos los archivos y directorios bajo un directorio
 * determinado.
 */
public class Ejercicio7 {

    public static void main(String[] args) {
        File[] ficheros;
        File archivo;
        System.out.println("Introduce el nombre de la ruta");
        Scanner sc = new Scanner(System.in);
        String ruta = sc.nextLine();
        archivo = new File(ruta);
        // 1-Comprobamos que la ruta existe
        if (archivo.getAbsoluteFile().exists() && esValido(ruta)) {
            System.out.println("La ruta existe y es " + archivo.getAbsolutePath());
            // 2- Comprobación de si el archivo es directorio
            if (archivo != null && archivo.isDirectory()) {
                System.out.println("La ruta apunta a un directorio\n");
                ficheros = archivo.listFiles();
                if (ficheros == null || ficheros.length == 0) {
                    System.out.println("No hay elementos en el directorio " + archivo.getName());
                } else {
                    // Primero mostramos de forma tabulada el nombre de los archivos
                    // mostrarArchivo(archivo);
                    System.out.println();
                    // Luego los directorios
                    mostrarDirectorio(archivo);
                }
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

    // Método para mostrar los directorios con su nombre en disposición de tabla
    private static void mostrarDirectorio(File archivo) {
        File[] ficheros = archivo.listFiles();
        mostrarArchivo(archivo);
        if (ficheros == null || ficheros.length == 0) {
            System.out.println("No hay elementos en el directorio " + archivo.getName());
            System.out.println();
        }
        if (ficheros != null && ficheros.length > 1) {
            for (int i = 0; i < ficheros.length; i++) {
                int contador = 0;
                if (ficheros[i].isDirectory()) {
                    System.out.printf("%16s\t%32s\n", "<<DIRECTORIO>>", ficheros[i].getName() + "\n");
                    mostrarDirectorio(ficheros[i]);
                }
            }
        }

    }

    // Método para listar los archivos con nombre y tamaño en disposición de tabla
    private static void mostrarArchivo(File archivo) {
        int contador = 0;
        File[] ficheros = archivo.listFiles();
        if (ficheros != null && ficheros.length > 0) {
            System.out.printf("%16s\t%32s\t %16s\t\n", "FICHERO", "NOMBRE", "TAMAÑO");
            System.out.printf("%16s\t%32s\t %16s\t\n", "-------", "------", "------");
            for (int i = 0; i < ficheros.length; i++) {
                if (ficheros[i].isFile()) {
                    contador++;
                    System.out.printf("%16s\t%32s\t %16s\t\n", "Archivo " + contador, ficheros[i].getName(),
                            ficheros[i].length() / 1024 + "KB\n");
                }
            }
        }
    }

    // Método para comprobar que la sintaxis de la url o archivo se corresponde con
    // los caracteres permitidos
    public static boolean esValido(String ruta) {
        boolean resultado = true;
        // Hay que incluir también el espacio para que reconozca carpetas con nombre
        // compuesto
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
