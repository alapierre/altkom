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
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import pl.altkom.travel.office.web.model.Customer;

/**
 *
 * @author altkom
 */
@ContextConfiguration("/travel-office-web-core.xml")
public class CustomerDAOTest extends AbstractTransactionalJUnit4SpringContextTests {
    
    @Autowired
    CustomerDAO customerDAO;
    
    @Test
    public void testSave() {
        Customer customer = new Customer();
        customer.setName("Jan Nowak");
        customer.setAddress("Powsińska 1234");
        customer.setNewsletterAccepted(false);
        
        customerDAO.save(customer);
        
        System.out.println(customer.getId());
        
    }
    
    @Test
    public void testFind() {
        List<Customer> res = customerDAO.findCustomerByNameLike("Jan%");
        System.out.println(res);
        
    }
    
    @Test
    public void testLoad() {
        Iterable<Customer> res = customerDAO.findAll();

        System.out.println(res);
    }
    
    @Test
    public void testFind2() {
        List<Customer> res = customerDAO.findBestCustomer(11);
        System.out.println(res);
    }
    
}
