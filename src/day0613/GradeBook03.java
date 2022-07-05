package day0613;
// 다섯명의 학생의 성적을 관리하는 프로그램을 작성하시오.
// 단, 해당 프로그램은 입력과 출력이 분리되어있고 만약
// 다섯명을 초과하여 입력하려고 하면 경고메시지만 출력되고
// 한명도 입력안하고 출력을 한다면 경고 메시지가 출력되게
// 코드를 작성하시오.

// Hint : 내가 입력할 순서는 몇번?
import java.util.Scanner;

public class GradeBook03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String message = "학생의 수를 입력해주세요.";
        System.out.println(message);
        System.out.print("> ");
        int users = scanner.nextInt();
        while (users <= 0){
            System.out.println(message);
            System.out.print("> ");
            users = scanner.nextInt();
        }

        message ="시험 과목의 갯수를 입력해주세요.";
        System.out.println(message);
        System.out.print("> ");
        int steck = scanner.nextInt();
        while (steck <= 0){
            System.out.println(message);
            System.out.print("> ");
            steck = scanner.nextInt();
        }
        final  int SCORE_MIN = 0;
        final  int SCORE_MAX = 100;
        int [] students = new int[users];
        String [] studentsname = new String[users];
        int [] math = new int[users];
        int [] eng = new int[users];
        int [] kor = new int[users];
        int [] total = new int[users];
        double [] avg = new double[users];


        while (true) {
            System.out.println("1. 학생들의 성적표를 작성  2. 학생들의 성적표를 출력");
            System.out.print("> ");
            int userChoice = scanner.nextInt();

            for (int i = 0; i < students.length; i++){
                total[i] = math[i] + kor[i] + eng[i];
                avg[i] = (double)total[i] / (double)steck;
            }

            if (userChoice == 1) {
                for (int i = 0; i < students.length; i++) {
                    System.out.println("해당 학생의 고유 번호를 입력해주세요.");
                    System.out.print("> ");
                    students[i] = scanner.nextInt();

                    System.out.println("해당 학생의 이름을 입력해주세요.");
                    System.out.print("> ");
                    studentsname[i] = scanner.nextLine();

                    int temp;
                    message = "해당 학생의 수학 점수를 입력해주세요.";

                    System.out.println(message);
                    System.out.print("> ");
                    temp = scanner.nextInt();

                    while (temp < SCORE_MIN || temp > SCORE_MAX){
                        System.out.println(message);
                        System.out.print("> ");
                        temp = scanner.nextInt();
                    }
                    math[i] = temp;


                    message = "해당 학생의 국어 점수를 입력해주세요.";

                    System.out.println(message);
                    System.out.print("> ");
                    temp = scanner.nextInt();

                    while (temp < SCORE_MIN || temp > SCORE_MAX){
                        System.out.println(message);
                        System.out.print("> ");
                        temp = scanner.nextInt();
                    }
                    kor[i] = temp;

                    message = "해당 학생의 영어 점수를 입력해주세요.";

                    System.out.println(message);
                    System.out.print("> ");
                    temp = scanner.nextInt();

                    while (temp < SCORE_MIN || temp > SCORE_MAX){
                        System.out.println(message);
                        System.out.print("> ");
                        temp = scanner.nextInt();
                    }
                    eng[i] = temp;

                }
            }else if (userChoice == 2){
                for (int i = 0; i <students.length; i++){
                    if (studentsname[i] != null){
                        System.out.printf("학생번호 : %d번  이름 : %s \n", students[i], studentsname[i]);
                        System.out.printf("국어 : %d점  | 영어 : %d점  | 수학 : %d점 \n",kor[i], eng[i], math[i]);
                        System.out.printf("총점 : %d점  | 평균 : %6.2f \n",total[i], avg[i]);
                    }else if (studentsname[i] == null){
                        System.out.println("아직 학생의 정보가 없습니다.");
                    }
                }

            }else {
                System.out.println("잘못 입력하셨습니다.");
            }
        }

    }
}
