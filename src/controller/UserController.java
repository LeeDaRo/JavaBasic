package controller;

import connector.DBConnector;
import model.UserDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserController {
    private Connection conn;

    public UserController(DBConnector connector){
        this.conn = connector.makeConnection();
    }

    public ArrayList<UserDTO> selectAll(){
        ArrayList<UserDTO> list = new ArrayList<>();
        String query = "SELECT * FROM `user`";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                UserDTO u = new UserDTO();
                u.setUserid(rs.getInt("id"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setNickname(rs.getString("nickname"));

                list.add(u);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public UserDTO selectOne(int id){
        String query = "SELECT * FROM `user` WHERE id = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1,id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()){
                UserDTO u = new UserDTO();

                u.setUserid(rs.getInt("id"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setNickname(rs.getString("nickname"));

                return u;
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }

        return null;
    }

    // 새로운 정보를 추가하는
    // inset()
    public void insert(UserDTO u){
        String query = "INSERT INTO `user`(`username`, `password`, `nickname`) values(?, ?, ?)";

        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, u.getUsername() );
            pstmt.setString(2, u.getPassword());
            pstmt.setString(3, u.getNickname() );

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // 4. 기존 학생 정보를 수정하는
    // update()
    public void update(UserDTO u){
        String query = "UPDATE `user` SET `password` = ?, `nickname` = ? WHERE id = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, u.getPassword());
            pstmt.setString(2, u.getNickname() );
            pstmt.setInt(3, u.getUserid() );

            pstmt.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 5. 기존 학생 정보를 삭제하는
    // delete()
    public void delete(int id){
        String query = "DELETE FROM `user` WHERE id = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public boolean auth(String userName, String userPw){
        String query = "SELECT * FROM `user` WHERE username = ? and password = ? ";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, userName);
            ps.setString(2, userPw);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                UserDTO u = new UserDTO();
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public UserDTO userId(String userName, String userPw){
        String query = "SELECT * FROM `user` WHERE username = ? and password = ? ";

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, userName);
            ps.setString(2, userPw);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                UserDTO u = new UserDTO();
                u.setUserid(rs.getInt("id"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setNickname(rs.getString("nickname"));
                return u;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
