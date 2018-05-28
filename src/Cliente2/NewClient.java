/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente2;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author KratosKike
 */
public class NewClient {
    //puerto
    private final static int PORT = 4444;
    //host
    private final static String SERVER = "localhost";
    //ventana
    private static Inicio panel; 
    
    
    public static void main(String[] args) {
        
        //Abrir ventana prinicpal
        JFrame v = new JFrame();
        panel = new Inicio();
        panel.setVisible(true);     
        
        Socket clientSocket;//Socket para la comunicacion cliente servidor
        
        try {
            //abre socket
            clientSocket = new Socket(SERVER, PORT);
            //para imprimir datos del servidor
            PrintStream toServer = new PrintStream(clientSocket.getOutputStream());
            //Para leer lo que envie el servidor
            InputStream stream = clientSocket.getInputStream();
            //genera numero aleatorio y manda al servidor
            //toServer.println(Helper.fn.rndInt(2, 20));
            //lee respuesta del servidor
            byte[] bytes = new byte[256];
            stream.read(bytes, 0, 256);
            //convierte a string
            String received = new String(bytes, "UTF-8");
            //imprime en pantalla
            System.out.println("Server> recibido del servior fibonacci" + received.trim());
            clientSocket.close();
            
        } catch (IOException ex) {
            Logger.getLogger(NewClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void escribir(String texto, PrintStream toServer){
        toServer.println(texto);
    }
    
    
    
}
