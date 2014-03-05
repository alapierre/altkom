/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scjp.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * Adrian Lapierre <adrian@softproject.com.pl>
 */
public class SortTest {
    
    public static void main(String[] args) {
        
        List<String> list = new ArrayList<String>();
        
        list.add("Ola");
        list.add("Ala");
        list.add("Kot");
        
        System.out.println(list);
        
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        
        System.out.println(list);
        
    }
    
}
