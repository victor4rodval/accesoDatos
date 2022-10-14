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
 * @author 6002285 Realiza el programa add2022_09.java (CopiaEstructuraArchivos) que realiza las siguientes operaciones:
 *
 * 1/-Solicita una ruta a un directorio del sistema de archivos, y no continúa el programa hasta que no se introduzca una ruta 
 * a un directorio existente 
 * 2/-Solicita otra ruta, y no continúa el programa hasta que no se introduzca una ruta que no exista 
 * dentro del sistema de archivos, 
 * 3/-Replica los nombres de todos los archivos contenidos en el primer directorio a un directorio con la ruta introducida en segundo lugar.
 */
public class Ejercicio9 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ruta, rutaCopia;
        File objtI, objtC;
        File[] listaObjt;
        do {
            System.out.println("Introduce la ruta deseada: ");
            ruta = sc.nextLine();
            objtI = new File(ruta);
            // Condiciones expuestas en el enunciado
        } while (!esValido(ruta) && !objtI.exists());
        do {
            System.out.println("Introduce una nueva ruta");
            rutaCopia = sc.nextLine();
            objtC = new File(rutaCopia);
        } while (!esValido(rutaCopia) && objtC.exists());
       //Array para almacenar objetos File del directorio ruta
        listaObjt= objtI.listFiles();
        //Creo el directorio en la ruta espeficada por el usuario
        objtC.mkdirs();
        
    }
    public void copiarArchivosDir(File [] listaObj){
        int contador=0;
        for (int i = 0; i < listaObj.length; i++) {
            if(listaObj[i].isDirectory()){
                contador++;
                listaObj[i].getAbsolutePath();
               
            }
        }
    }
}
