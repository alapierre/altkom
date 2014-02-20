/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.altkom.designpatterns;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author altkom
 */
public class Director {
    
    private Set<Actor> actors = new HashSet<>();
    
    public void attach(Actor actor) {
        actors.add(actor);
    }
    
    public void detach(Actor actor) {
        actors.remove(actor);
    }
    
    public void callToAllActors() {
        for(Actor actor : actors) {
            actor.update();
        }
    }
}
