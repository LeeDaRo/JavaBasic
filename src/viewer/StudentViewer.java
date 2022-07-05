package viewer;

import connector.DBConnector;
import controller.StudentController;
import day0616.Student;
import model.StudentDTO;
import util.ScannerUtil;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentViewer {
    private Scanner scanner;
    private DBConnector connector;

    public StudentViewer(Scanner scanner,DBConnector connector){
        this.scanner = scanner;
        this.connector = connector;
    }

    public void ShowMenu(){
        String msg = "1. 입력  2. 목록 출력  3. 종료";
        while (true){
            int Choice = ScannerUtil.nextInt(scanner, msg);
            if (Choice == 1){
                insertStudent();
            }else if (Choice == 2){
                printList();
            }else if (Choice == 3){
                System.out.println("이용해주셔서 감사합니다.");
                break;
            }
        }
    }
    private void insertStudent() {
        StudentDTO st = new StudentDTO();
        String msg;

        msg = "학생의 이름을 입력해주세요.";
        st.setName(ScannerUtil.nextLine(scanner, msg));

        msg = "학생의 국어 점수를 입력해주세요.";
        st.setKorean(ScannerUtil.nextInt(scanner, msg));

        msg = "학생의 영어 점수를 입력해주세요.";
        st.setEnglish(ScannerUtil.nextInt(scanner, msg));

        msg = "학생의 수학 점수를 입력해주세요.";
        st.setMath(ScannerUtil.nextInt(scanner, msg));

        StudentController controller = new StudentController(connector);
        controller.insert(st);

    }

    private void printList() {
        StudentController controller = new StudentController(connector);
        ArrayList<StudentDTO> list = controller.selectAll();

        if (list.isEmpty()){
            System.out.println("아직 입력된 학생이 존재하지 않습니다.");

        }else {
            for (StudentDTO st : list){
                System.out.printf("%d번 | 이름 :%s \n",st.getId(), st.getName());
            }

            String msg = "상세보기할 학생의 번호나 뒤로가기는 0번을 입력해주세요.";
            int userChoice = ScannerUtil.nextInt(scanner, msg);

            while (userChoice != 0 && controller.selectOne(userChoice) == null){
                System.out.println("잘못 입력하셨습니다.");
                userChoice = ScannerUtil.nextInt(scanner, msg);
            }

            if (userChoice != 0){
                printOne(userChoice);
            }
        }
    }

    private void printOne(int id) {
        StudentController controller = new StudentController(connector);
        StudentDTO st = controller.selectOne(id);
        int sum = st.getKorean() + st.getEnglish() + st.getMath();
        double avg = (double)sum / 3.0;

        System.out.printf("번호 : %d번  |  이름 : %s \n",st.getId(), st.getName());
        System.out.printf("국어 : %d점  |  영어 : %d점  |  수학 : %d점 \n",st.getKorean(), st.getEnglish(), st.getMath());

        System.out.printf("총점 : %d점  |  평균 : %06.2f \n", sum, avg);

        String msg = "1. 수정  2. 삭제  3.뒤로가기";
        int userChoice = ScannerUtil.nextInt(scanner, msg);
        if (userChoice == 1){
            studentUpdate(id);
        }else if (userChoice == 2){
            studentdelete(id);

        }else if (userChoice == 3){
            printList();
        }
    }

    private void studentUpdate(int id) {
        StudentController controller = new StudentController(connector);
        StudentDTO st = controller.selectOne(id);
        String msg;

        msg = "학생의 국어 점수를 입력해주세요.";
        st.setKorean(ScannerUtil.nextInt(scanner, msg));

        msg = "학생의 영어 점수를 입력해주세요.";
        st.setEnglish(ScannerUtil.nextInt(scanner, msg));

        msg = "학생의 수학 점수를 입력해주세요.";
        st.setMath(ScannerUtil.nextInt(scanner, msg));

        msg = "정말로 수정하시겠습니까?  Y / N";
        String yesNo = ScannerUtil.nextLine(scanner, msg);

        if (yesNo.equalsIgnoreCase("y")){
            controller.update(st);
        }
        printOne(id);
    }

    private void studentdelete(int id) {
        StudentController controller = new StudentController(connector);
        StudentDTO st = controller.selectOne(id);
        String msg = "정말로 삭제하시겠습니까?  Y / N";
        String yesNo = ScannerUtil.nextLine(scanner, msg);

        if (yesNo.equalsIgnoreCase("y")){
            controller.delete(id);
            printList();
        }else {
            printOne(id);
        }

    }


}
