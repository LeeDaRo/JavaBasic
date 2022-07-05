package day0613;
import util.ScannerUtil;

import java.util.Scanner;

public class Ex05ScannerUtil {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 1. nextLine();
        String name = ScannerUtil.nextLine(scanner, "이름을 입력해주세요.");
        System.out.println(name);

        System.out.println("정수를 입력해주세요");
        int num = scanner.nextInt();

        name = ScannerUtil.nextLine(scanner, "이름을 입력해주세요");
        System.out.println(name);

        num = ScannerUtil.nextInt(scanner, "숫자를 입력해주세요");
        System.out.println(num);

        num = ScannerUtil.nextInt(scanner, "1~100사이를 입력해주세요", 1,100);
        System.out.println(num);

        scanner.close();
    }
}
