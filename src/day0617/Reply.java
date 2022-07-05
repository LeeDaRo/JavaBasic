package day0617;
// POJO
// Playn Old Java Object
// -> 옛날의 병범한 자바 객체
// -> 필드에 다른 클래스타입의 필드는 사용을 최소화하자!


public class Reply {
    // 필드
    private int id;
    private String content;
    private int boardId;

    // 메소드

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getBoardId() {
        return boardId;
    }

    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }

    public boolean equals(Object obj){
        if (obj instanceof Reply){
            Reply r = (Reply) obj;
            return id == r.id;
        }
        return false;
    }

    public void print(){
        System.out.println("댓글 : " + content);
    }
}
