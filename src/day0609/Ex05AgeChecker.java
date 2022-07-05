package day0609;

import java.util.Scanner;

public class Ex05AgeChecker {
    //사용자로부터 나이를 입력받아서
    //~5세 이하 : 영아
    //~13세 이하 : 어린이
    //~18세 이하 : 청소년
    //그외 : 성인 이 출력되는 프로그램을 작성하세요.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("당신의 나이를 입력해주세요 : ");
        int a = scanner.nextInt();

        if(a < 0){
            System.out.println("잘못된 입력입니다.");
        }else if (0 <= a && a <= 5){
            System.out.println("영아");
        }else if (5 < a && a <= 13){
            System.out.println("어린이");
        }else if (13 < a && a <= 18){
            System.out.println("청소년");
        }else {
            System.out.println("성인");
        }

        scanner.close();
    }
}
