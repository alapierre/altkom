/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.altkom.designpatterns;

/**
 *
 * @author altkom
 */
public class TestObservator {
    
    public static void main(String[] args) {
        
        Director director = new Director();
        
        ComedyActor bradPitt = new ComedyActor();
        bradPitt.setName("Brad Pitt");
        bradPitt.setSalary(10_000_000);
        
        ComedyActor charliSheen = new ComedyActor();
        charliSheen.setName("Charlie Sheen");
        charliSheen.setSalary(1000000);
        
        director.attach(bradPitt);
        director.attach(charliSheen);
        
        director.callToAllActors();
    }
    
}
