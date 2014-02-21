/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.altkom.travel.office.web.model;

/**
 *
 * @author altkom
 */
public class Customer {
    
    private String name;
    private String address;
    private boolean newsletterAccepted;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isNewsletterAccepted() {
        return newsletterAccepted;
    }

    public void setNewsletterAccepted(boolean newsletterAccepted) {
        this.newsletterAccepted = newsletterAccepted;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" + "name=" + name + ", address=" + address + ", newsletterAccepted=" + newsletterAccepted + ", email=" + email + '}';
    }
    
}
