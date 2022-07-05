package day0610;
// 무한루프를 사용한 메뉴 구성해보기

import java.util.Scanner;

public class Ex08Menu {

    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("1. 1번 기능 실행  2. 2번 기능 실행  3. 3번 기능 실행  4. 종료");
            System.out.print("> ");

            int userChoice = scanner.nextInt();

            if(userChoice == 1 ){
                //1번 기능에 대한 코드 구현

            }else if (userChoice == 2 ){
                //1번 기능에 대한 코드 구현


            }else if (userChoice == 3 ){
                //1번 기능에 대한 코드 구현


            }else if (userChoice == 4){
                //종료 알림 출력 후 무한 루프 종료
                System.out.println("프로그램 종료.");
                break;
            }
        }

        scanner.close();

    }
}
