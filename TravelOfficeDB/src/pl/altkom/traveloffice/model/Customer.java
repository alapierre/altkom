/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.altkom.traveloffice.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author altkom
 */
public class Customer {

    private String name;
    public static final String PROP_NAME = "name";
    
        private String address;

    public static final String PROP_ADDRESS = "address";

        private boolean newsletterAccepted;

    public static final String PROP_NEWSLETTERACCEPTED = "newsletterAccepted";

        private String mail;

    public static final String PROP_MAIL = "mail";

    /**
     * Get the value of mail
     *
     * @return the value of mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * Set the value of mail
     *
     * @param mail new value of mail
     */
    public void setMail(String mail) {
        String oldMail = this.mail;
        this.mail = mail;
        propertyChangeSupport.firePropertyChange(PROP_MAIL, oldMail, mail);
    }

    
    /**
     * Get the value of newsletterAccepted
     *
     * @return the value of newsletterAccepted
     */
    public boolean isNewsletterAccepted() {
        return newsletterAccepted;
    }

    /**
     * Set the value of newsletterAccepted
     *
     * @param newsletterAccepted new value of newsletterAccepted
     */
    public void setNewsletterAccepted(boolean newsletterAccepted) {
        boolean oldNewsletterAccepted = this.newsletterAccepted;
        this.newsletterAccepted = newsletterAccepted;
        propertyChangeSupport.firePropertyChange(PROP_NEWSLETTERACCEPTED, oldNewsletterAccepted, newsletterAccepted);
    }

    
    /**
     * Get the value of address
     *
     * @return the value of address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set the value of address
     *
     * @param address new value of address
     */
    public void setAddress(String address) {
        String oldAddress = this.address;
        this.address = address;
        propertyChangeSupport.firePropertyChange(PROP_ADDRESS, oldAddress, address);
    }


    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        propertyChangeSupport.firePropertyChange(PROP_NAME, oldName, name);
    }

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    /**
     * Add PropertyChangeListener.
     *
     * @param listener
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    /**
     * Remove PropertyChangeListener.
     *
     * @param listener
     */
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    @Override
    public String toString() {
        return "Customer{" + "name=" + name + ", address=" + address + ", newsletterAccepted=" + newsletterAccepted + ", mail=" + mail + ", propertyChangeSupport=" + propertyChangeSupport + '}';
    }

    
    
}
