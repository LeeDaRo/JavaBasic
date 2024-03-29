package day0615;
// 출력하기를
// 목록 간단하게 출력하기 -> 개별 학생 상세보기 -> 수정 / 삭제
// 로 업그레이드한 삭생 정보 관리 프로그램
import java.util.Scanner;
import util.ScannerUtil;
import util.ArrayUtil;
import struct.Student;

public class Ex03GradeBook02 {
    // 전역 변수
    public static Scanner scanner;
    public static Student[] array;
    public static int nextId;

    // 전역 상수
    public static final int SUBJECT_SIZE = 3;
    public static final int SCORE_MIN = 0;
    public static final int SCORE_MAX = 100;

    public static void main(String[] args) {
        // 전역 변수의 초기화를 해줄 메소드를 실행시킨다.
        init();
        // 메뉴 출력 메소드 출력
        showMenu();
        // 프로그램 종료 전 scanner.close() 실행
        scanner.close();
    }

    // 전역 변수를 초기화 시킨다. init()
    public static void init(){
        scanner = new Scanner(System.in);
        array = new Student[0];
        nextId = 1;
    }

    // 메뉴 출력 메소드 showMenu
    // 1일 때는 실행 2일때 출력 3일때 종료
    public static void showMenu(){
        scanner = new Scanner(System.in);
        while (true) {
            String message = "1. 실행  2. 출력  3.종료";

            int userChoice = ScannerUtil.nextInt(scanner, message);

            if (userChoice == 1){
                // 실행에 해당하는 메소드 호출
                insert();
            } else if (userChoice == 2) {
                // 출력에 해당하는 메소드 호출
                printALl();
            } else if (userChoice == 3) {
                System.out.println("이용해주셔서 감사합니다.");
                break;
            }
        }
    }

    // 학생의 정보를 입력하는 부분 insert()
    public static void insert(){
        // 학생의 정보를 담을 Student 변수 선언 및 초기화
        Student s = new Student();
        // 입력 시 출력할 메시지를 저장할 String 변수 선언
        String message;
        // 학생의 번호를 nextId의 현재값으로 초기화하고 nextId는 1증가시킨다.
        s.id = nextId++;
        message = "학색의 이름을 입력하세요.";
        s.name = ScannerUtil.nextLine(scanner, message);
        message = "국어 점수를 입력하세요";
        s.korean = ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX);
        message = "영어 점수를 입력하세요";
        s.english = ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX);
        message = "수학 점수를 입력하세요";
        s.math = ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX);

        array = ArrayUtil.add(array, s);
    }

    // 학생의 목록을 간략하게 출력하는 printALl()
    public static void printALl(){
        // 아무것도 입력이 되어있지 않을 경우 와 입력이 있을 경우
        if (ArrayUtil.isEmpty(array)){
            // 아직 아무것도 입력이 없으므로
            // 경고 메시지만 출력
            System.out.println("아직 입력된 학생이 존재하지 않습니다.");

        }else {
            for(Student s : array){
                System.out.printf("%d번 %s \n", s.id, s.name);
            }
            String message = "상세보기할 학생의 번호나 뒤로 가시려면 0을 입력해주세요.";
            int userChoice = ScannerUtil.nextInt(scanner, message);

            // 만약 userChoice가 0이 아니지만
            // 해당 번호가 유효하지 않을 경우 다시 입력을 받는다.

            // 비교에서 사용할 Student 변수
            Student temp = new Student();

            // 사용자가 입력한 userChoice를 temp에 저장
            temp.id = userChoice;
            while (userChoice != 0 && !ArrayUtil.contains(array,temp)){
                System.out.println("잘못 입력하셨습니다.");
                userChoice = ScannerUtil.nextInt(scanner, message);
                temp.id = userChoice;
            }

            // 만약 userChoice가 0이 아닐 경우
            // 개별 출력 메소드를 실행시킨다.
            if (userChoice != 0 ){
                printOne(userChoice);
            }
        }
    }
    // 학생의 정보를 출력하기 위한 메소드
    public static void printOne(int id){
//        // 1. Student 변수 선언 및 초기화
//        Student s = new Student();
//        // 2. 파라미터 id를 s의 id에 저장
//        s.id = id;
//        // 3. array에서 s와 일치하는 (=equals()가 true가 나오는)
//        // 칸의 index를 얻어온다
//        int index = ArrayUtil.indexOf(array, s);
//        // 4. Student 변수 temp에 array의 index번 칸의 값을
//        // 저장시켜서 출력에서 활용한다.
//        Student temp = ArrayUtil.get(array,index);
        Student temp = selectOne(id);


        // 5. temp를 사용해서 학생의 개별 정보를 출력해준다.
        // 5_1. 학생의 정보 중 총점과 평균을 구해준다.
        int sum = temp.korean + temp.english + temp.math;
        double avg = (double) sum / SUBJECT_SIZE;

        System.out.printf("번호 : %d번  이름 : %s", temp.id, temp.name);
        System.out.printf("국어 : %03d점  영어 : %03d점 수학 : %03d점", temp.korean, temp.english, temp.math);
        System.out.printf("총점 : %03d점  평균 : %06.2f", sum, avg);

        // 6. 사용자로부터 수정, 삭제, 전체 목록 보기 중 하나를 입력받는다.
        String message = "1. 수정  2. 삭제  3. 뒤로가기";
        int userChoice = ScannerUtil.nextInt(scanner, message);

        if (userChoice == 1){
            // 수정 메소드 update(id) 실행
            update(id);
        }else if (userChoice == 2){
            // 삭제 메소드 delete(id) 실행
            delete(id);
        }else if (userChoice == 3){
            // 목록 출력 메소드를 처음부터 실행될 수 있도록
            // printAll() 실행
            printALl();
        }
    }

    // 정보를 수정하기 위해
    public static void update(int id){

        Student temp = selectOne(id);

        String message = "새로운 이름을 입력해주세요.";
        temp.name = ScannerUtil.nextLine(scanner, message);

        message = "새로운 국어 점수 입력해주세요.";
        temp.korean = ScannerUtil.nextInt(scanner, message);

        message = "새로운 영어 점수를 입력해주세요.";
        temp.english = ScannerUtil.nextInt(scanner, message);

        message = "새로운 수학 점수를 입력해주세요.";
        temp.math = ScannerUtil.nextInt(scanner, message);

        // 정보를 수정 한 후 다시 이전 단계로 넘어가는 메소드 호출
        printOne(id);
    }

    // 삭제 할 메소드 delete()
    public static void delete(int id){
        Student temp = new Student();
        temp.id = id;

        // 사용자로부터 정말로 삭제할지 동의를 받는다.
        String message = "정말로 삭제하시겠습니까? Y / N";
        String yesNo = ScannerUtil.nextLine(scanner, message);

        // String 클래스에 정의 되어 있는 equalsIgnoreCase()는
        // 2개의 스트링이 대소문자 상관없이 스펠잉이 같으면 ture.
        // 그 외는 false가 리턴된다.

        if (yesNo.equalsIgnoreCase("Y")){
            array = ArrayUtil.remove(array,temp);
            printALl();

        } else {
            printOne(id);
        }
    }

    // 입력한 값을 다시 호출하기위해 메소드로 정의 하기 selectOne.
    public static Student selectOne(int id){
        Student result = null;

        Student temp = new Student();
        temp.id = id;
        if (ArrayUtil.contains(array,temp)){
            int index = ArrayUtil.indexOf(array,temp);
            result = ArrayUtil.get(array, index);
//            result = ArrayUtil.get(array, ArrayUtil.indexOf(array,temp));
        }

        return result;
    }
}
