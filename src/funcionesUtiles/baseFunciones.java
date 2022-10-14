package funcionesUtiles;

import java.util.Random;

public class baseFunciones {
    //CONTROLAR EL TIEMPO DE EJECUCIÓN DEL CÓDIGO
//    double inicio = System.currentTimeMillis();
//    //Aquí colocamos la sección de código a examinar
//    double fin = System.currentTimeMillis();
//    double tiempo = (fin-inicio)/1000;
//    System.out.println(tiempo+" segundos");


    //PASAR UN STRING A BYTE Y CONVERSION A HEXADECIMAL
    private void pasarStringHexadecimal(String cadena) {
        byte b;
        for (int i = 0; i < cadena.length(); i++) {
            b = (byte) cadena.charAt(i);
            String.format("0x%h", b);
        }
        //o de esta forma
        byte[] bytes = cadena.getBytes();
        String.format("0x%h", bytes);
        //Podemos luego imprimir por pantalla
    }

    //PASAR DE BYTE A STRING
    public static String toHex(byte b) {
        String result = Integer.toHexString(b & 0xFF);
        if (result.length() == 1) {
            result = '0' + result;
        }
        return result;
    }

    //Método para comprobar que los caracteres están permitidos por las expresiones regulares
    private static boolean nombreValido(String nombre) {

        return (nombre.matches("[[a-zA-z0-9]|[-_\\.\\\\/]]+"));
    }
    //Método para crear números aleatorios con la clase Random
    private int numeroAleatorio(int num1, int num2){
        Random r= new Random();
        int numAleatorio=r.nextInt(num1,num2);
        //También double y cualquier otro primitivo
        //double num = r.nextDouble(num1,num2);
        //entre el 0 y el 99
        //(int)(r.nextDouble() * 100);
        //Entre el 1 y el 6 incluidos
        //(int)(rnd.nextDouble() * 6 + 1);
        return numAleatorio;
    }


}


