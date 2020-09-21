package controlador;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {

    public static void main(String[] args) {

        final String HOST = "127.0.0.1";
        final int PUERTO = 5000;
        DataInputStream in;
        DataOutputStream out;

        try {

            Socket sc = new Socket(HOST, PUERTO);

            in = new DataInputStream(sc.getInputStream());  //carril de llegada
            out = new DataOutputStream(sc.getOutputStream());
               
            out.writeUTF("Hola Servidor");
            
            String mensaje = in.readUTF();
            
            System.out.println(mensaje);
            
            sc.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
