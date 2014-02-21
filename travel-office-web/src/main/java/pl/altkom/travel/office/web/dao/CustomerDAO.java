/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.altkom.travel.office.web.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import pl.altkom.travel.office.web.model.Customer;

/**
 *
 * @author altkom
 */
public interface CustomerDAO extends CrudRepository<Customer, Integer>{

    public List<Customer> findCustomerByName(String name);
    
}
