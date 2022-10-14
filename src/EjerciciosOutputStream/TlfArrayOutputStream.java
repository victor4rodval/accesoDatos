package EjerciciosOutputStream;

import java.io.FileOutputStream;
import java.io.IOException;

/*Pide por teclado el nombre y número de teléfono y almacénalos en un fichero*/
public class TlfArrayOutputStream {


    static FileOutputStream fos;
    public static final int longLinea = 81;

    public static void main(String args[]) throws IOException {
        byte tfno[] = new byte[longLinea];
        byte nombre[] = new byte[longLinea];

        fos = new FileOutputStream("telefono.dat");
        while (true) {
            System.err.println("Teclee un nombre ('Fin' termina)");
            leeLinea(nombre);
            if ("fin".equalsIgnoreCase(new String(nombre, 0, 0, 3)))
                break;

            System.err.println("Teclee el numero de telefono");
            leeLinea(tfno);
            for (int i = 0; tfno[i] != 0; i++)
                fos.write(tfno[i]);
            fos.write(',');
            for (int i = 0; nombre[i] != 0; i++)
                fos.write(nombre[i]);
            fos.write('\n');
        }
        fos.close();
    }

    private static void leeLinea(byte linea[]) throws IOException {
        int b = 0;
        int i = 0;

        while ((i < (longLinea - 1)) &&
                ((b = System.in.read()) != '\n'))
            linea[i++] = (byte) b;
        linea[i] = (byte) 0;
    }

}