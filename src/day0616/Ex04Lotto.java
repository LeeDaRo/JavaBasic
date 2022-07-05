package day0616;
import java.util.Collections;
import java.util.Random;
import java.util.ArrayList;
public class Ex04Lotto {
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();

        // 1. 리스트에 중복되지 않은 숫자 추가하기
        while (list.size() < 6){
            int num = random.nextInt(45)+1;
            if (!list.contains(num)){
                list.add(num);
            }
        }

        // 정렬하기
        Collections.sort(list);

        System.out.println(list);
    }
}
