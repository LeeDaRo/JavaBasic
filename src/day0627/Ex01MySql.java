package day0627;

import day0616.Student;

import java.sql.*;
import java.util.ArrayList;

public class Ex01MySql {
    public static void main(String[] args) {
        Connection conn;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("드라이버 로딩 성공");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sqlbasic","root","0000");
            System.out.println("MySql연결 성공");

            // 1. insert
            // String query = "INSERT INTO student (`name`, `korean`, `english`, `math`)" + "values(\"이창주\", 80, 80, 81)";
            String query = "INSERT INTO student (`name`, `korean`, `english`, `math`)" + "values(?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1,"권혁하");
            ps.setInt(2, 90);
            ps.setInt(3, 90);
            ps.setInt(4, 91);

            ps.executeUpdate();
            System.out.println("insert 성공!!!");

            // 2. update
            query = "UPDATE `student` SET `name` = ? WHERE id = ?";
            ps = conn.prepareStatement(query);
            ps.setString(1,"쿼카");
            ps.setInt(2, 1);

            ps.executeUpdate();
            System.out.println("update 성공");

            // 3. delete
            query = "DELETE FROM `student` WHERE id = ? ";
            ps = conn.prepareStatement(query);
            ps.setInt(1, 1);
            ps.executeUpdate();

            System.out.println("delete 성공");

            // selectOne()
            Student s = new Student();

            query = "SELECT * FROM `student` WHERE id = ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, 3);
            ResultSet rs = ps.executeQuery();
            rs.next();

            s.id = rs.getInt("id");
            s.name = rs.getString("name");
            s.kor = rs.getInt("korean");
            s.eng = rs.getInt("english");
            s.math = rs.getInt("math");

            s.printInfo();

            // selectAll()
            ArrayList<Student> list = new ArrayList<>();
            query = "SELECT * FROM `student`";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()){
                Student temp = new Student();
                temp.id = rs.getInt("id");
                temp.name = rs.getString("name");
                temp.kor = rs.getInt("korean");
                temp.eng = rs.getInt("english");
                temp.math = rs.getInt("math");

                list.add(temp);

            }
            System.out.println("list.size() : " + list.size());
            for (Student st : list){
                st.printInfo();
            }
            conn.close();

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("문제 발생!!");
            e.printStackTrace();

        } finally {
            //try, catch 문제가 있던 없던 블록을 실행하고 무조건 다음으로 실행한다.
            System.out.println("finally 코드 블록 실행");
        }

    }

}
