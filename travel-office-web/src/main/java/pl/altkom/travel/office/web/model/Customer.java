/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.altkom.travel.office.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;

/**
 *
 * @author altkom
 */
@Entity
public class Customer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Size(min = 3, max = 128)
    @NotNull
    @Column(length = 128)
    private String name;
    @Size(min = 3, max = 256)
    @NotNull
    @Column(length = 256)
    private String address;
    private boolean newsletterAccepted;
    @Email
    @Column(length = 128)
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    
    @Override
    public String toString() {
        return "Customer{" + "name=" + name + ", address=" + address + ", newsletterAccepted=" + newsletterAccepted + ", email=" + email + '}';
    }
    
}
