package day0609;

import java.util.Scanner;

public class Army {
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        int age, b, c;

        System.out.println("당신의 성별을 입력해주세요.");
        System.out.println("남성 : 1 / 여성 : 2");
        System.out.print("> ");
        b = scanner.nextInt();

        if(b == 1){
            System.out.println("당신의 나이를 입력해주세요.");
            System.out.print("> ");
            age = scanner.nextInt();

            if (0 < age && age <19){
                System.out.println("아직 대상이 아닙니다.");
            }else if(age >= 19){
                System.out.println("당신의 신체등급을 입력해주세요");
                System.out.print("> ");
                c = scanner.nextInt();
                if (c<=3){
                    System.out.println("당신은 국방의 노예입니다.");
                }else if (c>3 && c<6){
                    System.out.println("당신은 방위의 노예입니다.");
                }else {
                    System.out.println("축하드립니다 당신은 노예가 아닙니다.");
                }
            }

        }else {
            System.out.println("당신은 대상이 아닙니다.");
        }

        scanner.close();
    }
}
