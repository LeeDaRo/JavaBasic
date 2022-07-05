package hw;
// 숫자 맞추기 게임
// 컴퓨터가 뽑은 1~100 안의 랜덤한 숫자를 맞추기
// 플레이 :
// 사용자가 숫자를 입력해서 컴퓨터가 뽑은 숫자보다 크면 "DOWN" 이 출력되고
// 작으면 "UP"이 출력된다.
// 사용자가 숫자를 입력할때마다 현재 점수가 1점씩 오른다.
// 만약 숫자를 맞췄을 경우, 간단하게 축하하고
// 최고기록을 출력해준다.
// 단, 현재 기록이 최고 기록을 갱신할 경우 현재 기록이 새로운 최고 기록이 됨을 알려준다.
// 현재 최고 기록 보기 :
// 현재 최고 점수를 보여준다. 단, 플레이 기록이 없을 경우 경고 메시지를 출력해준다.

import java.util.Scanner;
import java.util.Random;

public class Hw02Guess {

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int start = 1, stop = 3, scorecheck = 2;
        int computer = 0;
        int user, userplay, max_score = 0, min_score = 100;

        while (true){
            System.out.println("1. 게임진행  2. 전적보기  3.  종료");
            System.out.print("> ");

            if (min_score == 100) {
                max_score = 1;
            }

            user = scanner.nextInt();

            if(user == start){
                computer = random.nextInt(100)+1;
                while (true) {
                    System.out.println("예상하는 숫자를 입력해주세요 만약 메뉴를 보시려면 0을 입력해주세요");
                    System.out.print("> ");
                    userplay = scanner.nextInt();

                    if (userplay == 0 ){
                        System.out.println("메뉴로 돌아갑니다.");
                        break;
                    } else if (computer > userplay){
                        max_score += 1;
                        System.out.println("UP");

                    }else if (computer < userplay){
                        max_score += 1;
                        System.out.println("DOWN");

                    }else if (computer == userplay){
                        max_score += 1;
                        if(max_score <= min_score){
                            min_score = max_score;
                        }
                        System.out.println("정답입니다.");
                    }
                }

            }else if (user == scorecheck){

                if(min_score != 100) {
                    System.out.printf("현재 최고기록 %d \n", min_score);
                }else {
                    System.out.printf("현재 기록이 없습니다. \n");
                }
            }else if (user == stop){
                System.out.println("이용해 주셔서 감사합니다.");
                break;

            }else {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }

        }


        scanner.close();
    }
}
