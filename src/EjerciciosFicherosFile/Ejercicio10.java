/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjerciciosFicherosFile;

import java.io.File;
import java.util.Scanner;

import static EjerciciosFicherosFile.Ejercicio6.esValido;

/**
 *
 * @author 6002285
 * 
 * Realiza el programa add2022_10.java (BorraTodo.java) que solicite un texto por teclado. 
 *  1/-Si el texto coincide con el nombre de un archivo del sistema de archivos, 
 * el programa muestra un mensaje de advertencia indicando que se va a eliminar el archivo, y solicita permiso (S/N) 
 * al usuario para eliminarlo, 
 * si el texto coincide con el nombre de un directorio del sistema de archivos, 
 * el programa muestra un mensaje de advertencia indicando que se van a eliminar todos los archivos (y carpetas vacías) bajo el directorio, 
 * y vuelve a pedir permiso (S/N) al usuario para eliminarlos.

 */
public class Ejercicio10 {
    public static void main(String[] args) {
        File objtA = null;
        String ruta;
        char confirma;
        do {            
            System.out.println("Introduce un nombre");
            Scanner sc = new Scanner(System.in);
            ruta = sc.nextLine();
            //Método importado que comprueba nombre por medio de las 
        } while (!esValido(ruta));
        
        objtA.listFiles();
        
    }
   
    
}
