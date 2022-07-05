package hw;

import java.util.Random;
import java.util.Scanner;

public class Hw03Lotto {

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int [] computerNumber = new int [6];
        int [][] userLottoNumbers = new int[5][6];
        final int randomGame = 1, choiceGame =2, stopGame =3 ;
        int userChoice, userLottoplay = 0;
        int temp, money = 0;
        boolean numSwhich;


        System.out.println("지옥의 가챠 게임에 오신것을 환영합니다.");
        // 로또 번호 구매
        while (true){

            System.out.println("1. 로또 자동구매  2. 로또 수동구매   3. 구매 종료 및 추첨확인");
            System.out.print("> ");
            userChoice = scanner.nextInt();

            if (userChoice == randomGame || userChoice == choiceGame){
                System.out.println("진행 할 게임의 횟수(제한 : 1 ~ 5번)를 입력해 주세요.");
                System.out.print("> ");
                userLottoplay = scanner.nextInt();

                userLottoNumbers = new int[userLottoplay][6];
                // 자동게임
                if (userChoice == randomGame) {

                    if (userLottoplay > 0 && userLottoplay <=5) {

                        for (int i = 0; i < userLottoplay; i++) {
                            numSwhich = true;

                            for (int j = 0; j < userLottoNumbers[i].length; ) {
                                int randomNumber = random.nextInt(45) + 1;

                                for (int k = 0; k < j; k++) {
                                    if (randomNumber == userLottoNumbers[i][k]) {
                                        numSwhich = false;
                                    }
                                }
                                if (numSwhich) {
                                    userLottoNumbers[i][j] = randomNumber;
                                    j++;
                                }
                            }
                        }

                        for (int i = 0; i < userLottoNumbers.length; i++) {
                            for (int j = 0; j < userLottoNumbers[i].length - 1; j++) {
                                if (userLottoNumbers[i][j] > userLottoNumbers[i][j + 1]) {
                                    temp = userLottoNumbers[i][j];
                                    userLottoNumbers[i][j] = userLottoNumbers[i][j + 1];
                                    userLottoNumbers[i][j + 1] = temp;

                                    j = -1;
                                }
                            }
                        }

                        for (int i = 0; i < userLottoNumbers.length; i++) {
                            System.out.printf("%d 번째 게임 : ", i + 1);
                            for (int j = 0; j < userLottoNumbers[i].length; j++) {
                                System.out.printf("[%d]", userLottoNumbers[i][j]);
                            }
                            System.out.println("");
                        }
                    }
                    //수동게임
                } else if (userChoice == choiceGame) {

                    if (userLottoplay > 0 && userLottoplay <= 5) {
                        for (int i = 0; i < userLottoplay; i++) {
                            numSwhich = true;

                            for (int j = 0; j < userLottoNumbers[i].length;) {
                                System.out.println("1 ~ 45 사이의 숫자를 입력해주세요 단! 중복되면 안됩니다.");
                                System.out.print("> ");
                                int randomNumber = scanner.nextInt();
                                if (randomNumber >= 1 && randomNumber <= 45) {

                                    for (int k = 0; k < j; k++) {
                                        if (randomNumber == userLottoNumbers[i][k]) {
                                            numSwhich = false;
                                        }
                                    }
                                    if (numSwhich) {
                                        userLottoNumbers[i][j] = randomNumber;
                                        j++;
                                    }
                                } else {
                                    System.out.println("잘못 입력하셨습니다.");
                                }
                            }
                        }

                        for (int i = 0; i < userLottoNumbers.length; i++) {
                            for (int j = 0; j < userLottoNumbers[i].length - 1; j++) {
                                if (userLottoNumbers[i][j] > userLottoNumbers[i][j + 1]) {
                                    temp = userLottoNumbers[i][j];
                                    userLottoNumbers[i][j] = userLottoNumbers[i][j + 1];
                                    userLottoNumbers[i][j + 1] = temp;

                                    j = -1;
                                }
                            }
                        }

                        for (int i = 0; i < userLottoNumbers.length; i++) {
                            System.out.printf("%d 번째 게임 : ", i + 1);
                            for (int j = 0; j < userLottoNumbers[i].length; j++) {
                                System.out.printf("[%d]", userLottoNumbers[i][j]);
                            }
                            System.out.println("");
                        }

                    } else {
                        System.out.println("잘못 입력하셨습니다.");
                    }
                }
            } else if (userChoice == stopGame) {
                System.out.println("구매해 주셔서 감사합니다.");
                break;

            } else {
                System.out.println("잘못 입력하셨습니다.");
            }

        }

        System.out.println("지옥의 가챠 게임 로또번호를 추첨합니다.");
        for (int i = 0; i < computerNumber.length;){
            int randomNumber = random.nextInt(45) + 1;
            numSwhich = true;

            for (int j = 0; j < i; j++ ){
                if (randomNumber == computerNumber[j]){
                    numSwhich = false;
                }
            }
            if (numSwhich){
                computerNumber[i] = randomNumber;
                i++;
            }
        }

        for (int i = 0; i < computerNumber.length - 1; i++){
            if (computerNumber[i] > computerNumber[i+1]){
                temp = computerNumber[i];
                computerNumber[i] = computerNumber[i+1];
                computerNumber[i+1] = temp;

                i = -1;
            }

        }

        System.out.print("이번주 로또 당첨번호 : ");
        for (int i = 0 ; i <computerNumber.length; i++){
            System.out.printf("[%d] ", computerNumber[i]);
        }
        System.out.println("");

        // 구매한 번호와 추첨된 번호 당첨확인

        for (int i = 0; i < userLottoplay ; i++){
            for (int j = 0; j < computerNumber.length; j++){
                for (int k = 0; k < computerNumber.length; k++) {
                    if (computerNumber[j] == userLottoNumbers[i][k]) {

                        if (j == computerNumber.length){
                            j = -1;
                        }
                        money += 1;
                    }
                }
            }
            System.out.printf("%d번째 게임 맞은 번호의 갯수 : %d개 \n",(i+1) , money);
            money = 0;
        }

        scanner.close();
    }
}
