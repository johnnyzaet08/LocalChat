package controlador;

import static java.lang.Integer.parseInt;
import java.util.Scanner;
import vista.Ventana;
import javafx.application.Application;

/**
 * Esta clase contiene el metodo principal para ejecutar las ventanas
 * @author Johnny Aguero
 * @version 1.0
 */

public abstract class Main extends Application {
/**
     * Metodo constructor parametrizado
     * @param args 
     */
    public static void main(String[] args) {
        int min = 5000;
        int max = 10000;
        Scanner sc = new Scanner(System.in); //Para el ingreso de un dato
        System.out.println("Cuantos chats necesita?");
        int chats = sc.nextInt();
        int i = 0;
        while (i < chats) {
            int port = (int) (Math.random() * (max - min + 1) + min);
            new Ventana(port).setVisible(true); //Crea las ventanas deseadas por el usuario
            i += 1;
        }
    }

}
