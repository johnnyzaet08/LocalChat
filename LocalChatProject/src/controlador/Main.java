package controlador;

import static java.lang.Integer.parseInt;
import java.util.Scanner;
import vista.Ventana;
import javafx.application.Application;


public abstract class Main extends Application {
    
    public static void main(String[] args) {
        int min = 5000;
        int max = 10000;
        Scanner sc = new Scanner(System.in);
        System.out.println("Cuantos chats necesita?");
        int chats = sc.nextInt();
        int i = 0;
        while (i < chats){
            int port = (int)(Math.random()*(max - min + 1) + min);
            new Ventana(port).setVisible(true);
;            i += 1;
        }
}
    
}
