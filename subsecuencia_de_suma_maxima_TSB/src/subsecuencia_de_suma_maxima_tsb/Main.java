/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subsecuencia_de_suma_maxima_tsb;

/**
 *
 * @author matychp
 */
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Main {

    static int unArreglo[];

    public static void main(String args[]) {

        cargarArreglo(1);//El parametro es el numero del archivo externo .txt (1,2,3)

        int mss = 0, sp = 0;

        /*
         //Primera implementacion O(n^3)
         //Tiempo mss01.txt f(t) = 19 minutos (y dio el mismo resultado que la segunda implementacion)
         for (int i = 0; i < unArreglo.length; i++) {
         for (int j = i; j < unArreglo.length; j++) {
         sp = 0;
         //for (int k = i; (k >= i && k <= j); k++) {
         for (int k = i; k <= j; k++) {
         sp += unArreglo[k];

         if (sp > mss) {
         mss = sp;
         }
         }
         }
         }
         //*/
        //*
        //Primera implementacion O(n^3)
        //Tiempo mss01.txt f(t) = 19 minutos (y dio el mismo resultado que la segunda implementacion)
        for (int i = 0; i < unArreglo.length; i++) {
            for (int j = i; j < unArreglo.length; j++) {
                sp = 0;
                //for (int k = i; (k >= i && k <= j); k++) {
                for (int k = i; k <= j; k++) {
                    sp += unArreglo[k];
                }

                if (sp > mss) {
                    mss = sp;
                }
            }
        }
        //*/

        /*
         //Segunda implementacion O(n^2)
         //Tiempo mss01.txt = Instantaneo
         //Tiempo mss02.txt = Aprox 18 segundos
         for (int i = 0; i < unArreglo.length; i++) {
         sp = 0;
         for (int j = i; j < unArreglo.length; j++) {
         sp += unArreglo[j];

         if (sp > mss) {
         mss = sp;
         }
         }
         }
         //*/
        /*
         //Tercera implementacion O(n)
         //Tiempo mss01.txt (0 segundos)
         //Tiempo mss02.txt (0 segundos)
         //Tiempo mss03.txt (1 segundos)
         for (int j = 0; j < unArreglo.length; j++) {
         sp += unArreglo[j];

         if (sp > mss) {
         mss = sp;
         } else if (sp < 0) {
         sp = 0;
         }
         }
         //*/
        System.out.println("Numero maximo de sequencia: " + mss);
        //System.out.println("Tamaño del arreglo: " + unArreglo.length);
        /*
         for(Integer i: unArreglo){
         System.out.println(i);
         }
         //*/
    }

    public static void cargarArreglo(int unArchivo) {
        File f;
        switch (unArchivo) {
            case 1:
                unArreglo = new int[15000];
                f = new File("mss01.txt");
                break;
            case 2:
                unArreglo = new int[150000];
                f = new File("mss02.txt");
                break;
            case 3:
                unArreglo = new int[1500000];
                f = new File("mss03.txt");
                break;
            case 4:
                unArreglo = new int[6];
                f = new File("prueba01.txt");
                break;
            case 5:
                unArreglo = new int[6];
                f = new File("prueba02.txt");
                break;
            case 6:
                unArreglo = new int[6];
                f = new File("prueba03.txt");
                break;
            default:
                return;
        }
        try (Scanner sc = new Scanner(f)) {
            int pos = 0;
            while (sc.hasNextInt()) {
                unArreglo[pos] = sc.nextInt();
                pos++;
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}

