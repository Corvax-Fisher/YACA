package database.sql;

import java.sql.Connection;
import java.sql.SQLException;

interface SQLUpdateCommand {
	int execute(Connection conn) throws SQLException;
}
