package EjerciciosOutputStream;

import java.io.FileOutputStream;
//Forma de escribir texto en un fichero
public class escribirTextoenFichero {
    public static void main(String[] args) {
        try{
            FileOutputStream fos=new FileOutputStream("C:\\testout.txt");
            String s="Esto es una prueba de escritura en ficheros.";
            byte b[]=s.getBytes();//converting string into byte array
            fos.write(b);
            fos.close();
            System.out.println("Tu archivo ha sido creado correctamente");
        }catch(Exception e){System.out.println(e);}
    }
}
