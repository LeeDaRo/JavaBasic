package day0610;
// 학생의 정보를 입력받고 출력하는 프로그램을 작성하시오.
// 해당 프로그램은 다음과 같은 기능이 있습니다.
// 입력 : 학생의 정보를 입력받는다.
// 출력 : 가장 마지막으로 입력된 학생의 정보를 출력한다.
// 종료 : 사용자가 종료를 선택하면 프로그램이 종료되지만
// 그외에는 실행시킬 기능을 입력받아 해당 기능을 실행한다.

// 심화 : 만약 아무런 입력 없이 출력을 선택 할 경우
// "아직 정보가 입력된 학생이 존재하지 않습니다."가 출력되게
// 코드를 작성해보시오.

// 3시 50분 까지
import java.util.Scanner;

public class Ex09GradeBook02 {

//    static int id;
//    static int Mat;
//    static int Kor;
//    static int Eng;
//    static int total;
//    static int go_stop;
//    static String name;
//    static double avg;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //상수
        final int SCORE_MIN = 0;
        final int SCORE_MAX = 100;
        final int SUBJECT_SIZE = 3;
        int id = 0, Mat = 0, Kor = 0, Eng = 0, total = 0, go_stop = 0;
        String name = "";
        double avg =0.0;


        while (true){

            System.out.println("1. 입력  2. 출력  3. 종료");
            System.out.print("> ");
            go_stop = scanner.nextInt();

            if(go_stop == 1) {
                System.out.println("번호를 입력해주세요");
                System.out.print("> ");
                id = scanner.nextInt();

                System.out.println("이름을 입력해주세요");
                System.out.print("> ");
                scanner.nextLine();
                name = scanner.nextLine();

                System.out.println("수학 점수를 입력해주세요");
                System.out.print("> ");
                Mat = scanner.nextInt();

                while (!(Mat >= SCORE_MIN && Mat <= SCORE_MAX)) {
                    System.out.println("수학 점수를 다시 입력해주세요.");
                    System.out.print("> ");
                    Mat = scanner.nextInt();
                }

                System.out.println("국어 점수를 입력해주세요");
                System.out.print("> ");
                Kor = scanner.nextInt();

                while (!(Kor >= SCORE_MIN && Kor <= SCORE_MAX)) {
                    System.out.println("국어 점수를 다시 입력해주세요.");
                    System.out.print("> ");
                    Kor = scanner.nextInt();
                }

                System.out.println("영어 점수를 입력해주세요");
                System.out.print("> ");
                Eng = scanner.nextInt();

                while (!(Eng >= SCORE_MIN && Eng <= SCORE_MAX)) {
                    System.out.println("영어 점수를 다시 입력해주세요.");
                    System.out.print("> ");
                    Eng = scanner.nextInt();
                }

                System.out.println("1. 처음으로  2. 출력  3. 종료");
                System.out.print("> ");
                go_stop = scanner.nextInt();

                if (go_stop == 2) {
                    total = Mat + Kor + Eng;
                    avg = total / (double) SUBJECT_SIZE;
                    System.out.printf("번호 : %d 번,   이름 : %s \n", id, name);
                    System.out.printf("국어 : %03d 점,영어 : %03d 점,수학 : %03d 점 \n", Kor, Eng, Mat);
                    System.out.printf("총점 : %03d 점,평균 : %06.2f 점 \n", total, avg);
                }else if(go_stop == 3){
                    System.out.println("이용해 주셔서 감사합니다.");
                    break;
                }else if(go_stop == 1){
                    System.out.println("처음으로 돌아갑니다.");
                }else {
                    System.out.println("잘못된 입력입니다. 처음으로 돌아갑니다.");
                }

            }else if(go_stop ==3){
                System.out.println("이용해 주셔서 감사합니다.");
                break;

            }else if (go_stop == 2) {
                if(name != null) {
                    total = Mat + Kor + Eng;
                    avg = total / (double) SUBJECT_SIZE;
                    System.out.printf("번호 : %d 번,   이름 : %s \n", id, name);
                    System.out.printf("국어 : %03d 점,영어 : %03d 점,수학 : %03d 점 \n", Kor, Eng, Mat);
                    System.out.printf("총점 : %03d 점,평균 : %06.2f 점 \n", total, avg);
                }else {
                    System.out.println("아직 정보가 입력된 학생이 존재하지 않습니다.");
                }
            }else {
                System.out.println("아직 정보가 입력된 학생이 존재하지 않습니다.");
            }
        }

        scanner.close();

    }
}
