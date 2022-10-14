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
 */
public class Ejercicio2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        File directorio = new File("/pruebasFicheros/DirContenedor");
        if (!directorio.exists()) {
            if (directorio.mkdirs()) {
                System.out.println("El directorio ha sido creado");
                int num = (int) (Math.random() * ((50 - 25) - 1) + 25);
                // System.out.println(num);
                System.out.println("Introduce el nombre para las carpetas");
                String nombre = sc.nextLine();

                for (int i = 0; i < num; i++) {
                    // Para agregar un padding de ceros a la izquierda del nombre de la carpeta
                    String ceros = String.format("%02d", i);
                    File carpeta = new File("/pruebasFicheros/DirContenedor/" + ceros + nombre);
                    carpeta.mkdirs();
                }
            } else {
                System.out.println("Directorio no creado.Revisa el problema");
            }
        } else {
            System.out.println("El directorio ya existe");
        }
        sc.close();
    }
}
