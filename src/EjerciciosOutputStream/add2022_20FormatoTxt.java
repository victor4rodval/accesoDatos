/*Realiza el archivo add2022_20FormatoTxt.java que:
        solicita un texto por teclado,
        compruebe que hay un archivo cuya ruta coincide con el texto introducido por teclado,
        el programa no continuará si el archivo no existe, o si existe pero está vacío,
        solicite un formato de salida entre los siguientes posibles:
        carácter, enteros, hexadecimal, octal o binario,
        dependiendo de la elección, el programa crea un archivo con el nombre del archivo original
        más _formato.txt, y que contenga, en código ascii, el contenido del archivo en el formato elegido.
        Es decir, si se elige hexadecimal se almacenará en el archivo de salida la información del archivo
        de entrada utilizando los caracteres 0123456789ABCDEF, si se elige binario se almacenarán 0 y 1, etc.
        Cada dato se separará del siguiente mediante un caracter separador.*/
package EjerciciosOutputStream;

import java.io.*;
import java.util.Scanner;

public class add2022_20FormatoTxt {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce la ruta");
        String ruta = sc.nextLine();
        File f = new File(ruta);

        //Comprobamos que el archivo existe y no está vacío
        if (f.exists() && f.length() != 0) {
//
            String opcion;
            do {
                System.out.println("Escribe el formato de salida escogido: ");
                System.out.println("1-Caracteres");
                System.out.println("2-Enteros");
                System.out.println("3- Hexadecimal");
                System.out.println("4- Octal");
                System.out.println("5- Binario");
                System.out.println("6- Salir");
                opcion = sc.nextLine().toLowerCase();
            } while (!opcion.equals("salir") && !opcion.equals("caracteres") && !opcion.equals("hexadecimal"));
            if (!opcion.equals("salir")) {
                switch (opcion) {
                    case "caracteres":
                        //Creo nuevo fichero con el nombre requerido
                        File fCopiaCaracteres = new File(ruta + "_" + opcion + ".txt");
                        //Leo el fichero y escribo en el nuevo fichero el contenido del primero en forma de caracteres
                        try (FileReader fr = new FileReader(ruta)) {
                            try (FileWriter fwCopia = new FileWriter(fCopiaCaracteres)) {
                                int c;
                                while ((c = fr.read()) != -1) {
                                    fwCopia.write((char) c);
                                }
                            }
                        }
                        System.out.println("Archivo escrito");
                        break;
                    case "enteros":

                        break;

                    case "hexadecimal":
                        File fCopiaHexa = new File(ruta + "_" + opcion + ".txt");
                        int contador = 0;
                        try (FileReader fr = new FileReader(ruta)) {
                            try (FileWriter fwCopia = new FileWriter(fCopiaHexa)) {
                                int c = 0;
                                while ((c = fr.read()) != -1) {
                                    contador++;
                                    //System.out.printf((char)c+"\t");
                                    fwCopia.write((String.format("0x%h" + " ", c)));
                                }
                                System.out.println(contador + " caracteres convertidos");
                            }
                        }
                        break;

                    case "octal":

                        break;

                    case "binario":

                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + opcion);
                }
            } else {
                System.out.println("Elegiste salir del programa.");
            }
            //Excepciones de los try-with
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
            //Mensaje de salida del programa cuando el fichero no existe o no cumple las exigencias
        } else {
            System.out.println("No ha sido posible encontrar el archivo o está vacío");
        }
    }


}