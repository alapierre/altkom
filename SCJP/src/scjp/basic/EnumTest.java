/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scjp.basic;

/**
 *
 * Adrian Lapierre <adrian@softproject.com.pl>
 */
public class EnumTest {
    
    public static void main(String[] args) {
        Fruit f = Fruit.APPLE;
        int i = Fruit.LEMON.ordinal();
        
        Fruit ff = Fruit.values()[1];
        
        System.out.println(i);
    }
    
}
