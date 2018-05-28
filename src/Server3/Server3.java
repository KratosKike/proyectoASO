/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KratosKike
 */
public class Server3 {
    
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(4444);
            System.out.println("Server> Servidor iniciado");
            
             while (true) {
                System.out.println();
                //en espera de conexion, si existe la acepta
                Socket clientSocket = serverSocket.accept();
                //NewHilo hilo = new NewHilo(serverSocket.accept());
                System.out.println("Ha entrado un cliente");
                //hilo.start();
                
             }
            
        } catch (IOException ex) {
            Logger.getLogger(Server3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
