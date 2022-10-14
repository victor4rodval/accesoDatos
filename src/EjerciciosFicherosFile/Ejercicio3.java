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
 * @author 6002285
 */
//Crea un programa java add2021_03.java a partir del programa add2021_01 anterior, que solicita nombre
//de archivo y tipo (archivo/directorio), y que en este caso se asegure de que el nombre de archivo sólo
//tiene caracteres alfabéticos y/o números.
public class Ejercicio3 {

    public static void main(String[] args) throws IOException {
        String nombre = "";
        System.out.println("Introduce el texto deseado");
        Scanner sc = new Scanner(System.in);
        nombre = sc.nextLine();
        System.out.println("¿Quieres crear un archivo o directorio?");
        String respuesta = sc.nextLine().toLowerCase();
        for (int i = 0; i < 10; i++) {
            
        }
        File objt = new File(nombre);
        if (respuesta.equalsIgnoreCase("archivo")) {
            if (!objt.exists()) {
                objt.createNewFile();
                System.out.println("El archivo ha sido creado");
            } else {
                System.out.println("El archivo ya existe");
            }
            if (respuesta.equalsIgnoreCase("directorio")) {
                if (!objt.exists()) {
                    objt.mkdir();
                    System.out.println("Has creado el directorio");
                } else {
                    System.out.println("El directorio ha sido creado");
                }
            }
        }
    }
    
    private static boolean esValido (String nombre){
        boolean resultado=false;
        resultado=nombre.matches(nombre);
        return resultado;
    }
}
