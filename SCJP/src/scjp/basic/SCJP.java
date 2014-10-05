/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scjp.basic;

import java.util.Date;

/**
 *
 * @author student
 */
public class SCJP {

    public int i;
    private static int jj = 1;
    
    /**
     * @param args the command line arguments
     */
    public  void main(String[] args) {
        
        SCJP.Ala ala = new SCJP.Ala();
        
        SCJP.jj = 1234;
        
        final int i = 1;
        this.i = 0;
        
        final Date zmienna = new Date();
        
        Thread th = new Thread(new Thread() {
        
            @Override
            public void run() {
                System.out.println(SCJP.this.i);
                zmienna.setDate(12);
                
            }
        });
        
        
    }
    
    static protected class Ala {
        public static int i;
    }
}

class Ola {
    
    public static void m() {
        
    }
    
}