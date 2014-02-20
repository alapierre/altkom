/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.altkom.traveloffice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author altkom
 */
public class Singleton {
    
    private static Singleton instance;
    private Connection connection;
    private final String url = "jdbc:postgresql//localhost/tempdb";
    
    private Singleton() {
    }
    
    public static Singleton getInstance() {
        if(instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
    
    public Connection createConnection(String user, String password) throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
        return connection;
    }
    
    public void closeConnection() throws SQLException {
        if(connection != null)
            connection.close();
    }
    
    public Connection getConnection() {
        if(connection != null) 
            return connection;
        
        throw new IllegalStateException("najpierw wywołaj createConnection");
    }
}
