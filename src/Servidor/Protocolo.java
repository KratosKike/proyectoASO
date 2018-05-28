/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

/**
 *
 * @author KratosKike
 */

public class Protocolo {
    private static final int WAITING = 0;
    private static final int LOGIN = 1;
    
    private int state = WAITING;

    String processInput(String theInput) {
        
        String theOutput = null;
        
        if (state == WAITING) {
            theOutput = "Bienvenido al programa";
            state = LOGIN;
            
        }else if(state == LOGIN){
            theOutput = "Probando login";
        }
        
        return theOutput;
        
    }
    
}
