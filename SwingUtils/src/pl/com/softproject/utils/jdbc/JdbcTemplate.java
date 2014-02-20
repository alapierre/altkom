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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;
import pl.com.softproject.utils.jdbc.exceptions.DataAccessException;
import pl.com.softproject.utils.jdbc.exceptions.DataRetrievalFailureException;

/**
 *
 * @author Adrian Lapierre
 */
public class JdbcTemplate {

    protected Logger logger = Logger.getLogger(JdbcTemplate.class.getName());

    public <T> T queryForObject(Connection connection, String sql, Class<T> requiredType) throws DataAccessException {
        List results = queryForOneColumnList(connection, sql, requiredType);
        return (T) DataAccessUtils.requiredSingleResult(results);
    }

    public String queryForString(Connection connection, String sql) {
        return queryForObject(connection, sql, String.class);
    }

    public long queryForLong(Connection connection, String sql) throws DataAccessException {
        return queryForObject(connection, sql, Long.class);
    }

    public int queryForInt(Connection connection, String sql) throws DataAccessException {
        return queryForObject(connection, sql, Integer.class);
    }

    public <T> List<T> queryForOneColumnList(Connection connection, String sql, Class<T> clazz) {
        return query(connection, sql, new SingleColumnResultSetHandler<T>(clazz));
    }

    public void executeQuery(Connection connection, String sql) {

        Statement stmt = null;

        try {
            try {
                stmt = connection.createStatement();
            } catch (SQLException ex) {
                throw new DataAccessException("Error creating statement", ex);
            }

            try {
                stmt.executeUpdate(sql);
            } catch (SQLException ex) {
                throw new DataAccessException("Error executing query", ex);
            }
        } finally {
            JdbcUtils.closeStatement(stmt);
        }
    }

    public <T> List<T> query(Connection connection, String sql, ResultSetHandler<T> handler) {

        Statement stmt = null;
        List<T> result = new LinkedList<T>();
        ResultSet rs = null;

        try {
            try {
                stmt = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            } catch (SQLException ex) {
                throw new DataAccessException("Error creating statement", ex);
            }

            try {
                rs = stmt.executeQuery(sql);
            } catch (SQLException ex) {
                throw new DataAccessException("Error executing query", ex);
            }

            try {
                while (rs.next()) {
                    result.add(handler.handle(rs));
                }
            } catch (SQLException ex) {
                throw new DataRetrievalFailureException("Error handling result", ex);
            }
        } finally {
            JdbcUtils.closeResultSet(rs);
            JdbcUtils.closeStatement(stmt);
        }

        return result;
    }
}
