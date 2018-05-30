/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente3;

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
class LanzaTareas {
    //Socket utilizado para comunicarse con el servidor.
    private Socket socketCliente;
    //Stream utilizado para el envío de objetos al servidor.
    private ObjectOutputStream objectOutputStream;
    //Stream utilizado para el envío de objetos al servidor.
    private ObjectInputStream objectInputStream;
    
    LanzaTareas(Socket socketCliente) {
        this.socketCliente = socketCliente;
        
    }
    
    public void run(){
    
        try {
            objectOutputStream=new ObjectOutputStream(socketCliente.getOutputStream());
            objectInputStream=new ObjectInputStream(socketCliente.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(LanzaTareas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
