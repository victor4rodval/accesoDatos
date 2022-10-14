package EjerciciosOutputStream;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

/*Realiza el archivo add2022_23EscribeReales.java que:
        solicite un texto por teclado,
        compruebe que no existe un archivo con ruta igual al texto introducido,
        si existe muestra un mensaje y vuelve a pedir otra ruta,
        sólo continúa el programa si el texto no coincide con ningún objeto del sistema de archivos,
        a continuación crea un archivo con el nombre introducido por teclado,
        almacena en el archivo entre 1000 y 2000 números reales al azar.
        Al finalizar el programa se mostrará el tamaño del archivo creado y la cantidad de números almacenados.*/
public class numRealesAzar {
    public static void main(String[] args) throws IOException {

        System.out.println("Introduce el nombre para un archivo");
        Scanner sc = new Scanner(System.in);
        String ruta = sc.nextLine();
        File archivo = new File(ruta);
        while (archivo.exists()) {
            System.out.println("El archivo existe en el sistema de ficheros");
            System.out.println("Vuelve a introducir un nuevo nombre");
            ruta = sc.nextLine();
        }
        archivo.createNewFile();
        FileOutputStream fos = new FileOutputStream(archivo);
        DataOutputStream dos = new DataOutputStream(fos);
        int numAzar = 0;
        Random rnd = new Random();
        numAzar = rnd.nextInt(1000,2000);
        for (int i = 0; i < numAzar; i++) {
            dos.writeDouble(rnd.nextDouble());
        }
        dos.close();
        //El tamaño del archivo tiene que corresponderse con el valor de los double, que
        //ocupan cada uno 8 bits
        System.out.println("El tamaño del archivo: " + archivo.length());
        System.out.println("Se han escrito un total de "+numAzar+" números");

    }

    private static double numAzar(int num1, int num2) {
        //random.nextInt(max + min) + min;
        int numAzar = 0;
        Random rnd = new Random();
        return numAzar = rnd.nextInt(2000 + 1000) + 1000;
    }
}
