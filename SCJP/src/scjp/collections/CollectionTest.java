/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scjp.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * Adrian Lapierre <adrian@softproject.com.pl>
 */
public class CollectionTest {
    
    public static void main(String[] args) {
        
        List<String> list = new ArrayList<String>();
        
        list.add("ala ma kota");
        
        String[] res = list.toArray(new String[0]);
        
        System.out.println(Arrays.toString(res));
        
        List<Integer> list2 = new ArrayList<Integer>();
        Integer[] i = list2.toArray(new Integer[0]);
    }
    
}
