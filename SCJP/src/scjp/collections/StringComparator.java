/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scjp.collections;

import java.util.Arrays;
import java.util.TreeSet;

/**
 *
 * @author student
 */
public class StringComparator {
    
    public static void main(String[] args) {
        
        String[] s = {"JSP", "Java", "XML", "Swing"};
        
        System.out.println(s[0].compareTo(s[1]));
        
        TreeSet<String> set = new TreeSet<String>();
        set.addAll(Arrays.asList(s));
        
        System.out.println(set);
        
        Arrays.sort(s);
        
        System.out.println(Arrays.toString(s));
        
    }
    
}
