
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import pl.altkom.traveloffice.model.Trip;
import pl.com.softproject.utils.jdbc.ConnectionServiceImpl;
import pl.com.softproject.utils.jdbc.JdbcTemplate;
import pl.com.softproject.utils.jdbc.ResultSetHandler;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author altkom
 */
public class DBTest2 {
    
    public static void main(String[] args) {
        ConnectionServiceImpl.getInstance().connect("jdbc:derby://localhost:1527/travel-office", "sa", "sa");
        Connection conn = ConnectionServiceImpl.getInstance().getConnection();
    
        JdbcTemplate jdbc = new JdbcTemplate();
        
        List<Trip> trips = jdbc.query(conn, "select * from trip", new ResultSetHandler<Trip>() {

            @Override
            public Trip handle(ResultSet rs) throws SQLException {
                Trip t = new Trip();
                t.setDestination(rs.getString("destination"));
                t.setId(rs.getInt("id"));
                return t;
            }
        });
        
        System.out.println(trips);
        
        ConnectionServiceImpl.getInstance().disconnect();
    }
    
}
