/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.altkom.traveloffice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import pl.altkom.traveloffice.model.Country;
import pl.altkom.traveloffice.model.Date;
import pl.altkom.traveloffice.model.Trip;
import pl.altkom.traveloffice.model.Customer;
import pl.altkom.traveloffice.uti.Kontener;

/**
 *
 * @author altkom
 */
public class TravelOffice {
    
    //private Kontener<Trip> trips = new Kontener<>();
    private Kontener<Customer> customers = new Kontener<>();
    private Map<Country, List<Trip>> trips = new HashMap<>();
    
    public void addTrip(Trip trip, Country country) {
        List<Trip> tmpTrips = trips.get(country);
        if(tmpTrips == null) {
            tmpTrips = new ArrayList<>();
            tmpTrips.add(trip);
            trips.put(country, tmpTrips);
        } else {
            tmpTrips.add(trip);
        }
    }
    
    public void displayTrips() {
        for(Map.Entry<Country,List<Trip>> entry : trips.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
    
    public List<Trip> findTripByName(String name) {
        
        List<Trip> res = new ArrayList<>();
        
        for(List<Trip> tmpTrips : trips.values()) {
            for(Trip trip : tmpTrips) {
                if(trip.getDestination().equals(name)) {
                    res.add(trip);
                }
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        
        TravelOffice travelOffice = new TravelOffice();
        
        boolean end = false;
        
        while (!end) {
            System.out.println("1. Lista wycieczek");
            System.out.println("2. Lista klientów");
            System.out.println("3. Dodaj wyieczkę");
            System.out.println("4. Wyjście");

            Scanner keyboard = new Scanner(System.in);
            int res = keyboard.nextInt();

            System.out.println("wcisnąłęś " + res);
            
            switch (res) {
                case 1:
                    System.out.println("lista wycieczek:");
                    travelOffice.displayTrips();
                    break;
                case 3:
                    readTripFromKeyboard(keyboard);
                    break;
                case 4:
                    end = true;
                    break;
                default:
                    throw new AssertionError();
            }
        }
//        int res;
//        do {
//            Scanner keyboard = new Scanner(System.in);
//            res = keyboard.nextInt();
//            
//            System.out.println("wcisnąłęś " + res);
//        } while (res!=4);
        
//        Date start = new Date(1, 7, 2014);
//        Date end = new Date(14, 7, 2014);
//        
//        Trip trip = new Trip(start, end, "Ateny");
//        
//        Customer customer = new Customer("Jan kowalski");
//        customer.setAddress("Marszałkowska 123/3");
//        customer.assignTrip(trip);
//        
//        System.out.println(customer);
//        
//        TravelOffice travelOffice = new TravelOffice();
//        
//        Trip trip2 = new Trip(start, end, "Bieszczady");
//        Trip trip3 = new Trip(start, end, "Bieszczady");
//        Trip trip4 = new Trip(start, end, "Kreta");
//        
//        travelOffice.addTrip(trip, new Country("Grecja"));
//        travelOffice.addTrip(trip2, new Country("Polska"));
//        travelOffice.addTrip(trip3, new Country("Polska"));
//        travelOffice.addTrip(trip4, new Country("Grecja"));
//        
//        travelOffice.displayTrips();
//        
//        List<Trip> b = travelOffice.findTripByName("Bieszczady");
//        
//        System.out.println(b);
//        
//        travelOffice.customers.add(customer);
        
        //System.out.println(travelOffice.trips);
        //System.out.println(travelOffice.customers);
        
    }
    
    public static Trip readTripFromKeyboard(Scanner keyboard) {
        
        System.out.println("Podaj nazwę wyczieczki");
        String name = keyboard.next();
        
        System.out.println("Podaj datę początkową");
        java.util.Date startDate = readDateFromKeyboard(keyboard, DATE_MASK);
        System.out.println("wpisana data " + formatDate(startDate)); 
        
        System.out.println("Podaj datę końcową");
        String end = keyboard.next();
        java.util.Date dateEnd = readDateFromKeyboard(keyboard, DATE_MASK);
        System.out.println("wpisana data " + formatDate(dateEnd)); 
        
        System.out.println("Podaj kraj");
        String country = keyboard.next();
        
        
        
        return null;
    }
    public static final String DATE_MASK = "yyyy-MM-dd";
   
    public static String formatDate(java.util.Date date) {
        SimpleDateFormat df = new SimpleDateFormat(DATE_MASK);
        return df.format(date);
    }
    
    public static java.util.Date readDateFromKeyboard(Scanner keyboard, String mask) {
       
        SimpleDateFormat df = new SimpleDateFormat(mask);
        
        do {
            String start = keyboard.next();
            try {
                java.util.Date date = df.parse(start);
                return date;
            } catch (ParseException ex) {
                System.out.println("podałeś nieprawidłową danę, prawidłowy format to " 
                        + mask);
            }
        } while(true);
    }
}
