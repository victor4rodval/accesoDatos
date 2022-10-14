/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjerciciosFicherosFile;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author vic
 */
//Crea un programa java add2022_03.java a partir del programa add2022_01 anterior,
//que solicita nombre de archivo y tipo (archivo/directorio), y que en este caso se 
//asegure de que el nombre de archivo sólo tiene caracteres alfabéticos y/o números.
public class Ejercicio3_casa {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        File arc = null;
        File directorio = null;
        System.out.println("Introduce un nombre para el fichero");
        String nombre = sc.nextLine();
        int opcion = 0;
        do {
            System.out.println("Pulsa 1 para crear un directorio. Pulsa 2 para crear un archivo");
        } while (opcion == 1 || opcion == 2);
        opcion = sc.nextInt();

        switch (opcion) {
            case 1 -> {
                directorio = new File("/pruebasFicheros/" + nombre);
                if (!directorio.exists() && esValido(nombre)) {
                    directorio.mkdirs();
                    System.out.println("El directorio ha sido creado satisfactoriamente");
                } else {
                    System.out.println("¡El directorio ya existe o no cumple con los requerimientos");
                }
            }
            case 2 -> {
                arc = new File(nombre);
                if (!arc.exists() && esValido(nombre)) {
                    arc.createNewFile();
                    System.out.println("El archivo ha sido creado satisfactoriamente");
                } else {
                    System.out.println("No es posible crear el archivo");
                }
            }
            default ->
                throw new AssertionError();
        }
        sc.close();
    }

    //Método para comprobar que el nombre introducido cumple con los requisitos
    private static boolean esValido(String nombre) {
        //Expresiones regulares. Cualquier elemento que vaya entre corchete son los admitidos
        //Podemos poner [A-Z]+ para determinar que al menos tiene que haber un caracter
        boolean resultado = nombre != null && nombre.matches("^[a-zA-Z0-9]*$");
        return resultado;
    }
}
