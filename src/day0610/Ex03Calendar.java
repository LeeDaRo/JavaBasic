package day0610;

// 사용자로부터 월을 입력받아서
// 해당 원이 몇일까지 잇는지 보여주는
// 프로그램

import java.util.Scanner;

public class Ex03Calendar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("월을 입력해주세요");
        System.out.print("> ");
        int month = scanner.nextInt();

        switch(month){
            case 2:
                System.out.println("28일 까지입니다.");
                break;
            case 4, 6, 9, 11:
                System.out.println("30일 까지입니다.");
                break;
            case 1, 3, 5, 7, 8, 10, 12 :
                System.out.println("31일 까지입니다.");
                break;
        }

        scanner.close();
    }


}
