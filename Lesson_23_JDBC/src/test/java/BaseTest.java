import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseTest
{
    public static final String dbAdress = "jdbc:postgresql://rd.cfvw8lxtimwu.eu-central-1.rds.amazonaws.com:5432/golovach";
    public static final String dbUser = "golovach";
    public static final String dbPassword = "golovach123$";

    private static final Logger log = LogManager.getLogger(BaseTest.class);

    protected Connection getConnection() throws SQLException {
        return DBConnection.getInstance(dbAdress, dbUser, dbPassword).getConnection();
    }

}
