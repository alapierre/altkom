/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.altkom.traveloffice.model;

import pl.altkom.traveloffice.uti.Kontener;

/**
 *
 * @author altkom
 */
public class Customer {
    
    String name;
    String address;
    Kontener<Trip> trip = new Kontener<>();

    public Customer(String name) {
        this.name = name;        
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public void assignTrip(Trip trip) {
        this.trip.add(trip);
    }

    @Override
    public String toString() {
        return "Customer{" + "name=" + name + ", address=" + address + ", trip=" + trip + '}';
    }
    
    public String getInfo() {
        return toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    
    
    
}
