/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KratosKike
 */
public class HiloEscucha extends Thread {
    
    private Socket socket = null;
    private Servidor server = null;
    boolean conectado = false;
    
    HiloEscucha(Socket socket) {
        super("Aso");
        this.socket = socket;
    }

    
    
    public void run(){
        
        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            //Establecer variables entrada salida
            BufferedReader in = new BufferedReader(
				    new InputStreamReader(
				    socket.getInputStream()));
            String inputLine, outputLine;
            //Establecer clase protocolo
            
            Protocolo protocol = new Protocolo();
            outputLine = protocol.processInput(null);
            out.println(outputLine);
            
            while ((inputLine = in.readLine()) != null && conectado) {
                //System.out.println("Recibe "+ inputLine);
                escribirComando(outputLine,protocol,inputLine);
		//outputLine = protocol.processInput(inputLine);
		out.println(outputLine);
            }
            
            
        } catch (IOException ex) {
            Logger.getLogger(HiloEscucha.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public void escribirComando(String outputLine, Protocolo protocol, String inputLine ){
        outputLine = protocol.processInput(inputLine);
    }
}

