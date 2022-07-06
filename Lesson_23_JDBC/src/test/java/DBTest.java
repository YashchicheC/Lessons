import org.testng.annotations.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTest extends BaseTest {
    @Test
    public void baseSelect() throws SQLException
    {
        String sqlPattern = "SELECT * FROM student WHERE id >?";
        PreparedStatement preparedStatement = getConnection().prepareStatement(sqlPattern);

        preparedStatement.setInt(1, 1);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            System.out.printf("Student: %s %s \n", rs.getString("first_name"), rs.getString("last_name"));
        }
    }
   @Test
    public void baseInsert() throws SQLException {
        String sqlPattern = "INSERT INTO student VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = getConnection().prepareStatement(sqlPattern);
        preparedStatement.setInt(1, 3);
        preparedStatement.setString(2, "New");
        preparedStatement.setString(3, "Blah");

        System.out.printf("%d rows added", preparedStatement.executeUpdate());
    }

    @Test
    public void baseUpdate() throws SQLException {
        String sqlPattern = "INSERT INTO student VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = getConnection().prepareStatement(sqlPattern);
        preparedStatement.setString(1, "Mykola");
        preparedStatement.setInt(2, 3);
        preparedStatement.setString(3, "Kovalchuk");

        int rows = preparedStatement.executeUpdate();
        System.out.printf("%d rows added", rows);
    }

    @Test
    public void baseDelete() throws SQLException {
        String sqlPattern = "DELETE FROM student WHERE last_name=?";
        PreparedStatement preparedStatement = getConnection().prepareStatement(sqlPattern);
        preparedStatement.setString(1, "Kovalchuk");

        int rows = preparedStatement.executeUpdate();
        System.out.printf("%d rows deleted", rows);
    }
}

