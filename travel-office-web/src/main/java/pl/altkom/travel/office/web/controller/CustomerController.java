/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.altkom.travel.office.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.altkom.travel.office.web.model.Customer;

/**
 *
 * @author altkom
 */
@Controller
public class CustomerController {

    @RequestMapping("/customer_details")
    public ModelAndView customerDetails() {
        
        Customer customer = new Customer();
        customer.setName("Jan Kowalski");
        customer.setAddress("Marszałkowska 123, 01-001 Warszawa");
        customer.setNewsletterAccepted(true);
        
        
        ModelAndView model = new ModelAndView("customer_details");
        model.addObject("customer", customer);
        
        return model;
    }
    
}
