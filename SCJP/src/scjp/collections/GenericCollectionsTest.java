/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scjp.collections;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Adrian Lapierre <adrian@softproject.com.pl>
 */
public class GenericCollectionsTest {
    public static void main(String[] args) {
        List list = new ArrayList<String>();
        
        list.add("ala");
        list.add("ola");
        list.add(1);
        
        List<String> l2 = list;
        
        for(String s : l2) {
            System.out.println(s);
        }
        
        
    }
    
}
