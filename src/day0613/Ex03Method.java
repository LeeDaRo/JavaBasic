package day0613;
// method
// 메소드란 특정 여러중의 코드를 매번 반복하여
// 처음부터 끝까지 실행시켜야하는 경우
// 그 코드를 전부다 적어주는 것이 아니라
// 하나의 "단축키"를 만들어서
// 그 단축키를 적어주면 자동으로 모든 것이 실행되게
// 만들어주는 코드의 집합을 뜻하게된다.

// public : 퍼블릭은 접근 제한자 중에 하나로써
// 해당 메소드 혹은 변수 / 상수 등을 외부 패키지의 어디서든
// 접근 가능하게 설정해주는 키워드이다.

// static : 스태틱 키워드는 해당 메소드 혹은 변수 / 상수를
// 우리가 클래스 변수를 안 만들고 직접 사용 할 수 있게 만들어준다.
// 단, 스태틱 메소드가 내부에서 다른 메소드 혹은 변수 / 상수를
// 호출 할때에는 반드시 다른 메소드, 변수 / 상수도 static 키워드가
// 붙어야 한다.

// 메소드는 기본적으로 다음과 같은 구조를 가진다.

// public static 리턴타입 메소드이름 (파라미터)

// 리턴타입 : 해당 메소드가 실행이 끝나면서
// 호출된 곳으로 보내줄 값의 데이터타입
// 만약 아무런 값도 호출된 곳으로 보내주지 않는다면 void 라고 적어준다.

// 메소드이름 : 소문자로 시작하고 낙타등 표기법을 사용하는 동사.

// 파라미터 :  이 메소드를 실행하는데 필요로 하는 외부의 값을
// 변수처럼 사용 할 수 있게 선언된 부분
// 만약 이 메소드를 실행시킬때 필요한 외부의 소스가 빈칸으로 남겨둔다.

import java.util.Random;

public class Ex03Method {

    public static void main(String [] args){
        // 1. 특정 코드를 실행만 시킬 경우
        sign();
//        System.out.println("나는 ---입니다!");
//        System.out.println("이 과제는 다른 사람의 도움 없이 혼자 힘으로 풀었습니다");
        sign();
//        System.out.println("나는 ---입니다!");
//        System.out.println("이 과제는 다른 사람의 도움 없이 혼자 힘으로 풀었습니다");
        sign();
//        System.out.println("나는 ---입니다!");
//        System.out.println("이 과제는 다른 사람의 도움 없이 혼자 힘으로 풀었습니다");

        // 2. 외부의 값을 받아와서 내부에서 처리하여 실행시키는 경우

        int num =3;
//        if (num%2 == 1){
//            System.out.println("홀수 입니다.");
//        }else {
//            System.out.println("짝수 입니다.");
//        }
        printEvenOdd(num);


        int randomNum;
        randomNum = setRandomNum();

        randomNum = setRandomNum();

        randomNum = setRandomNum();

        randomNum = setRandomNum();

        int bigger;
        int num1 = 3;
        int num2 = 5;
        if (num1 > num2){
            bigger = num1;
        }else {
            bigger = num2;
        }

        num1 = 6;
        num2 = 4;
        bigger = returnBigger(num1,num2);

        bigger = returnBigger(90, 100);

        System.out.println(returnBigger(30, 200));

        returnBigger(returnBigger(50, 100), 1000);
        //Method의 호출
    }

    public static void sign(){
        System.out.println("나는 ---입니다!");
        System.out.println("이 과제는 다른 사람의 도움 없이 혼자 힘으로 풀었습니다");
    }

    public static void printEvenOdd(int a){
        if (a % 2 == 0){
            System.out.println("짝수 입니다.");
        }else {
            System.out.println("홀수 입니다.");
        }
    }

    public static int setRandomNum(){
        Random random = new Random();
        int temp = random.nextInt();
        return temp;
    }

    public static int returnBigger(int num1, int num2){
        if (num1 > num2){
            return num1;
        }else {
            return num2;
        }
    }
}
