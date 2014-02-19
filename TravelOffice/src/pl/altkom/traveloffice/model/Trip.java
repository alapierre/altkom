/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.altkom.traveloffice.model;

/**
 *
 * @author altkom
 */
public class Trip {
    
    private Date start;
    private Date end;
    
    private String destination;

    public Trip(Date start, Date end, String destination) {
        this.start = start;
        this.end = end;
        this.destination = destination;
    }
    
    public String getInfo() {
        return destination + " " + start + " - " + end;
    }

    @Override
    public String toString() {
        return "Trip{" + "start=" + start + ", end=" + end + ", destination=" + destination + '}';
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
    
    
    
}
