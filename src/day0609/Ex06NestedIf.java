package day0609;

import java.util.Scanner;

public class Ex06NestedIf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number =scanner.nextInt();

        //만약 number에 저장된 값이
        // 양의 정수이면 "양의 정수입니다." 출력
        // 추가적으로 한자리면 "한자리 양의 정수입니다"
        // 두자리면 "두자리 양의 정수입니다"
        // 그 외는 "세자리 이상의 양의 정수입니다"
        // 가 출력된다.
        // 망약 0 일 때에는 "0입니다." 가 출력된다.
        // 음의 정수는 "음의 정수입니다." 출력된다.

        if(number > 0){
            System.out.println("양의 정수입니다.");
            if(number < 10){
                System.out.println("한자리 양의 정수입니다.");
            }else if(10 <= number && number < 100){
                System.out.println("두자리 양의 정수입니다.");
            }else {
                System.out.println("세자리 이상의 양의 정수입니다.");
            }
        }else if(number == 0){
            System.out.println("0입니다.");
        }else {
            System.out.println("음의 정수입니다.");
        }
    }
}
