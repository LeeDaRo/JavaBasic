package hw;

import java.util.Scanner;
import util.ArrayUtil;
import util.ScannerUtil;
import struct.Student;

public class Mytest_Student_02 {
    // 출력하기를
    // 목록 간단하게 출력하기 -> 개별 학생 상세보기 -> 수정 / 삭제
    // 로 업그레이드한 삭생 정보 관리 프로그램
    public static Scanner scanner;
    public static String msg;
    public static int indexId;
    public static Student [] array;

    public static final int SUBJECT_SIZE = 3;
    public static final int SCORE_MIN = 0;
    public static final int SCORE_MAX = 100;

    public static void main(String[] args) {
        init();
        showMenu();

        scanner.close();
    }

    // 전역 변수를 초기화 시킨다. init()
    public static void init(){
        scanner = new Scanner(System.in);
        indexId = 1;
        array = new Student[0];
    }

    // 메뉴 출력 메소드 showMenu()
    public static void showMenu(){


        while (true) {
            msg ="1. 입력  2. 출력  3.종료";
            int userChoice = ScannerUtil.nextInt(scanner, msg);
            if (userChoice == 1) {
                insert();
            } else if (userChoice == 2) {
                printAll();
            } else if (userChoice == 3) {
                System.out.println("이용해주셔서 감사합니다.");
                break;
            }
        }

    }

    // 학생의 정보를 입력하는 부분 insert()
    public static void insert(){
        Student temp = new Student();
        temp.id = indexId++;
        msg = "학생의 이름을 입력해주세요.";
        temp.name = ScannerUtil.nextLine(scanner, msg);
        msg = "국어 점수를 입력해주세요.";
        temp.korean = ScannerUtil.nextInt(scanner, msg, SCORE_MIN, SCORE_MAX);
        msg = "영어 점수를 입력해주세요.";
        temp.english = ScannerUtil.nextInt(scanner, msg, SCORE_MIN, SCORE_MAX);
        msg = "수학 점수를 입력해주세요.";
        temp.math = ScannerUtil.nextInt(scanner, msg, SCORE_MIN, SCORE_MAX);

        array = ArrayUtil.add(array, temp);
    }

    // 학생의 목록을 간략하게 출력하는 printALl()
    public static void printAll(){
        if (!ArrayUtil.isEmpty(array)) {
            Student temp = new Student();
            for (Student s : array) {
                System.out.printf("번호 : %d번  이름 : %s \n", s.id, s.name);
            }

            msg = "상세보기할 학생의 번호를 입력하세요. 뒤로가기는 0번";
            int userChoice = ScannerUtil.nextInt(scanner, msg);
            temp.id = userChoice;

            while (userChoice != 0 && !ArrayUtil.contains(array, temp)) {
                System.out.println("해당 학생은 존재하지 않습니다.");
                userChoice = ScannerUtil.nextInt(scanner, msg);

            }

            if (ArrayUtil.contains(array, temp)) {
                printOne(userChoice);
            }
        }else {
            System.out.println("입력된 정보가 없습니다.");
        }
    }

    // 학생의 정보를 출력하기 위한 메소드 printOne()
    public static void printOne(int id){
        Student temp = selectOne(id);

        int sum = temp.korean + temp.math + temp.english;
        double avg = (double) sum/3.0;
        System.out.printf("번호 : %d번  이름: %s\n",temp.id,temp.name);
        System.out.printf("국어 : %03d점  영어 : %03d점  수학 : %03d점\n", temp.korean, temp.english, temp.english);
        System.out.printf("총점 : %03d점  평균 : %06.2f\n", sum, avg);

        msg = "1. 정보수정  2. 정보삭제  3. 뒤로가기";
        int userChoice = ScannerUtil.nextInt(scanner, msg);
        while (userChoice < 1 || userChoice > 3) {
            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            userChoice = ScannerUtil.nextInt(scanner, msg);
        }

        if (userChoice == 1) {
            update(id);
        } else if (userChoice == 2) {
            delete(id);
        } else if (userChoice == 3) {
            printAll();
        }

    }

    // 수정 할 메소드 update()
    public static void update(int id){
        Student temp = selectOne(id);

        msg = "학생의 이름을 입력해주세요.";
        temp.name = ScannerUtil.nextLine(scanner, msg);
        msg = "국어 점수를 입력해주세요.";
        temp.korean = ScannerUtil.nextInt(scanner, msg, SCORE_MIN, SCORE_MAX);
        msg = "영어 점수를 입력해주세요.";
        temp.english = ScannerUtil.nextInt(scanner, msg, SCORE_MIN, SCORE_MAX);
        msg = "수학 점수를 입력해주세요.";
        temp.math = ScannerUtil.nextInt(scanner, msg, SCORE_MIN, SCORE_MAX);

        printOne(id);

    }

    // 삭제 할 메소드 delete()
    public static void delete(int id){
        Student temp = new Student();
        temp.id = id;
        msg = "삭제를 원하는가? Y / N";
        String userChoice = ScannerUtil.nextLine(scanner, msg);
        if (userChoice.equalsIgnoreCase("Y")){
            array = ArrayUtil.remove(array, ArrayUtil.indexOf(array,temp));
            printAll();
        }else {
            printOne(id);
        }

    }

    // 입력한 값을 다시 호출하기위해 메소드로 정의 하기 selectOne()
    public static Student selectOne(int id){
        Student result = null;
        Student temp =new Student();
        temp.id = id;

        if (ArrayUtil.contains(array,temp)){
            result = ArrayUtil.get(array, ArrayUtil.indexOf(array,temp));
        }

        return result;
    }
}
