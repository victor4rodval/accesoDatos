package EjerciciosFicherosFile;


import java.io.File;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 6002285
 */
//Crea un programa java add2022_02.java que al ejecutarse crea carpetas, un número al azar entre 25 y 50, dentro de un directorio
//de nombre DirContenedor. El programa solicita una entrada por teclado, y el nombre de cada carpeta estará formado por 
//el texto recogido por teclado añadiendo un número con dos cifras desde el 00 en adelante.

public class Add2022_02 {
   
    public static void main(String[] args) {
        String nombre = "DirContenedor";
        File objt = new File(nombre);
        int carpetas =0;
        carpetas = (int) (Math.random()*((50-25)+1)+25);
        for (int i = 0; i < carpetas; i++) {
            objt.mkdir();
        }
                
        
        
    }

}
