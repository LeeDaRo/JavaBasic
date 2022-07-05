package day0613;
// 로또게임 03
// 숫자를 모두 채우고 중복제거하는 대신
// 중복되지 않은 숫자만 배열에 저장하는 버전
import java.util.Random;

public class Lotto03 {
    public static void main(String [] args){
        Random random = new Random();
        int [] lottoNumbers = new int[6];
        int temp;

        for (int i = 0; i <lottoNumbers.length;){
            boolean numSwhich = true;
            int randomNumber = random.nextInt(45) + 1;

            for (int j = 0; j < i; j++){
                if (randomNumber == lottoNumbers[j]){
                    numSwhich = false;
                }
            }

            if (numSwhich){
                lottoNumbers[i] = randomNumber;
                i++;
            }

        }

        //정렬 및 출력
        for (int i = 0; i < lottoNumbers.length - 1; i++){
            if (lottoNumbers[i] > lottoNumbers[i+1]){
                temp = lottoNumbers[i];
                lottoNumbers[i] = lottoNumbers[i+1];
                lottoNumbers[i+1] = temp;

                i = -1;
            }
        }

        for (int i = 0; i < lottoNumbers.length; i++){
            System.out.printf("%d번째  [%d]숫자\n",i, lottoNumbers[i]);
        }


    }
}
