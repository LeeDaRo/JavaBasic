package day0609;

import java.util.Scanner;

public class Ex04Scanner {
    public static void main (String [] args){
        Scanner scanner;
        scanner = new Scanner(System.in);
        System.out.println("정수를 하나 입력해주세요.");
        System.out.print("> ");
        int number = scanner.nextInt();
        System.out.println(number);

        System.out.println("실수를 하나 입력해주세요.");
        System.out.print("> ");
        double number1 = scanner.nextDouble();
        System.out.println(number1);

        System.out.println("이름을 입력해주세요.");

        scanner.nextLine();
        String name= scanner.nextLine();

        System.out.println();
        System.out.printf("user name : [%s]\n" , name);


        scanner.close();
    }
}
