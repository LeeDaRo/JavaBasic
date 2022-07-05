package day0610;

import java.util.Random;

public class Ex10Random {

    public static void main(String [] args){

        Random random = new Random();

        // 1. double 타입의 랜덤한 숫자를 뽑을때는?
        System.out.println(random.nextDouble());

        // 2. int범위 내의 랜덤한 정수를 뽑을때는?
        System.out.println(random.nextInt());

        // 3. 0~99까지 안에서 랜덤한 정수를 뽑을때는?
        System.out.println(random.nextInt(100));

        // 4. 1~100까지 안에서 랜덤한 정수를 뽑을때는?
        System.out.println(random.nextInt(100) + 1);

        // 5. 501~510까지 안에서 랜덤한 정수를 뽑을때는?
        System.out.println(random.nextInt(10) + 501);



    }

}
