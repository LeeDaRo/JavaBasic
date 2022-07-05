package hw;
import java.util.Random;
import java.util.Scanner;

public class Hw02_01Guess {

    public static void main (String [] args){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int bestScore = 0;

        while(true){
            System.out.println("1. play  2. score  3.종료");
            int userChoico = scanner.nextInt();

            if(userChoico == 1){
                //현재 점수를 저장할 변수
                int currentScore = 0;

                //1. 숫자 맞추기 게임
                //컴퓨터 숫자 결정
                int computerNumber = random.nextInt(100)+1;

                //사용자에게 숫자를 입력받는다.

                System.out.println("1~100 사이의 숫자를 입력해주세요.");
                System.out.print("> ");
                int userNumber = scanner.nextInt();
                currentScore++;

                while (userNumber != computerNumber){
                    if (userNumber > computerNumber){
                        System.out.println("Down");
                    }else {
                        System.out.println("Up");
                    }
                    System.out.println("1~100 사이의 숫자를 입력해주세요.");
                    System.out.print("> ");
                    userNumber = scanner.nextInt();

                    currentScore++;
                }
                //사용자 숫자와 컴퓨터 숫자가 다르면
                //거기에 맞춘 결과를 추가해준다.

                //현재 점수 출력
                System.out.println("현재 점수 : " + currentScore);

                // 최고 기록 갱신 여부 결정
                if (bestScore == 0 ){
                    System.out.println("현재 기록이 최고기록이 됩니다." + currentScore);
                }else {
                    System.out.println("기존 최고 기록 : " + bestScore);

                    if(bestScore > currentScore){
                        System.out.println("최고기록 갱신!!");
                        bestScore  = currentScore;
                    }
                }

            }else if (userChoico == 2){
                if (bestScore == 0 ){
                    System.out.println("아직 전적이 없습니다.");
                }else {
                    System.out.println("현재 최고기록 : " + bestScore);
                }

            }else if (userChoico == 3){
                System.out.println("이용해주셔서 감사합니다.");
            }else {
                System.out.println("다시 입력해주세요");
            }
        }

    }
}
