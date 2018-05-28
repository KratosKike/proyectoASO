/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor2;

/**
 *
 * @author KratosKike
 */
class Protocolo2 {
    
    private static final int WAITING = 0;
    
    private int state = WAITING;
    
    String processInput(String theInput) {
        
        String theOutput = null;
        
        if (state == WAITING) {
            theOutput = "Bienvenido al programa";
            
            
        }
        
        return theOutput;
    
    }
    
}
