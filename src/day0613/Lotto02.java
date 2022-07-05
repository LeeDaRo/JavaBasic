package day0613;
// 로또 번호 추첨기
// 배열 적용 버전
import javax.rmi.ssl.SslRMIClientSocketFactory;
import java.awt.font.FontRenderContext;
import java.util.Random;
public class Lotto02 {
    public static void main(String [] args){
        Random random = new Random();

        int temp;
        int [] lottoNumbers = new int[6];

        //for문을 사용하여 lottoNumbers에 숫자를 저장

        for (int i = 0; i < lottoNumbers.length; i++){
            // 배열에 각 칸을 접근할 때에는
            // 배열이름 [인덱스]로 접근한다.
            // 지금같이 배열의 각 칸에 값을 저장할 때에는
            // 배열이름[인덱스] = 값; 으로 초기화하면 된다.
            lottoNumbers[i] = random.nextInt(45) + 1;

        }

        System.out.println("중복 제거전");
        System.out.println("===================================");
        for (int i = 0; i < lottoNumbers.length; i++){
            System.out.printf("%d번째 [%d]숫자 \n", i, lottoNumbers[i]);
        }
        System.out.println("===================================");

        // for문을 사용하여 만약 i번째 칸에 중복된 숫자를 찾으면
        // 새로운 값을 저장하고 다시 체크하는 2중 for문
        for (int i = 0; i <lottoNumbers.length; i++){
            for (int j = 0; j < lottoNumbers.length; j++){
                // 중복의 조건 :
                // i와 j는 다르지만 lottoNumbers[i] 와 lottoNumbers[j]가
                //같은 경우
                if (i != j && lottoNumbers[i] == lottoNumbers[j]){
                    lottoNumbers[j] = random.nextInt(45)+ 1;

                    j = -1;

                }
            }
        }

        System.out.println("중복 제거후");
        System.out.println("===================================");
        for (int i = 0; i < lottoNumbers.length; i++){
            System.out.printf("%d번째 [%d]숫자 \n", i, lottoNumbers[i]);
        }
        System.out.println("===================================");

        for (int i = 0; i < lottoNumbers.length -1; i++){
            if (lottoNumbers[i] > lottoNumbers[i + 1]){
                temp = lottoNumbers[i];
                lottoNumbers[i] = lottoNumbers[i + 1];
                lottoNumbers[i + 1] = temp;

                i = -1;
            }
        }
        System.out.println("중복 제거 및 정렬");
        System.out.println("===================================");
        for (int i = 0; i < lottoNumbers.length; i++){
            System.out.printf("%d번째 [%d]숫자 \n", i, lottoNumbers[i]);
        }
        System.out.println("===================================");

    }

}
