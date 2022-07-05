package day0610;

// 사용자로부터 번호, 이름, 국어, 영어, 수학 점수를 차례대로 입력 받아서
// 다음과 같은 형식으로 출력되는 프로그램을 작성하시오.
// 단, 만약 사용자가 잘못된 점수를 입력하면 올바른 점수가 입력될때까지
// 다시 입력받으시오.

// 출력양식 :
// 번호 : #번  이름 : #
// 국어 : 0##점 영어 : 0##점 수학 : 0##점
// 총점 : 0##점 평균 : 0##.##점

import java.util.Scanner;

public class Ex06GradeBook {
    public static void main(String[] args) {
        //상수
        final int SCORE_MIN = 0;
        final int SCORE_MAX = 100;
        final int SUBJECT_SIZE = 3;

        Scanner scanner = new Scanner(System.in);

        int number, Mat, Kor, Eng, total;
        String name;
        double avg;
        System.out.println("번호를 입력해주세요");
        System.out.print("> ");
        number = scanner.nextInt();

        System.out.println("이름을 입력해주세요");
        System.out.print("> ");
        scanner.nextLine();
        name = scanner.nextLine();

        System.out.println("수학 점수를 입력해주세요");
        System.out.print("> ");
        Mat = scanner.nextInt();

        while(!(Mat >= SCORE_MIN && Mat <= SCORE_MAX)) {
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

        while (!(Eng >= SCORE_MIN && Eng <= SCORE_MAX)){
            System.out.println("영어 점수를 다시 입력해주세요.");
            System.out.print("> ");
            Eng = scanner.nextInt();
        }

        total = Mat + Kor + Eng;
        avg = total / (double)SUBJECT_SIZE;
        System.out.printf("번호 : %d 번,   이름 : %s \n", number ,name);
        System.out.printf("국어 : %03d 점,영어 : %03d 점,수학 : %03d 점 \n", Kor, Eng, Mat);
        System.out.printf("총점 : %03d 점,평균 : %06.2f 점", total, avg);

        scanner.close();

    }

}
