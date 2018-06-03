/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente3;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KratosKike
 */
public class Cliente {
    
    //puerto
    private final static int PORT = 4444;
    //host
    private final static String SERVER = "localhost";
    
    
    public static void main(String[] args) {
        //Socket para la comunicacion cliente servidor
        Socket clientSocket;
        try {
            //abre socket
            clientSocket = new Socket(SERVER, PORT);
            
            System.out.println("");
            
            //si conecta el socket, abrir el hilo lanza tareas
            LanzaTareas lt = new LanzaTareas(clientSocket);
            lt.start();
            
            //Abrir ventana menu Testeo
            
            
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
