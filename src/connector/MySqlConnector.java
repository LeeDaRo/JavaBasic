package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnector implements DBConnector{
    private final String ADDRESS = "jdbc:mysql://localhost:3306/board";
    private final String USERNAME = "root";
    private final String PASSWORD = "0000";

    @Override
    public Connection makeConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(ADDRESS, USERNAME, PASSWORD);
            System.out.println("mySql DB connection 성공");
            return conn;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();

        }
        return null;
    }
}
