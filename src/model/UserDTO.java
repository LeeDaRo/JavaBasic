package model;

public class UserDTO {
    private int userid;
    private String username;
    private String password;
    private String nickname;



    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public boolean equals(Object obj){
        if (obj instanceof UserDTO){
            UserDTO u = (UserDTO) obj;
            return userid == u.userid;
        }
        return false;
    }

}
