package model;

public class BoardDTO {
    private int boardid;
    private int userid;
    private String title;
    private String content;

    public int getBoardid() {
        return boardid;
    }

    public void setBoardid(int boardid) {
        this.boardid = boardid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean equals(Object obj){
        if (obj instanceof BoardDTO){
            BoardDTO b = (BoardDTO) obj;
            return boardid == b.boardid;
        }
        return false;
    }
}
