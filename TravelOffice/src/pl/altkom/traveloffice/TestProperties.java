/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.altkom.traveloffice;

import java.util.Properties;

/**
 *
 * @author altkom
 */
public class TestProperties {
    
    public static void main(String[] args) {
        Properties props = System.getProperties();
        props.list(System.out);
        
        System.out.println(props.get("alamakota"));
        
    }
    
}
