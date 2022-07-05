package day0614;
// 사용자로부터 총 몇게임 할지 입력 받아서
// 각 게임마다 자동 / 수동 입력받아서
// 결과까지 보여주는 프로그램을 작성하시오.

// 조건1. ScannerUtil, ArrayUtil 사용하기
// 조건2. 자동 숫자 부여를 개별의 메소드로 만들기
// 조건3. 정렬을 별개의 메소드로 만들기
// 조건4. 결과 비교를 별개의 메소드로 만들기

import java.util.Scanner;
import util.ScannerUtil;
import util.ArrayUtil;
import java.util.Random;

public class Lotto05 {
    static Scanner scanner = new Scanner(System.in);

    static final int SIZE_MAX = 6;
    static final int NUMBER_MIN = 1;
    static final int NUMBER_MAX = 45;
    static Random random = new Random();

    public static void main(String[] args) {

        //입력을 받을 때 출력할 메시지를 저장할 String 변수
        String message;

        // 1. 사용자한테 총 몇게임을 할지 입력을 받는다.
        message = "총 몇게임을 하시겠습니까?";
        int gameNuber = ScannerUtil.nextInt(scanner, message);

        // 2. 사용자의 숫자를 저장할 int[][] 선언 및 초기화
        int[][] userNumbers = new int[gameNuber][];

        // 3. 각 게임에 대한 자동 / 수동을 입력받아서 처리한다.
        for (int i = 0; i <userNumbers.length; i++){
            System.out.printf("%d번째 게임 \n", i+1);
            message = "1. 자동   2. 수동";
            int userChoice = ScannerUtil.nextInt(scanner,message);
            if (userChoice == 1){
                userNumbers[i] = setAutoNum();

            }else if (userChoice == 2){
                userNumbers[i] = setManualNum();
            }
        }

        // 4. 컴퓨터의 숫자를 정한다.
        int [] computerNumbers = setAutoNum();

        // 5. 결과를 출력한다.
        // 5-1. 컴퓨터 숫자 출력.
        message = "컴퓨터 숫자를 출력합니다.";
        ScannerUtil.printMessage(message);
        printArray(computerNumbers);

        message = "구매한 번호 출력 및 맞은 갯수를 출력합니다.";
        ScannerUtil.printMessage(message);
        // 5-2. 사용자 i번째 게임 + 총 맞은 갯수 출력
        for (int i = 0; i < userNumbers.length; i++){
            printArray(userNumbers[i]);
            System.out.println("총 맞은 갯수 : " + countSame(computerNumbers,userNumbers[i]));

        }

        scanner.close();
    }

    // 자동 번호 생성
    public static int[] setAutoNum(){

        int [] temp = new int[0];
        while (ArrayUtil.size(temp) < SIZE_MAX){
            int randomNumber = random.nextInt(NUMBER_MAX) + NUMBER_MIN;
            if (!ArrayUtil.contains(temp, randomNumber)){
                temp = ArrayUtil.add(temp, randomNumber);
            }
        }
        sort(temp);

        return temp;
    }

    // 수동 번호 생성
    public static int [] setManualNum(){
        int [] temp = new int[0];
        while (ArrayUtil.size(temp) < SIZE_MAX){
            String message = "1부터 45사이의 숫자를 입력해주세요.";
            int userInput = ScannerUtil.nextInt(scanner, message, NUMBER_MIN, NUMBER_MAX);
            if (ArrayUtil.contains(temp, userInput)){
                System.out.println("중복된 숫자는 입력할 수 없습니다,");
            }else {
                temp = ArrayUtil.add(temp, userInput);
            }
        }
        sort(temp);

        return temp;
    }

    // 번호를 생성 한 것을 정렬
    public static void sort(int [] arr){
        for (int i = 0; i < ArrayUtil.size(arr) - 1; i++){
            if (ArrayUtil.get(arr, i) > ArrayUtil.get(arr, i+1)){
                int temp = ArrayUtil.set(arr, i+1, ArrayUtil.get(arr,i));
                ArrayUtil.set(arr, i, temp);
                i = -1;
            }
        }
    }

    // 정렬한 번호를 출력
    public static void printArray(int [] arr){
        System.out.print("[");
        for (int i = 0; i < ArrayUtil.size(arr); i++){
            System.out.printf("%d", ArrayUtil.get(arr, i));
            if (i != ArrayUtil.size(arr) -1){
                System.out.print(" ");
            }
        }
        System.out.println("]");
    }

    // 맞은 숫자의 갯수를 확인
    public static int countSame(int [] arr1, int [] arr2){
        int count = 0;
        for (int i = 0; i < ArrayUtil.size(arr1); i++){
            if (ArrayUtil.contains(arr2, ArrayUtil.get(arr1, i))){
                count++;
            }
        }
        return count;
    }
}
