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
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KratosKike
 */
class LanzaTareas extends Thread{
    //Socket utilizado para comunicarse con el servidor.
    private Socket socketCliente;
    //Stream utilizado para el envío de objetos al servidor.
    private ObjectOutputStream objectOutputStream;
    //Stream utilizado para el envío de objetos al servidor.
    private ObjectInputStream objectInputStream;
    //Booleano para la actividad del hilo
    private boolean escuchando;
    
    LanzaTareas(Socket socketCliente) {
        this.socketCliente = socketCliente;
        escuchando = true;
        
    }
    
    public synchronized void run(){
    
        try {
            objectOutputStream=new ObjectOutputStream(socketCliente.getOutputStream());
            objectInputStream=new ObjectInputStream(socketCliente.getInputStream());
            System.out.println(objectOutputStream);
            System.out.println("Conexion exitosa");
            enviarMensaje("testeoarrance");
            //Arrancar menu de inicio
            MenuTesteo mt = new MenuTesteo(socketCliente,objectOutputStream);
            mt.setVisible(true);
            System.out.println("Pantalla creada");
            
            //Entrar bucle de escuchar datos
            this.escuchar();
            
        } catch (IOException ex) {
            Logger.getLogger(LanzaTareas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void escuchar(){
        
        try{
            System.out.println("Ha entrado en metodo escuchar");
            while(escuchando){
                //Espera a recibir una lista
                Object aux = objectInputStream.readObject();
                //recoje la lista y la ejecuta
                if(aux instanceof LinkedList){
                    ejecutar((LinkedList<String>)aux);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(LanzaTareas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LanzaTareas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void ejecutar(LinkedList<String> lista){
        String tipo=lista.get(0);
        
    }
    
    public void enviarMensaje(String mensaje){
        LinkedList<String> lista=new LinkedList<>();
        //tipo
        lista.add("Tipo");
        //mensaje
        lista.add(mensaje);
        try {
            System.out.println(lista.get(0));
            System.out.println(lista.get(1));
            System.out.println("Enviando a servidor: "+mensaje);
            System.out.println(objectOutputStream);
            objectOutputStream.writeObject("hola");
        } catch (IOException ex) {
            System.out.println("Error de lectura y escritura al enviar mensaje al servidor.");
        } /*catch(NullPointerException e){
            System.out.println("Error de tipo NullPointer.");

        }*/
    }
    
}
