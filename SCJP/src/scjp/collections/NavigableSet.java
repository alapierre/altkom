/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scjp.collections;

import java.util.TreeSet;

/**
 *
 * Adrian Lapierre <adrian@softproject.com.pl>
 */
public class NavigableSet {
   
    public static void main(String[] args) {
        
        TreeSet<Integer> set = new TreeSet<Integer>();
        
        set.add(1);
        set.add(3);
        set.add(5);
        set.add(10);
        
        System.out.println("floor(4) = " + set.floor(4));
        
        System.out.println("ceiling(4) = " + set.ceiling(4));
        
        System.out.println("subSet(1, 5) = " + set.subSet(1, 5));
        
        System.out.println("tailSet(5)" + set.tailSet(5));
        
        int polled = set.pollFirst();
        System.out.println("polled = " + polled);
        
        System.out.println("after poll" + set);
        
        
    }
    
}
