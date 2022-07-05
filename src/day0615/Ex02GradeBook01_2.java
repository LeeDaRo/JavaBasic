package day0615;
import java.util.Scanner;
import util.ArrayUtil;
import struct.Student;
import util.ScannerUtil;

public class Ex02GradeBook01_2 {
    public static Student [] array;
    public static int nextIndex;
    public static Scanner scanner;
    public static final int SUBJECT_SIZE = 3;
    public static final int STUDEXT_SIZE = 5;
    public static final int SCORE_MIN = 0;
    public static final int SCORE_MAX = 100;

    public static void init(){
        array = new Student[STUDEXT_SIZE];
        nextIndex = 1;
        scanner = new Scanner(System.in);

    }

    public static void showMenu(){
        while (true){
            String message = "1. 입력  2. 출력  3. 종료";
            int userChoice = ScannerUtil.nextInt(scanner, message);
            if (userChoice == 1){

            }else if (userChoice == 2){

            }else if (userChoice == 3){
                System.out.println("사용해주셔서 감사합니다.");
                break;
            }
        }
    }

    public static void insert(){
        if (nextIndex < STUDEXT_SIZE){
            // 아직 배열에 빈 자리가 있으므로 입력가능

            // 정보를 저장할 Student 변수
            Student s = new Student();
            // 번호 입력
            String messge = "학생의 번호를 입력해주세요.";
            s.id = ScannerUtil.nextInt(scanner, messge);

            // 이름 입력
            messge = "학생의 이름를 입력해주세요.";
            s.name = ScannerUtil.nextLine(scanner, messge);

            // 국어 점수 입력
            messge = "학생의 국어 점수를 입력해주세요.";
            s.korean = ScannerUtil.nextInt(scanner, messge, SCORE_MIN, SCORE_MAX);

            // 영어 점수 입력
            messge = "학생의 영어 점수를 입력해주세요.";
            s.english = ScannerUtil.nextInt(scanner, messge, SCORE_MIN, SCORE_MAX);

            // 수학 점수 입력
            messge = "학생의 수학 점수를 입력해주세요.";
            s.math = ScannerUtil.nextInt(scanner, messge, SCORE_MIN, SCORE_MAX);

            // 배열에 추가
            array[nextIndex] = s;
            //nextIndex를 1 증가시켜서 다음 입력할 인덱스를 저장
            nextIndex++;
        }else {
            // 더이상 배열에 빈 자리가 없으므로 경고 메시지 출력
            System.out.println("더이상 입력 공간이 없어 입력이 불가능합니다.");

        }
    }
    public static void print(){
        if (nextIndex == 0){
            System.out.println("아직 입력된 학생이 존재하지 않습니다.");
        } else {
            for (int i = 0; i < nextIndex; i++){
                Student s = array[i];

            }
            for (Student s : array){
                int sum = s.korean + s.english + s.math;
                double avg = (double) sum / SUBJECT_SIZE;

                System.out.printf("%d번  이름 : %s \n", s.id, s.name);
                System.out.printf("국어  : %d점  영어  : %d점  수학  : %d점 \n", s.korean, s.english, s.math);
                System.out.printf("총점  : %d점  평균  : %06.2f점", sum, avg);
            }
        }
    }

    public static void main(String[] args) {
        init();
        showMenu();
        scanner.close();
    }
}
