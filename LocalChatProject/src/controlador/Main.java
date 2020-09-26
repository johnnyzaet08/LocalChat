package controlador;

import vista.Ventana1;
import vista.Ventana2;
import javafx.application.Application;


public abstract class Main extends Application {
    
    public static void main(String[] args) {
        System.out.println("Bandera1");
        new Ventana2().setVisible(true);
        System.out.println("Bandera2");
        new Ventana1().setVisible(true);
        System.out.println("Bandera3");
}
    
}
