/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scjp.collections;

import java.security.acl.Owner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * Adrian Lapierre <adrian@softproject.com.pl>
 */
public class NotComparableTest {
    
    static class Owoc {
        private String name;
    }
    
    public static void main(String[] args) {
    
        List list = new ArrayList<Owoc>();
        
        list.add(new Owoc());
        list.add(new Owoc());
        list.add(new Owoc());
        list.add(new Owoc());
        
        Collections.sort(list);
        
    }
    
}
