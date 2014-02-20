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
public class ComedyActor extends AbstractActor {
    
    @Override
    public void update() {
        System.out.println("aktor komediowy "
                + getName() + " odebrał powiadmienie");
    }
    
}
