package clases;

import controlador.Main;
import org.slf4j.LoggerFactory;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Observable;

/**
 * Esta clase contiene el atributo y el metodo para crear un socket que escucha los mensajes
 * @author Johnny Aguero
 * @version 1.0
 */

public class Servidor extends Observable implements Runnable {
    private static org.slf4j.Logger log = LoggerFactory.getLogger(Main.class);

/**
     * Metodo constructor parametrizado
     * @param PUERTO Numero del puerto donde va a escuchar
     */
    private int PUERTO;

    public Servidor(int puerto) {
        this.PUERTO = puerto;
    }

    @Override
    public void run() {
        ServerSocket servidor = null;
        Socket sc = null;
        DataInputStream in;

        try {
            servidor = new ServerSocket(PUERTO);

            //Siempre dando vueltas para que alguien se conecte 
            while (true) {

                sc = servidor.accept(); //Cliente conectado

                in = new DataInputStream(sc.getInputStream());  //carril de llegada

                String mensaje = in.readUTF(); //Leer el mensaje que envia

                this.setChanged();
                this.notifyObservers(mensaje);
                this.clearChanged();

                sc.close(); //Cerrar el socket

            }
        } catch (IOException ex) {
            log.error("El servidor no pudo quedarse escuchando",ex);
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
