/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;


public class LoopTaskThread implements Runnable{
    
    private static int count = 0;
    private int id;
    
    @Override
    public final void run() {
        System.out.println("#### [TASK - " +id + "] STARTING ####");
        
        for (int i = 10; i > 0; i--) {
            System.out.println("[TASK - " + id + "] " + "COUNT DOWN " + i); // simple countdown to see the thread
            try {
                // add a small delay so it is easier to see the thread
                TimeUnit.MILLISECONDS.sleep((long) (Math.random() * 1000)); 
            } catch (InterruptedException ex) {
                Logger.getLogger(LoopTaskThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("**** [TASK - " +id + "] DONE!! ****");
    }
    
    public LoopTaskThread() {
        this.id = ++ count; 
        this.run();
    }    
    
}
