/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.altkom.traveloffice;

import java.util.HashMap;
import java.util.Map;





/**
 *
 * @author altkom
 */
public class MapTest {
    
    public static void main(String[] args) {
        
        String[] slowa = {"ala", "kot", "pies", "ala", "ola"};
        
        Map<String, Integer> licznikSlow = new HashMap<>();
                
        for(String slowo : slowa) {
            Integer iloscWystapien = licznikSlow.get(slowo);
            
            if(iloscWystapien != null) {
                licznikSlow.put(slowo, ++iloscWystapien);
            } else {
                licznikSlow.put(slowo, 1);
            }
        }
        
        //System.out.println(licznikSlow);
        
        for (Map.Entry<String,Integer> entry : licznikSlow.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        
        for(String sl : licznikSlow.keySet()) {
            System.out.print(sl);
            System.out.print(" - ");
            System.out.print(licznikSlow.get(sl));
        }
        
        for(int i : licznikSlow.values()) {
            System.out.println(i);
        }
    }
    
}
