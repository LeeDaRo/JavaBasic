package controller;

import connector.DBConnector;
import model.ReplyDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReplyController {
    private Connection conn;
    public ReplyController(DBConnector connector){
        this.conn = connector.makeConnection();
    }

    public ArrayList<ReplyDTO> selectAll(){
        ArrayList<ReplyDTO> list = new ArrayList<>();
        String query = "SELECT * FROM `reply`";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                ReplyDTO r = new ReplyDTO();
                r.setReplyid(rs.getInt("id"));
                r.setUserid(rs.getInt("writerid"));
                r.setBoardid(rs.getInt("boardid"));
                r.setContent(rs.getString("replycontent"));


                list.add(r);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public ReplyDTO selectOne(int id){
        String query = "SELECT * FROM `reply` WHERE id = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1,id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()){
                ReplyDTO r = new ReplyDTO();

                r.setReplyid(rs.getInt("id"));
                r.setBoardid(rs.getInt("boardid"));
                r.setUserid(rs.getInt("writerid"));
                r.setContent(rs.getString("replycontent"));

                return r;
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }

        return null;
    }

    // 새로운 정보를 추가하는
    // inset()
    public void insert(ReplyDTO r){
        String query = "INSERT INTO `reply`(`boardid`, `writerid`, `replycontent`) values(?, ?, ?)";

        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, r.getBoardid());
            pstmt.setInt(2, r.getUserid());
            pstmt.setString(3, r.getContent() );

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // 4. 기존 학생 정보를 수정하는
    // update()
    public void update(ReplyDTO r){
        String query = "UPDATE `reply` SET `writerid` = ?, `title` = ?,`content` = ? WHERE id = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, r.getBoardid());
            pstmt.setInt(2, r.getUserid());
            pstmt.setString(3, r.getContent() );
            pstmt.setInt(4, r.getReplyid());

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
