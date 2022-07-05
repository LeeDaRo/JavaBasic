package controller;

import connector.DBConnector;
import model.BoardDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardController {
    private Connection conn;
    public BoardController(DBConnector connector){
        this.conn = connector.makeConnection();
    }

    public ArrayList<BoardDTO> selectAll(){
        ArrayList<BoardDTO> list = new ArrayList<>();
        String query = "SELECT * FROM `board`";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                BoardDTO b = new BoardDTO();
                b.setBoardid(rs.getInt("id"));
                b.setUserid(rs.getInt("writerid"));
                b.setTitle(rs.getString("title"));
                b.setContent(rs.getString("content"));


                list.add(b);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public BoardDTO selectOne(int id){
        String query = "SELECT * FROM `board` WHERE id = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1,id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()){
                BoardDTO b = new BoardDTO();

                b.setBoardid(rs.getInt("id"));
                b.setUserid(rs.getInt("writerid"));
                b.setTitle(rs.getString("title"));
                b.setContent(rs.getString("content"));

                return b;
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }

        return null;
    }

    // 새로운 정보를 추가하는
    // inset()
    public void insert(BoardDTO b){
        String query = "INSERT INTO `board`(`writerid`, `title`, `content`) values(?, ?, ?)";

        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, b.getUserid());
            pstmt.setString(2, b.getTitle());
            pstmt.setString(3, b.getContent() );

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // 4. 기존 학생 정보를 수정하는
    // update()
    public void update(BoardDTO b){
        String query = "UPDATE `board` SET `writerid` = ?, `title` = ?,`content` = ? WHERE id = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, b.getUserid());
            pstmt.setString(2, b.getTitle());
            pstmt.setString(3, b.getContent() );
            pstmt.setInt(4,b.getBoardid());

            pstmt.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 5. 기존 학생 정보를 삭제하는
    // delete()
    public void delete(int id){
        String query = "DELETE FROM `board` WHERE id = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
