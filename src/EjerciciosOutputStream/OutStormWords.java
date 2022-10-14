package EjerciciosOutputStream;//Realiza el archivo OutStrmWords.java:
//	solicita una entrada al usuario,
//	comprueba que el texto introducido es un archivo que no existe, si no, el programa acaba con un mensaje informativo,
//	crea un archivo nuevo y vacío con ese nombre,
//
//	introduce en el archivo un conjunto de palabras al azar, en número mayor de 1000 y menor de 2000,
//	formadas por caracteres alfabéticos al azar, el número de caracteres será al azar entre 10 y 20,
//	separadas por el carácter

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.io.*;
import java.lang.invoke.MethodHandles;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class OutStormWords {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la ruta");
        String ruta = sc.nextLine();
        File archivo = new File(ruta);
        if (!archivo.exists()) {
            FileOutputStream archivoFOS = new FileOutputStream(archivo);
            for (int i = 0; i < aleatorios(1000, 2001); i++) {
                String palabraAzar = palabraAzar();
                palabraAzar = palabraAzar + " ";
                byte[] arrayChar = palabraAzar.getBytes();
                archivoFOS.write(arrayChar);
            }
            System.out.println("Archivo creado con éxito");
            FileInputStream archivoIn = new FileInputStream(archivo);
            InputStreamReader osw = new InputStreamReader(archivoIn);
            BufferedReader br = new BufferedReader(osw);
            //ready devuelve booleano que indica si el lector está listo
            while(br.ready()){
                String linea= br.readLine();
                System.out.println();
                System.out.println(linea+"\n");
            }

        } else {
            System.out.println("El archivo existe");

        }
    }

    private static int aleatorios(int num1, int num2) {
        Random aleatorio = new Random();
        int numAleatorio;
        return numAleatorio = aleatorio.nextInt(num1, num2);
    }

    private static String palabraAzar() {
        String frase = " ";
        int letras = aleatorios(10, 21);
        int caracter = 0;
        for (int i = 0; i < letras; i++) {
            caracter = aleatorios(65, 91);
            frase += (char) caracter;
        }

        return frase;
    }
}