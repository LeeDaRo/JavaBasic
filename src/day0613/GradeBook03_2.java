package day0613;

import java.util.Scanner;

public class GradeBook03_2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final  int ARRAY_SIZE = 5;
        final  int SUBJECT_SIZE = 3;
        final  int SCORE_MIN = 0;
        final  int SCORE_MAX = 100;

        int[] idArray = new int [ARRAY_SIZE];
        String[] nameArray = new String[ARRAY_SIZE];
        int[] korArray = new int [ARRAY_SIZE];
        int[] engArray = new int [ARRAY_SIZE];
        int[] mathArray = new int [ARRAY_SIZE];


        int currentIndex = 0;
        while (true){
            System.out.println("1. 입력  2. 출력  3. 종료");
            System.out.print("> ");
            int userChoice = scanner.nextInt();

            if (userChoice == 1){
                if (currentIndex < ARRAY_SIZE) {
                    System.out.println("학생의 번호를 입력해주세요.");
                    System.out.print("> ");
                    idArray[currentIndex] = scanner.nextInt();

                    System.out.println("해당 학생의 이름을 입력해주세요.");
                    System.out.print("> ");
                    scanner.nextLine();
                    nameArray[currentIndex] = scanner.nextLine();

                    int temp;
                    String message = "해당 학생의 수학 점수를 입력해주세요.";

                    System.out.println(message);
                    System.out.print("> ");
                    temp = scanner.nextInt();

                    while (temp < SCORE_MIN || temp > SCORE_MAX){
                        System.out.println(message);
                        System.out.print("> ");
                        temp = scanner.nextInt();
                    }
                    mathArray[currentIndex] = temp;


                    message = "해당 학생의 국어 점수를 입력해주세요.";

                    System.out.println(message);
                    System.out.print("> ");
                    temp = scanner.nextInt();

                    while (temp < SCORE_MIN || temp > SCORE_MAX){
                        System.out.println(message);
                        System.out.print("> ");
                        temp = scanner.nextInt();
                    }
                    korArray[currentIndex] = temp;

                    message = "해당 학생의 영어 점수를 입력해주세요.";

                    System.out.println(message);
                    System.out.print("> ");
                    temp = scanner.nextInt();

                    while (temp < SCORE_MIN || temp > SCORE_MAX){
                        System.out.println(message);
                        System.out.print("> ");
                        temp = scanner.nextInt();
                    }
                    engArray[currentIndex] = temp;

                    currentIndex++;

                }else {
                    System.out.println("더이상 입력하실 수 없습니다.");
                }


            }else if(userChoice == 2){
                if (currentIndex == 0){
                    System.out.println("아직 학생의 정보가 없습니다.");
                }else {
                    for (int i = 0 ; i < currentIndex; i++){
                        int sum = korArray[i] + engArray[i] + mathArray[i];
                        double avg = (double) sum / SUBJECT_SIZE;

                        System.out.printf("학생번호 : %d번  이름 : %s \n", idArray[i], nameArray[i]);
                        System.out.printf("국어 : %03d점  | 영어 : %03d점  | 수학 : %03d점 \n",korArray[i], engArray[i], mathArray[i]);
                        System.out.printf("총점 : %03d점  | 평균 : %06.2f점 \n",sum, avg);

                    }
                }

            }else if (userChoice == 3){
                System.out.println("이용해주셔서 감사합니다.");
                break;
            }else {
                System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
            }
        }
        scanner.close();
    }
}
