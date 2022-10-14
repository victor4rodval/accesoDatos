package EjerciciosOutputStream;

import java.io.*;
import java.util.Scanner;

/*Realiza el archivo add2022_24LeeReales.java que:
        solicite un nombre por teclado,
        compruebe que existe un archivo con ese nombre,
        si no existe da un mensaje y sale del programa
        si existe,
        muestra por pantalla, en el mismo número de filas y columnas, los números que contiene.*/
public class LeeReales {
    public static void main(String[] args) throws IOException {

        System.out.println("Introduce el nombre para un archivo");
        Scanner sc = new Scanner(System.in);
        String ruta = sc.nextLine();
        File archivo = new File(ruta);
        if (archivo.exists() && !archivo.isDirectory()) {
            FileInputStream fis = new FileInputStream(archivo);
            DataInputStream dis = new DataInputStream(fis);
            //mayor o igual porque son double y contienen 8 bits cada número (así lo interpreta Java)
            while (dis.available()>=8){
                double real = dis.readDouble();
                System.out.println(real+"\n");

            }
            fis.close();
            dis.close();
        }else{
            System.out.println("No existe el archivo. Se cerrará el programa");
        }

    }
}
