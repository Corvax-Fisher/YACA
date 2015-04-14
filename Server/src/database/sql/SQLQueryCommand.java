package database.sql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

interface SQLQueryCommand {
	Object[] execute(Connection conn) throws SQLException;
}
