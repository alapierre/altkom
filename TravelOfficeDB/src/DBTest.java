
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.derby.client.am.SqlException;
import pl.altkom.traveloffice.model.Trip;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author altkom
 */
public class DBTest {
    
    public static void main(String[] args) throws ClassNotFoundException {
        
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        
        try {
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/travel-office", "sa", "sa");
            PreparedStatement stmt = conn.prepareStatement("select * from trip where id = ?");
            
            stmt.setInt(1, 2);
            
            ResultSet rs = stmt.executeQuery();
            
            
            while(rs.next()) {
                int id = rs.getInt("id");
                String destination = rs.getString("destination");
                BigDecimal price = rs.getBigDecimal("price");
                
                
                System.out.println(id + " " + destination + " " + price);
            }
            
            rs.close();
            stmt.close();
            conn.close();
            
        } catch (SQLException ex) {
            System.out.println("błąd połączenia z bazą danych");
            ex.printStackTrace();
        }
    }
    
}
