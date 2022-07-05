package day0616;

import java.util.Scanner;

public class Ex02Student {
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student();
        System.out.println(s2.equals(s1));
        Scanner scanner = new Scanner(System.in);

        System.out.println(s1.equals(scanner));

        System.out.println(s1.id);
        System.out.println(s1.name);

        s1.id = 1;
        s1.name = "DaRo";
        s1.kor = 10;
        s1.eng = 10;
        s1.math = 11;

        System.out.println(s1.id);
        System.out.println(s1.name);

        System.out.println("s1 총점 : " + s1.calculateSum());
        System.out.println("s1 평균 : " + s1.calculateAverage());

        Student2 s3 = new Student2(4, "1", 50, 50, 51);
        // 캡슐화가 적용되었을 경우
        // 필드에 값을 저장할 때에는 우리가 해당 객체의 setter 메소드를
        // 통하여 값을 저장하게 된다.
        s3.setId(10);
        s3.setName("이름");
        s3.setKor(10);
        s3.setEng(10);
        s3.setMath(11);

        // 특정 필드의 저장되어 있는 값을 호출할 때에는
        // getter를 사용한다.
        System.out.println("s3.getName : " + s3.getName());

        // 만약 외부가 접근 가능한 메소드라면?
        // 그냥 기존의 방법처럼 호출하면 된다.
        s3.printInfo();

        System.out.println(s3);
    }
}