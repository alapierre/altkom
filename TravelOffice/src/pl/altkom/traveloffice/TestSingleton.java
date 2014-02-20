/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.altkom.traveloffice;

import java.sql.SQLException;

/**
 *
 * @author altkom
 */
public class TestSingleton {
    
    public static void main(String[] args) throws SQLException {
        
        Singleton.getInstance().createConnection("admin", "secret");
        // ................
        Singleton.getInstance().getConnection();
        // ................
        Singleton.getInstance().closeConnection();
    }
    
}
