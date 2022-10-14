package EjerciciosOutputStream;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class CopiaContenidoArchivo {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la ruta ");
        String ruta = sc.nextLine();//objeto para archivo
        File obj = new File(ruta);//comprobar ruta
        while (nombreValido(ruta) || !obj.exists() || obj.length() == 0) {//comprueba si es directorio y si existe
            System.out.println("tiene algun caracter no valido, introduce de nuevo, o no existe o esta vacio");
            ruta = sc.nextLine();
            obj = new File(ruta);
        }

        System.out.println("A qué quieres transformar?\n 1->caracteres\n 2->enteros\n 3->hexadecimal\n 4->octal\n 5->binario");
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                System.out.println("Has escogido caracteres");
                transCaracter(obj);
                break;

            case 2:
                System.out.println("Has escogido enteros");
                transentero(obj);

                break;

            case 3:
                System.out.println("Has escogido hexadecimal");
                transhexadecimal(obj);

                break;

            case 4:
                System.out.println("Has escogido octal");
                transoctal(obj);
                break;

            case 5:
                System.out.println("Has escogido binario");
                transbinario(obj);
                break;

        }

    }

    private static boolean nombreValido(String nombre) {
//comprobar ruta

        return (nombre.matches("[[a-zA-z0-9]|[-_\\.\\\\/]]+"));

    }

    public static void transCaracter(File obj) throws FileNotFoundException, IOException {
        FileInputStream instr = new FileInputStream(obj);
        int punto = obj.getAbsolutePath().lastIndexOf(".");

        File copiaobj = new File(obj.getAbsolutePath().substring(0, punto) + "_caracter.txt");
        copiaobj.createNewFile();
        FileOutputStream outstr = new FileOutputStream(copiaobj);
        byte[] byteobj = instr.readAllBytes();


        outstr.write(byteobj);
        instr.close();
        outstr.close();

    }

    public static void transentero(File obj) throws FileNotFoundException, IOException {
        FileInputStream instr = new FileInputStream(obj);
        int punto = obj.getAbsolutePath().lastIndexOf(".");

        File copiaobj = new File(obj.getAbsolutePath().substring(0, punto) + "_entero.txt");
        copiaobj.createNewFile();
        FileOutputStream outstr = new FileOutputStream(copiaobj);
        byte[] byteobj = instr.readAllBytes();//recojo todos los bytes del archivo
        String prueba = "";
        for (byte b : byteobj) {//los recorro
            int numerobyte = (int) b;//lo casteo a int
            prueba = prueba + String.valueOf(numerobyte) + " ";

        }

        byte bytesint[] = prueba.getBytes();//paso a bytes la cadena obtenida

        outstr.write(bytesint);

        instr.close();
        outstr.close();
    }

    public static void transhexadecimal(File obj) throws FileNotFoundException, IOException {
        FileInputStream instr = new FileInputStream(obj);
        int punto = obj.getAbsolutePath().lastIndexOf(".");

        File copiaobj = new File(obj.getAbsolutePath().substring(0, punto) + "_hexadecimal.txt");
        copiaobj.createNewFile();
        FileOutputStream outstr = new FileOutputStream(copiaobj);
        byte[] byteobj = instr.readAllBytes();//recojo todos los bytes del archivo
        String prueba = "";
        for (byte b : byteobj) {//los recorro
            Integer numerobyte = (int) b;//lo casteo a int
            prueba = prueba + String.valueOf(Integer.toHexString(numerobyte)) + " ";

        }

        byte byteshex[] = prueba.getBytes();//paso a bytes la cadena obtenida

        outstr.write(byteshex);
        instr.close();
        outstr.close();

    }

    public static void transoctal(File obj) throws FileNotFoundException, IOException {
        FileInputStream instr = new FileInputStream(obj);
        int punto = obj.getAbsolutePath().lastIndexOf(".");

        File copiaobj = new File(obj.getAbsolutePath().substring(0, punto) + "_octal.txt");
        copiaobj.createNewFile();
        FileOutputStream outstr = new FileOutputStream(copiaobj);
        byte[] byteobj = instr.readAllBytes();//recojo todos los bytes del archivo
        String prueba = "";
        for (byte b : byteobj) {//los recorro
            Integer numerobyte = (int) b;//lo casteo a int

            prueba = prueba + Integer.toOctalString(numerobyte) + " ";

        }

        byte bytesoctal[] = prueba.getBytes();//paso a bytes la cadena obtenida

        outstr.write(bytesoctal);
        instr.close();
        outstr.close();

    }

    public static void transbinario(File obj) throws FileNotFoundException, IOException {
        FileInputStream instr = new FileInputStream(obj);
        int punto = obj.getAbsolutePath().lastIndexOf(".");

        File copiaobj = new File(obj.getAbsolutePath().substring(0, punto) + "_binario.txt");
        copiaobj.createNewFile();
        FileOutputStream outstr = new FileOutputStream(copiaobj);
        byte[] byteobj = instr.readAllBytes();//recojo todos los bytes del archivo
        String prueba = "";
        for (byte b : byteobj) {//los recorro
            Integer numerobyte = (int) b;//lo casteo a int

            prueba = prueba + Integer.toBinaryString(numerobyte) + " ";

        }

        byte bytesbinario[] = prueba.getBytes();//paso a bytes la cadena obtenida

        outstr.write(bytesbinario);

        instr.close();
        outstr.close();

    }

}

