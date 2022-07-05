package day0630;

import connector.MySqlConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Ex03MySqlTime {
    public static void main(String[] args) {
        MySqlConnector connector = new MySqlConnector();
        Connection conn = connector.makeConnection();

        String query = "SELECT * FROM `board`.`time`";
        try {
            PreparedStatement ps = conn.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                System.out.println(rs.getDate("dateTime"));
                System.out.println(rs.getTime("dateTime"));

                Calendar cal = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("y/M/d H:m:s");

                System.out.println(rs.getTimestamp("dateTime"));
                cal.setTime(rs.getTimestamp("dateTime"));

                System.out.println(cal.getTime());
                System.out.println(sdf.format(cal.getTime()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
