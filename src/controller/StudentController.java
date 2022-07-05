package controller;

import connector.DBConnector;
import model.StudentDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentController {
    private Connection conn;

    public StudentController(DBConnector connector){
        this.conn = connector.makeConnection();
    }

    // 1. 현재 테이브렝 저장된 모든 학생을 리턴하는
    // selectAll()

    public ArrayList<StudentDTO> selectAll(){
        ArrayList<StudentDTO> list = new ArrayList<>();
        String query = "SELECT * FROM `student`";

        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            // executeQuery = 값을 불러오기위한 쿼리문.

            while (rs.next()){
                StudentDTO st = new StudentDTO();

                st.setId(rs.getInt("id"));
                st.setName(rs.getString("name"));
                st.setKorean(rs.getInt("korean"));
                st.setEnglish(rs.getInt("english"));
                st.setMath(rs.getInt("math"));

                list.add(st);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // 2. 현재 테이블에 특정 id 값을 가진
    // 객체를 리턴하는 selectOne()
    public StudentDTO selectOne(int id){
        String query = "SELECT * FROM `student` WHERE id = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1,id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()){
                StudentDTO st = new StudentDTO();

                st.setId(rs.getInt("id"));
                st.setName(rs.getString("name"));
                st.setKorean(rs.getInt("korean"));
                st.setEnglish(rs.getInt("english"));
                st.setMath(rs.getInt("math"));

                return st;
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }

        return null;
    }

    // 새로운 정보를 추가하는
    // inset()
    public void insert(StudentDTO st){
        String query = "INSERT INTO `student`(`name`, `korean`, `english`, `math`) values(?, ?, ?, ?)";

        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, st.getName());
            pstmt.setInt(2, st.getKorean());
            pstmt.setInt(3, st.getEnglish());
            pstmt.setInt(4, st.getMath());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // 4. 기존 학생 정보를 수정하는
    // update()
    public void update(StudentDTO st){
        String query = "UPDATE `student` SET `name` = ?, `korean` = ?, `english` = ?, `math` = ? WHERE id = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, st.getName());
            pstmt.setInt(2, st.getKorean());
            pstmt.setInt(3, st.getEnglish());
            pstmt.setInt(4, st.getMath());
            pstmt.setInt(5, st.getId());

            pstmt.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 5. 기존 학생 정보를 삭제하는
    // delete()
    public void delete(int id){
        String query = "DELETE FROM `student` WHERE id = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
