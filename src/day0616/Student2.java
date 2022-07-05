package day0616;

// 캡슐화가 적용된 Student 클래스

public class Student2 {
    // 필드
    private int id;
    private String name;
    private int kor;
    private int eng;
    private int math;
    private final int SUBJECT_SIZE = 3;

    // 메소드
    // 갯터 / 셋터

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public int getKor() {
        return kor;
    }

    public void setKor(int kor) {
        this.kor = kor;
    }

    public int getEng() {
        return eng;
    }

    public void setEng(int eng) {
        this.eng = eng;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public void setName(String name){
        this.name =name;
    }

    public String getName(){
        return this.name;
    }


    private int calculateSum(){
        return kor + eng + math;

    }

    private double calculateAverage(){
        return (double)calculateSum() / SUBJECT_SIZE;
    }

    public Student2(int id, String name, int kor, int eng, int math) {
        this.id = id;
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    public Student2(){
        id = -1;
        name = "뭔가";
        kor = -1;
        eng = -1;
        math = -1;
    }

    public boolean equals(Object obj){
        if (obj instanceof Student2){
            Student2 s = (Student2)obj;
            return id == s.id;
        }

        return false;
    }

    public void printInfo(){
        System.out.printf("번호 : %d번  이름 : %s \n", id, name);
        System.out.printf("국어 : %03d점  영어 : %03d점 수학 : %03d점 \n", kor, eng, math);
        System.out.printf("총점 : %03d점  평균 : %06.2f점 \n", calculateSum(), calculateAverage());
    }

    public String toString(){
        return  "id : " + id +
                ", name : " + name +
                ", kor : " + kor +
                ", eng : " + eng +
                ",math : " + math;
    }
}
