package day0630;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Ex02Calendar {
    public static void main(String[] args) {
        // 시간을 관리하는 클래스 Calendar

        // 단, 캘린더 자체는 인터페이스이기 때문에
        // 우리가 캘린더의 생성자가 아닌
        // 현재 시간을 저장할 수 있게 만들어 주는
        // static 메소드를 통해 객체를 초기화해야한다.

        Calendar cal = Calendar.getInstance();
        System.out.println(cal);

        // cal의 저장된 내부 값을 불러올 때에는 다음과 같은 방법으로 불러온다.
        System.out.println("현재 저장된 년도 : " + cal.get(Calendar.YEAR));

        // cal에 새로운 값을 저장할 때에는 set() 메소드를 통하여 저장 가능한데.
        // 이 때에는 파라미터를 다양하게 지정할 수 있다.

        // 1. 특정 필드에 특정 값 넣기
        cal.set(Calendar.YEAR, 1999);
        System.out.println("현재 저장된 년도 : " + cal.get(Calendar.YEAR));

        // 2. 년/월/일 넣기

        cal.set(1999,12,30);

        // 단, 우리가 형식에 맞추어 출력하기 위해
        // SimpleDateFormat 객체의 format에 cal을 그대로 넣으면 에러가 발생한다.
        // 대신 Calendar 객체 안에 저장된 밀리세컨 값을 넘겨주는 getTime() 메소드를
        // 파라미터로 넘겨주면 된다.

        SimpleDateFormat sdf = new SimpleDateFormat("y년 M월 d일 H시 m분 s초");
        System.out.println("현재 시각 : " + sdf.format(cal.getTime()));

        // 반대로 String 값을 parse해서 저장 할 때에는
        // setTime()을 사용하면 된다.
        try {
            cal.setTime(sdf.parse("2002년 2월 2일 2시 2분 2초"));
            System.out.println("현재 시각 : " + sdf.format(cal.getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
