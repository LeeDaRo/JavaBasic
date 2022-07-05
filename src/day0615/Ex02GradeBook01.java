package day0615;
// Student 데이터타입의 배열을 사용하여
// 다섯명의 학생을 관리하는 프로그램을 작성하시오.
// 동적할당 X
// 심화 : 위 프로그램을 완성하신 분들은 ArrayUtil에 Student 타입 배열을
// 동적할당하는 메소드들을 구현하시오.

import struct.Student;
import util.ScannerUtil;
import java.util.Scanner;
import util.ArrayUtil;

public class Ex02GradeBook01 {
    public static void main(String[] args) {
        Student [] arr = new Student[5];
        Scanner scanner = new Scanner(System.in);
        String message;
        int[] total;
        int student, userChoice;
        double[] avg;

        message = "학생의 수를 입력해주세요";
        student = ScannerUtil.nextInt(scanner, message);

        while (student < 0){
            System.out.println("잘못 입력하셨습니다.");
            student = ScannerUtil.nextInt(scanner, message);
        }

        total = new int[student];
        avg = new double[student];

        message = "1. 학생정보입력   2. 학생정보확인  3.프로그램종료";
        userChoice = ScannerUtil.nextInt(scanner, message);
        if (userChoice == 1) {
            for (int i = 0; i < student; i++) {
                arr[i] = new Student();
                arr[i].id = i + 1;
                message = "해당 학생의 이름을 입력해주세요.";
                arr[i].name = ScannerUtil.nextLine(scanner, message);

                message = "해당 학생의 국어 점수를 입력해주세요.";
                arr[i].korean = ScannerUtil.nextInt(scanner, message);

                message = "해당 학생의 영어 점수를 입력해주세요.";
                arr[i].english = ScannerUtil.nextInt(scanner, message);

                message = "해당 학생의 수학 점수를 입력해주세요.";
                arr[i].math = ScannerUtil.nextInt(scanner, message);

                total[i] = arr[i].korean + arr[i].english + arr[i].math;
                avg[i] = (double) total[i] / 3.0;


            }
        }else if (userChoice == 2){
            for (int i = 0; i < student; i++) {
                System.out.printf("%d번  이름 : %s \n", arr[i].id, arr[i].name);
                System.out.printf("국어  : %d점  영어  : %d점  수학  : %d점 \n", arr[i].korean, arr[i].english, arr[i].math);
                System.out.printf("총점  : %d점  평균  : %06.2f점", total[i], avg[i]);
            }

        }else if (userChoice == 3){

        }

    }
}
