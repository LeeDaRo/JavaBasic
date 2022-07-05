package day0617;

public class Board {
    // 필드
    private int id;
    private String writer;
    private String title;
    private String content;

    // 메소드


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
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
        if (obj instanceof Board){
            Board b = (Board) obj;
            return id == b.id;
        }

        return false;
    }

    public void print(){
        System.out.println("\n=========================");
        System.out.println(title);
        System.out.println("-------------------------");
        System.out.println("글번호 : " + id);
        System.out.println("작성자 : " + writer);

        System.out.println("-------------------------");
        System.out.println(content);
        System.out.println("=========================\n");
    }
    public Board(int id){
        this.id = id;
    }

    public Board(){

    }

    public Board(Board origin){
        this.id = origin.id;
        this.writer = origin.writer;
        this.title = origin.title;
        this.content = origin.content;
    }
}
