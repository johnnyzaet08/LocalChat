package controlador;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Observable;

public class Servidor extends Observable implements Runnable {

    private int PUERTO;
    
    public Servidor(int puerto){
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
            while(true){
                
                sc = servidor.accept(); //Cliente conectado
                
                in = new DataInputStream(sc.getInputStream());  //carril de llegada

                String mensaje = in.readUTF(); //Leer el mensaje que envia

                this.setChanged();
                this.notifyObservers(mensaje);
                this.clearChanged();
                
                
                sc.close(); //Cerrar el socket
              
            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

}
