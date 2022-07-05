package model;

public class ReplyDTO {
    private int replyid;
    private int userid;
    private int boardid;
    private String content;

    public int getReplyid() {
        return replyid;
    }

    public void setReplyid(int replyid) {
        this.replyid = replyid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getBoardid() {
        return boardid;
    }

    public void setBoardid(int boardid) {
        this.boardid = boardid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public boolean equals(Object obj){
        if (obj instanceof ReplyDTO){
            ReplyDTO r = (ReplyDTO) obj;
            return replyid == r.replyid;
        }
        return false;
    }
}
