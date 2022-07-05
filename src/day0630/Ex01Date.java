package day0630;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Ex01Date {
    public static void main(String[] args) {
        java.util.Date d1 = new java.util.Date();
        java.sql.Date d2 = new java.sql.Date(d1.getTime());

        System.out.println(d1);
        System.out.println(d2);

        System.out.println("d1.getTime() : " + d1.getTime());

        // 1. 연도에 새로운 값 넣어보기
        d1.setYear(1999);
        System.out.println(d1);
        // 2. 월에 새로운 값 넣어보기
        d1.setMonth(12);
        System.out.println(d1);
        // 3. 일에 새로운 값 넣어보기
        d1.setDate(1);
        System.out.println(d1);
        // 4. 시에 새로운 값 넣어보기
        d1.setHours(25);
        System.out.println(d1);

        // 다시 현재 시간으로 java.util.Date 객체 초기화
        d1 = new java.util.Date();
        // 특정 시간 단위의 값 받아오기
        // 몇번째 요일인지 받아오기
        System.out.println(d1.getDay());

        // 만약 우리가 Date 객체의 값을 특정 양식의 스트링으로 변환하거나
        // 아니면 스트링을 Date로 바꿀 때에는(parse)
        // 우리가 SimpleDateFormat 객체가 필요하다.

        // SimpleDateFormat 객체는 초기화시
        // 빈 생성자를 호출해도 되지만
        // 우리가 어떤 양식으로 String 변환을 할지를
        // 직접 생성자에 넣어주어야 한다.
        // 이때에는 우리가 %문자를 사용해서 printf를 썼던 것 처럼
        // 기호를 사용해서 형식을 지정해주어야 한다.
        // y : 연도
        // M : 월
        // d : 일
        // H : 24시간 체제의 시
        // h : 12시간 체제의 시
        // m : 분
        // s : 초
        // S : 밀리초
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 EEEE HH시 mm분 ss초");

        // SimpleDateFormat의 객체를 사용하여
        // Date 객체를 스트링으로 변환 할 때에는
        // format() 메소드를 사용하면 된다.

        // d1을 String으로 변환하여 출력해라
        System.out.println(sdf.format(d1));
        // d2를 String으로 변환하여 출력해라
        System.out.println(sdf.format(d2));

        // 스트링을 Date로 변환할 때 기준이 될 String 객체 선언 및 초기화
        String format = "y/M/d H:m:s";
        System.out.println("바꿀 시간을 " + format + "형식으로 입력해주세요.");
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        sdf = new SimpleDateFormat(format);
        sdf.setLenient(false);

        try {
            d1 = sdf.parse(input);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println("입력한 연도 : " + d1.getYear());
        System.out.println(d1);
        scanner.close();


    }
}
