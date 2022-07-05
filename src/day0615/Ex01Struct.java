package day0615;
// 구조체 사용해보기

import struct.Student;

public class Ex01Struct {

    public static void main (String [] args){
        // 우리가 만든 데이터타입의 변수를 만들 때에는
        // Random 변수를 만들때와 똑같은 형태를 가지게 된다.
        Student s = new Student();

        // 해당 변수의 내부 공간에 접근할 때에는
        // 변수이름.공간이름으로 우리가 접근하게 된다.
        // 즉 Student 변수 s의 id에 3을 저장해라는 다음과 같이 적는다.
        s.id = 3;
        // 나머지 공간에도 값을 저장해보자.
        s.name = "DaRo";
        s.english = 80;
        s.korean = 80;
        s.math = 81;

        //마찬가지로 현재 해당 공간의 내부 공간 값을 호출할 때도 똑같이 적어준다.
        // . 이라는 문법의 "~~의"라고 생각하면 된다.
        System.out.println("s.id : " + s.id);
        System.out.println("s.name : " + s.name);
        int sum = s.korean + s.english + s.math ;
        double avg = (double)sum / 3.0;
        System.out.println("s.english : " + s.english);
        System.out.println("s.korean : " + s.korean);
        System.out.println("s.math : " + s.math);
        System.out.println("sum : " + sum);
        System.out.println("avg : " + avg);

        // 또 다른 Student 변수를 만들어보자.
        Student s2 = new Student();
        // 우리가 필요하다면 s2에는 새로운 값을 저장 할 수 있다.
        s2.id = 1;
        s2.name = "quaka";
        s2.korean = 1;
        s2.math = 3;
        s2.english = 6;
        System.out.println("s.id : " + s.id);
        System.out.println("s2.di : " + s2.id);

        // 또한, 똑같은 데이터타입의 변수가 모여있는
        // 배열을 만들 수도 있다.
        Student [] arr = new Student[3];

        // 단 각 칸은 개별적으로 초기화를 우리가 해주어야 한다.
        arr[0] = new Student();
        System.out.println("arr[0].id : " + arr[0].id);

        // 또한 우리가 만든 데이터타입의 내부 공간은
        // 기본형 데이터타입이면 0, 참조형 데이터타입이면 null로 초기화가 된다.
        System.out.println("arr[0].id : " + arr[0].id);
        System.out.println("arr[0].name : " + arr[0].name);

        // 주의할 점.
        // 우리가 참조형 데이터타입의 공간끼리 실제 값 비교를 할 때에는
        // equals()를 사용해야 정확한 결과를 얻을 수 있다고 배웠지만
        // 아직은 우리가 자체적으로 만든 데이터타입의 equals()는
        // 쓸모가 없다.

        // s2와 똩같은 값들을 가진 s3를 만들어보자
        Student s3 = new Student();
        s3.id = 1;
        s3.name = "quaka";
        s3.korean = 1;
        s3.math = 3;
        s3.english = 6;

        System.out.println("s2.equals(s3) : " + s2.equals(s3));

        // 따라서 우리가 직접 필요할 때 equals()를 만들어주거나
        // 아니면 두 공간의 특정 값들을 직접 비교하게 코드를 작성해야한다.
        System.out.println("s2 == s3 : " + (s2 == s3));

        System.out.println("s2.id == s3.id : " + (s2.id == s3.id));
    }
}
