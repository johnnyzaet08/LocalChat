package clases;

import controlador.Main;
import org.slf4j.LoggerFactory;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta clase contiene el atributo y el metodo para crear un socket que envia los mensajes
 * @author Johnny Aguero
 * @version 1.0
 */

public class Cliente implements Runnable {
    private static org.slf4j.Logger log = LoggerFactory.getLogger(Cliente.class);

    /**
     * Metodo constructor parametrizado
     * @param PUERTO Numero del puerto donde va a enviar
     * @param Mensaje Mensaje que se desea enviar
     */
    private int PUERTO;
    private String Mensaje;

    public Cliente(int puerto, String mensaje) {
        this.PUERTO = puerto;
        this.Mensaje = mensaje;
    }

    @Override
    public void run() {

        //Host del servidor
        final String HOST = "127.0.0.1";
        DataOutputStream out;

        try {

            Socket sc = new Socket(HOST, PUERTO);

            out = new DataOutputStream(sc.getOutputStream());

            //Enviar un mensaje al cliente
            out.writeUTF(Mensaje);

            sc.close();

        } catch (IOException ex) {
            log.error("No se logro enviar el mensaje",ex);
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
