/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.altkom.traveloffice.task;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.jdesktop.observablecollections.ObservableList;
import pl.altkom.traveloffice.model.Customer;
import pl.com.softproject.utils.jdbc.ConnectionServiceImpl;
import pl.com.softproject.utils.jdbc.JdbcTemplate;
import pl.com.softproject.utils.jdbc.ResultSetHandler;
import pl.com.softproject.utils.swingworker.AbstractTask;
import pl.com.softproject.utils.swingworker.BaseTask;

/**
 *
 * @author altkom
 */
public class LoadCustomersTask extends BaseTask<List<Customer>, Void>{

    ObservableList<Customer> customerList;

    public LoadCustomersTask(ObservableList<Customer> customerList) {
        block();
        this.customerList = customerList;
    }
    
    @Override
    protected List<Customer> doInBackground() throws Exception {
        JdbcTemplate jdbc = new JdbcTemplate();
        
        Thread.sleep(5000);
        
        return jdbc.query(ConnectionServiceImpl.getInstance().getConnection(),
                "select * from customer1", new ResultSetHandler<Customer>() {

            @Override
            public Customer handle(ResultSet rs) throws SQLException {
                Customer t = new Customer();
                t.setAddress(rs.getString("address"));
                t.setName(rs.getString("name"));
                t.setNewsletterAccepted(rs.getBoolean("newsletter_accepted"));
                t.setMail(rs.getString("mail"));
                return t;
            }
        });
    }

    @Override
    protected void succeeded(List<Customer> result) {
        customerList.clear();
        customerList.addAll(result);
    }
    
    
}
