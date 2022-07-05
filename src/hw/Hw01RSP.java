package hw;

// Rock Scissor Paper
// 컴퓨터를 상대로 하는 가위 바위 보 게임을 만들어보세요.
// 단, 플레이와 현재 기록보기 기능 분리되어 있으며
// 플레이 시에는
// 1 -> 가위  2 -> 바위 3-> 보 가 입력되어서
// 승리, 패배, 무승부가 기록됩니다.
// 현재 기록을 볼 때에는
// 총 ###전 ###승 ###무 ###패 (승률 : ##.###%)가 나오게 됩니다.
// 승률은 승 / (승 + 무 +패) 입니다.

import java.util.Random;
import java.util.Scanner;

public class Hw01RSP {

    public static void main(String [] args){
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int go_stop_check;
        int win = 0, lose = 0, draw = 0, score = 0;
        int user, computer;
        double winningrate = 0.0;

        while(true){
            System.out.println("1. 실행  2. 전적보기  3. 종료");
            System.out.print("> ");
            score = win + draw + lose;
            winningrate = (double) win / score * 100;
            go_stop_check = scanner.nextInt();

            if(go_stop_check == 1){

                while (true){
                    computer = random.nextInt(3)+1;
                    System.out.println("1. 가위  2. 바위  3. 보  0. 메뉴로");
                    System.out.print("> ");
                    user = scanner.nextInt();

                    if(computer == 1){
                        if(user == 1){
                            System.out.println("DRAW.");
                            draw += 1;
                        }else if(user == 2){
                            System.out.println("WINNER.");
                            win += 1;
                        }else if(user == 3){
                            System.out.println("LOSE.");
                            lose += 1;
                        }else if (user == 0){
                            break;
                        } else {
                            System.out.println("다시 입력해주세요.");
                        }

                    }else if (computer == 2){
                        if(user == 1){
                            System.out.println("LOSE.");
                            lose += 1;

                        }else if(user == 2){
                            System.out.println("DRAW.");
                            draw += 1;

                        }else if(user == 3){
                            System.out.println("WINNER.");
                            win += 1;

                        }else if (user == 0){
                            break;
                        } else {
                            System.out.println("다시 입력해주세요.");
                        }

                    }else if (computer == 3){
                        if(user == 1){
                            System.out.println("WINNER.");
                            win += 1;

                        }else if(user == 2){
                            System.out.println("LOSE.");
                            lose += 1;

                        }else if(user == 3){
                            System.out.println("DRAW.");
                            draw += 1;

                        }else if (user == 0){
                            break;
                        } else {
                            System.out.println("다시 입력해주세요.");
                        }
                    }
                }

            }else if (go_stop_check == 2 && score != 0 ){
                System.out.printf("총 전적 : %d전  %d승  %d무  %d패 \n", score, win, draw, lose);
                System.out.printf("승률 : %6.2f%% \n", winningrate);
            }else if (go_stop_check == 3 ){
                System.out.println("이용해주셔서 감사합니다.");
                break;
            }else if (go_stop_check == 2 && score == 0){
                System.out.println("아직 전적이 없습니다. 게임을 진행해주세요.");
            }else {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }


        }


        scanner.close();
    }

}
