/* 
 * Copyright 2012-11-21 the original author or authors.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 */
package pl.com.softproject.utils.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;
import pl.com.softproject.utils.jdbc.exceptions.CreateConnectionException;
import pl.com.softproject.utils.jdbc.exceptions.DataAccessException;

/**
 *
 * @author Adrian Lapierre <alapierre@softproject.com.pl>
 */
public class ConnectionServiceImpl {

    Logger logger = Logger.getLogger(ConnectionServiceImpl.class.getName());

    private Connection connection;
    private static ConnectionServiceImpl instance;

    private ConnectionServiceImpl() {
    }

    public static ConnectionServiceImpl getInstance() {

        if (instance == null) {
            instance = new ConnectionServiceImpl();
        }

        return instance;
    }

    /**
     * Connect to the database
     *
     * @param ulr
     * @param user
     * @param pass
     * @throws CreateConnectionException
     */
    public void connect(String ulr, String user, String pass) throws CreateConnectionException {

        disconnect();

        try {
            connection = DriverManager.getConnection(ulr, user, pass);
        } catch (SQLException ex) {
            throw new CreateConnectionException(ex.getMessage(), ex);
        }
    }

    /**
     * Disconect from the database
     */
    public void disconnect() {
        if (connection != null) {
            JdbcUtils.closeConnection(connection);
        }
    }

    /**
     * Return connection to database. If connection is null or is colse
     * method throws DataAccessException
     *
     * @return ready to use jdbc connection
     */
    public Connection getConnection() throws DataAccessException {

        try {
            if (connection != null) {
                if (connection.isClosed()) {
                    throw new DataAccessException("connection is close");
                }
            } else {
                throw new DataAccessException("Connection is null");
            }
        } catch (SQLException ex) {
            throw new DataAccessException(ex.getMessage(), ex);
        }

        return connection;
    }
}
