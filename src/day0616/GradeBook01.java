package day0616;

import util.ScannerUtil;

import java.util.Scanner;

// 5명의 학생을 Student2 객체로 관리하는
// 프로그램을 작성하시되
// 메뉴 출력, 학생 입력, 학생 출력은 static 메소드로 분리하여
// 만드시오
// 단, 학생 출력의 경우, 목록 보기, 개별 보기 등의 기능은 필요하지 않습니다.
public class GradeBook01 {
    public static Scanner scanner;
    public static String msg;
    public static int indexId = 1;
    public static Student2[] array;

    public static final int SCORE_MIN = 0;
    public static final int SCORE_MAX = 100;

    public static void main(String[] args) {

    }

    //
    public static void init(){
        msg = "1. 입력  2. 출력  3. 종료";
        int userChoice = ScannerUtil.nextInt(scanner, msg);
        if (userChoice == 1) {

        }

    }

    public static void showMenu(){
        Student2 s2 = new Student2();
        msg = "몇명의 학생의 정보를 입력하시겠습니까?";
        int temp = ScannerUtil.nextInt(scanner, msg);

        while (temp < 1 || temp > 5) {
            temp = ScannerUtil.nextInt(scanner, msg);
        }
        for (int i =0 ; i < temp; i++) {
            s2.setId(indexId++);
            msg = "학생의 이름을 입력해주세요";
            s2.setName(ScannerUtil.nextLine(scanner, msg));
            msg = "국어 점수를 입력해주세요";
            s2.setKor(ScannerUtil.nextInt(scanner, msg, SCORE_MIN, SCORE_MAX));
            msg = "영어 점수를 입력해주세요";
            s2.setEng(ScannerUtil.nextInt(scanner, msg, SCORE_MIN, SCORE_MAX));
            msg = "수학 점수를 입력해주세요";
            s2.setMath(ScannerUtil.nextInt(scanner, msg, SCORE_MIN, SCORE_MAX));
        }
    }
}
