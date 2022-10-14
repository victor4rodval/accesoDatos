package EjerciciosFicherosFile;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * @author 6002285
 */
//Crea un programa Java que al ejecutarse solicita un texto al usuario, luego solicita si quiere crear un archivo o directorio. Si no existe
//un obbjeto con una ruta igual al texto recogidfo desde el teclado, el prgrama crea el objeto con el nombre indicado, y si existe, muestra un mensaje informativo.
public class Add2022_01 {

    public static void main(String[] args) throws IOException {

        String nombre = "";
        System.out.println("Introduce el texto deseado");
        Scanner sc = new Scanner(System.in);
        nombre = sc.nextLine();
        System.out.println("¿Quieres crear un archivo o directorio?");
        String respuesta = "";
        respuesta = sc.nextLine().toLowerCase();
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
}
//\ a esto lo denominamos back slash
//SOLUCION DE JORGE
//          Scanner sc = new Scanner(System.in);
//
//            System.out.println("Introduce nombre");
//        String nombre = sc.nextLine();
//            System.out.println("indica si es directorio o archivo");
//            String respuesta= sc.nextLine();
//            File obj= new File(nombre);
//            if(obj.exists()==false){
//               boolean res=respuesta.toLowerCase().equals("archivo")? obj.createNewFile():obj.mkdir();
//            }
//            else {
//                System.out.println("Está creado");
//            }
//    }
