/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import java.io.IOException;
import java.net.ServerSocket;

/**
 *
 * @author KratosKike
 */
public class Servidor {
    
    
    //Datos Servidor Base de datos
    static String sqlite_jdbd_driver="org.sqlite.JDBC";
    static String prefix="jdbc:"+"sqlite:";
    static String hostName="";
    static String urlFolder="G\\BD\\";
    static String dbName="ejemplo.db";
    static String driver=sqlite_jdbd_driver;
    static String userr="";
    static String password="";
    static String url= prefix + urlFolder + dbName;
    
    public Servidor()throws IOException{
        
        
        ServerSocket serverSocket = null;
        boolean escuchando = true;
        
        //Abrir escucha del servidor
        
        try {
            serverSocket = new ServerSocket(4444);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 4444.");
            System.exit(-1);
        }
        
        while (escuchando){
        
            HiloEscucha hilo = new HiloEscucha(serverSocket.accept());
            System.out.println("Ha entrado un cliente");
            hilo.start();
        
        }
    }  
    
    public static void main(String[] args) throws IOException {
            Servidor servidor = new Servidor();
    }
    
    
}
