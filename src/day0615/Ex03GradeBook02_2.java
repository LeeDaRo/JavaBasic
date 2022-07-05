package day0615;
import java.util.Scanner;
import util.ArrayUtil;
import util.ScannerUtil;
import struct.Student;

public class Ex03GradeBook02_2 {

// 출력하기를
// 목록 간단하게 출력 > 개별 학생 상세보기 > 수정
// 으로 업그레이드한 학생 정보 관리 프로그램;
        // 전역 변수 선언
        public static Scanner scanner;
        public static Student[] arr;
        public static int nextId;
        public static String msg;

        // 전역 상수 선언
        public static final int SUBJECT_SIZE = 3;
        public static final int SCORE_MIN = 0;
        public static final int SCORE_MAX = 100;

        public static void main(String[] args) {
            // 전역변수 초기화 메소드 호출
            init();

            // 메뉴 출력 메소드 호출
            showMenu();

            scanner.close();
        }

        // 전역변수 초기화 메소드
        public static void init() {
            scanner = new Scanner(System.in);
            arr = new Student[0];
            nextId = 1;
        }

        // 메뉴 출력 메소드
        public static void showMenu() {
            while(true) {
                msg = "프로그램을 실행합니다.\n메뉴를 골라주세요.\n1. 학생정보 입력  2. 학생목록 출력  3. 종료";
                int userChoice = ScannerUtil.nextInt(scanner, msg);

                if(userChoice == 1) {
                    // 학생 입력 메소드 실행
                    insert();


                }else if(userChoice == 2) {
                    // 학생 출력 메소드 실행
                    printAll();

                }else if(userChoice == 3) {
                    System.out.println("사용해주셔서 감사합니다.");
                    break;
                }else {
                    System.out.println("존재하지 않는 메뉴입니다. 다시 선택해주세요.");
                }

            }
        }

        public static void insert() {
            // 학생의 정보를 담을 Student 변수 선언 및 초기화
            Student s = new Student();

            // 학생의 번호를 nextId의 현재값으로 초기화하고 nextId는 1증가
            s.id = nextId++;

            // 학생의 이름을 입력받는다.
            msg = "학생의 이름을 입력해주세요.";
            s.name = ScannerUtil.nextLine(scanner, msg);

            // 학생의 국어점수를 입력받는다.
            msg = "학생의 국어 점수를 입력해주세요.";
            s.korean = ScannerUtil.nextInt(scanner, msg, SCORE_MIN, SCORE_MAX);

            // 학생의 영어 점수를 입력받는다.
            msg = "학생의 영어 점수를 입력해주세요.";
            s.english = ScannerUtil.nextInt(scanner, msg, SCORE_MIN, SCORE_MAX);

            // 학생의 수학 점수를 입력받는다.
            msg = "학생의 수학 점수를 입력해주세요.";
            s.math = ScannerUtil.nextInt(scanner, msg, SCORE_MIN, SCORE_MAX);

            // 정보를 담은 Student 변수를 배열에 동적으로 추가해준다.
            arr = ArrayUtil.add(arr, s);
        }

        // 학생의 목록을 간략하게 출력하는 printAll()
        public static void printAll() {
            if(!ArrayUtil.isEmpty(arr)) {
                for(Student s : arr) {
                    System.out.printf("%d. %s\n", s.id, s.name);
                }
                msg = "상세보기할 학생의 번호를 입력해주세요.(0 입력시 뒤로가기)";
                int userChoice = ScannerUtil.nextInt(scanner, msg);

                // 만약 userChoice가 0이 아니지만
                // 해당 번호가 유효하지 않을 경우 다시 입력을 받는다.

                // 비교에서 사용할 Student 변수
                Student temp = new Student();

                // 사용자가 입력한 userChoice를 temp에 저장
                temp.id = userChoice;

                while(userChoice != 0 && !ArrayUtil.contains(arr, temp)) {
                    System.out.println("잘못 입력하셨습니다.");
                    userChoice = ScannerUtil.nextInt(scanner, msg);
                    temp.id = userChoice;
                }

                // 만약 userChoice가 0이 아닐 경우
                // 개별 출력 메소드를 실행시켜준다.

                if(userChoice != 0) {
                    printOne(userChoice);
                }
            }else {
                System.out.println("현재 입력된 학생 정보가 없습니다.");
            }
        }

        public static void printOne(int id) {
//        // 1. Student 변수 선언 및 초기화
//        Student s = new Student();
//
//        // 2. 파라미터 id를 s의 id에 저장
//        s.id = id;
//
//        // 3. 배열에서 s와 일치하는 칸의 index 를 얻어온다.
//        int index = ArrayUtil.indexOf(arr, s);
//
//        // 4. Student 변수 temp 에 array 의 index 번 칸의 값을 저장시켜서
//        // 출력에서 활용한다

            // id 값을 기반으로 일치하는 Student변수를 리턴해주는
            // selectOne() 을 사용하여 temp 를 초기화해준다.
            Student temp = selectOne(id);

            // 5. temp를 이용해 학생의 개별정보를 출력해준다.
            int sum =  temp.korean + temp.english + temp.math;
            double avg = (double) sum/SUBJECT_SIZE;

            System.out.println("------------------------------------");
            System.out.printf("학변 : %d 이름 : %s\n", temp.id, temp.name);
            System.out.printf("국어 : %03d 점 영어 : %03d 점 수학 : %03d 점\n", temp.korean, temp.english, temp.math);
            System.out.printf("총점 : %03d 점 평균 : %06.2f 점\n", sum, avg);

            // 6. 사용자로부터 수정, 삭제, 전체 목록보기 중 하나를 입력받는다.
            msg = "1.수정  2.삭제  3.뒤로가기";
            int userChoice = ScannerUtil.nextInt(scanner, msg);
            if(userChoice == 1) {
                // 수정메소드 update() 실행
                update(id);
            }else if(userChoice == 2) {
                // 삭제메소드 delete() 실행
                delete(id);
            }else if(userChoice == 3) {
                printAll();
            }else {
                System.out.println("존재하지 않는 메뉴입니다.");
            }
        }

        public static void update(int id) {
            Student temp = selectOne(id);

            msg = "새로운 이름을 입력해주세요.";
            temp.name = ScannerUtil.nextLine(scanner, msg);

            msg = "새로운 국어 점수를 입력해주세요";
            temp.korean = ScannerUtil.nextInt(scanner, msg);

            msg = "새로운 영어 점수를 입력해주세요";
            temp.english = ScannerUtil.nextInt(scanner, msg);

            msg = "새로운 수학 점수를 입력해주세요";
            temp.math = ScannerUtil.nextInt(scanner, msg);

            printOne(id);
        }

        public static void delete(int id) {
            Student temp = new Student();
            temp.id = id;

            // 사용자로부터 정말로 삭제할지 동의를 받는다.
            msg = "정말로 삭제하시겠습니까? Y/N";
            String yesNo = ScannerUtil.nextLine(scanner, msg);

            // String 클래스에 정의되어 있는 equalsIgnoreCase() 는
            // 2개의 스트링이 대소문자 상관없이 스펠링이 같으면 true
            // 그 외에는 false가 리턴된다.
            if(yesNo.equalsIgnoreCase("Y")) {
                arr = ArrayUtil.remove(arr, temp);
                printAll();
            }else {
                printOne(id);
            }
        }

        public static Student selectOne(int id) {
            Student result = null;

            Student temp = new Student();
            temp.id = id;
            if (ArrayUtil.contains(arr, temp)) {
                result = ArrayUtil.get(arr, ArrayUtil.indexOf(arr, temp));
            }

            return result;
        }



}
