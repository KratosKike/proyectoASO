/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KratosKike
 */


public class NewHilo extends Thread{
    
    /**
     * Socket para la comunicacion cliente servidor
     */
    private Socket clientSocket;

    NewHilo(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }
    
    @Override
    public void run() {
        try {
            PrintStream output = new PrintStream(clientSocket.getOutputStream());
            //Para leer lo que envie el cliente
            BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            
            //establecer variables entrada salida
            String inputLine, outputLine;
            Protocolo2 protocol = new Protocolo2();
            
            //Lanza primera linea del protocolo
            outputLine = protocol.processInput(null);
            output.println(outputLine);
            
            //Crear bucle que sale cuando se escribe cierto comando
            //o se cierra el programa
            
            //Mientras reciba una entrada de pantalla del cliente
            while ((inputLine = input.readLine()) != null){
                
                //Procesa la salida del cliente
                outputLine = protocol.processInput(inputLine);
                //Escribe en el cliente el resultado del proceso del protocolo
                
                output.println(outputLine);
                //Escape para cerrar el socket
                if (outputLine.equals("Bye")){
                    output.close();
                    input.close();
                    clientSocket.close();
		    break;
                }
                
            
                
            }
            
        } catch (IOException ex) {
            Logger.getLogger(NewHilo.class.getName()).log(Level.SEVERE, null, ex);
        }

    
    }
    
}
