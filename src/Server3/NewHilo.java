/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server3;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KratosKike
 */
class NewHilo extends Thread{
    
    //Socket para conectarse con el cliente
    private Socket socketCliente;
    //Stream con el que se envían objetos al servidor.
    private ObjectOutputStream objectOutputStream;
    //Stream con el que se reciben objetos del servidor.
    private ObjectInputStream objectInputStream;
    //Variable para identificar si esta escuchando el hilo
    private boolean escuchando;
    NewHilo(Socket socketCliente) {
            this.socketCliente = socketCliente;
            try {
                objectOutputStream = new ObjectOutputStream(socketCliente.getOutputStream());
                objectInputStream = new ObjectInputStream(socketCliente.getInputStream());
            } catch (IOException ex) {
                System.err.println("Error en la inicialización del ObjectOutputStream y el ObjectInputStream");        }
            }   
    
    
    public void run(){
        try{
            escuchar();
        } catch (Exception ex) {
            System.err.println("Error al llamar al método readLine del hilo del cliente.");
        }
        desconectar();
    }
    
    public void escuchar(){
        while(escuchando){
            try {
                Object aux=objectInputStream.readObject();
            } catch (IOException ex) {
                Logger.getLogger(NewHilo.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(NewHilo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void desconectar(){
    
    }
    
}
