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

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import pl.com.softproject.utils.jdbc.exceptions.IncorrectResultSetColumnCountException;

/**
 *
 * @author Adrian Lapierre
 */
public class SingleColumnResultSetHandler<T> implements ResultSetHandler<T> {

    private Class<T> clazz;

    public SingleColumnResultSetHandler(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public T handle(ResultSet rs) throws SQLException {

        ResultSetMetaData rsmd = rs.getMetaData();

        int nrOfColumns = rsmd.getColumnCount();
		if (nrOfColumns != 1) {
			throw new IncorrectResultSetColumnCountException(1, nrOfColumns);
		}

        T result = (T) JdbcUtils.getResultSetValue(rs, 1, clazz);

        return result;
    }



}
