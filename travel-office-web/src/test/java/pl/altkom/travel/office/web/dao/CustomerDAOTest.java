/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.altkom.travel.office.web.dao;

import java.util.List;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import pl.altkom.travel.office.web.model.Customer;

/**
 *
 * @author altkom
 */
@ContextConfiguration("/travel-office-web-core.xml")
public class CustomerDAOTest extends AbstractJUnit4SpringContextTests {
    
    @Autowired
    CustomerDAO customerDAO;
    
    @Test
    public void testFind() {
        List<Customer> res = customerDAO.findCustomerByName("jan");
        System.out.println(res);
        
    }
    
    @Test
    public void testLoad() {
        Iterable<Customer> res = customerDAO.findAll();

        System.out.println(res);
    }
    
}
