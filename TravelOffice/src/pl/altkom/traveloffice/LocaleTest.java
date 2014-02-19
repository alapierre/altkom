/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.altkom.traveloffice;

import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author altkom
 */
public class LocaleTest {
    public static void main(String[] args) {
        
        System.out.println(Locale.getDefault());

        Locale.setDefault(new Locale("gr", "GR"));
        
        System.out.println(Locale.getDefault());
        
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        
        System.out.println(nf.format(123678.88));
    }
    
}
