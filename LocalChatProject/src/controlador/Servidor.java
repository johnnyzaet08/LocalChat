package controlador;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {

    public static void main(String[] args){
        
        ServerSocket servidor = null;
        Socket sc = null;
        final int PUERTO = 5000;
        DataInputStream in;
        DataOutputStream out;
        
        
        
        try {
            servidor = new ServerSocket(PUERTO);
            System.out.println("Servidor iniciado");
            
            while(true){
                sc = servidor.accept();
                
                in = new DataInputStream(sc.getInputStream());  //carril de llegada
                out = new DataOutputStream(sc.getOutputStream()); //caril de salida
                
                String mensaje = in.readUTF();
                
                System.out.println(mensaje);
                
                out.writeUTF("Hola Mundo");
            
                sc.close(); //Desconectar el cliente
                System.out.println("Cliente Desconectado");
                
                
            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
