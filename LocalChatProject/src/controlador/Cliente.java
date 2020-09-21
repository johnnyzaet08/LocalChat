package controlador;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente implements Runnable{

    private int PUERTO;
    private String Mensaje;
    
    public Cliente(int puerto, String mensaje){
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
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
