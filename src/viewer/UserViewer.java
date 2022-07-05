package viewer;

import connector.DBConnector;
import controller.UserController;
import model.UserDTO;
import util.ScannerUtil;

import java.util.Scanner;

public class UserViewer {
    private Scanner scanner;
    private DBConnector connector;
    private UserDTO login;

    public UserViewer(Scanner scanner, DBConnector connector){
        this.scanner = scanner;
        this.connector = connector;

    }

    public void ShowMenu(){
        String msg = "1.로그인  2.회원가입  3.종료";
        while (true) {
            int userChoice = ScannerUtil.nextInt(scanner, msg);
            if (userChoice == 1){
                uesrLogin();

            }else if (userChoice == 3){
                usercreate();
            }else if (userChoice == 3){
                System.out.println("이용해주셔서 감사합니다.");
                break;
            }


        }

    }

    private void usercreate() {
        UserDTO u = new UserDTO();
        String msg;

        msg = "사용하실 아이디를 입력해주세요.";
        u.setUsername(ScannerUtil.nextLine(scanner, msg));

        msg = "사용하실 비밀번호를 입력해주세요.";
        u.setPassword(ScannerUtil.nextLine(scanner, msg));

        msg = "사용하실 닉네임을 입력해주세요.";
        u.setNickname(ScannerUtil.nextLine(scanner, msg));

        UserController controller = new UserController(connector);
        controller.insert(u);
    }

    private void uesrLogin() {
        UserController controller = new UserController(connector);

        String msg = "아이디를 입력해주세요.";
        String username = ScannerUtil.nextLine(scanner, msg);
        msg = "비밀번호를 입력해주세요.";
        String userpw = ScannerUtil.nextLine(scanner, msg);

        while (controller.auth(username, userpw) != true) {
            System.out.println("존재하지 않는 정보이거나 아이디와 비밀번호를 확인해주세요.");
            msg = "로그인을 그만하시겠습니까? Y / N";
            String userChoice = ScannerUtil.nextLine(scanner, msg);
            if (userChoice.equalsIgnoreCase("Y")){
                userpw = null;
                break;
            }
            msg ="아이디를 입력해주세요.";
            username = ScannerUtil.nextLine(scanner, msg);
            msg = "비밀번호를 입력해주세요.";
            userpw = ScannerUtil.nextLine(scanner, msg);
        }
        System.out.println("환영합니다.");
        controller.auth(username, userpw);
        login = controller.userId(username, userpw);

        while (true) {
            if (controller.auth(username, userpw)) {
                msg = "1.글목록  2.회원정보  3.로그아웃";
                int userChoice = ScannerUtil.nextInt(scanner, msg);
                if (userChoice == 1) {

                } else if (userChoice == 2) {

                    printuserOne(controller.userId(username, userpw));
                } else if (userChoice == 3) {
                    userpw = null;
                    break;
                }
            }
        }

    }

    private void printuserOne(UserDTO u) {
        UserController controller = new UserController(connector);
        UserDTO temp = controller.selectOne(u.getUserid());

        System.out.printf("고유번호 : %d번  |  아이디 : %s  |  닉네임 : %s\n",temp.getUserid(), temp.getUsername(), temp.getNickname());
        String msg = "1. 개인정보 수정  2. 회원탈퇴  3. 뒤로가기";
        int userChoice = ScannerUtil.nextInt(scanner, msg);
        if (userChoice == 1){
            userUpdate(temp.getUserid());
        }else if (userChoice == 2){
            userDelete(temp.getUserid());
        }else if (userChoice == 3){

        }
    }

    private void userUpdate(int id) {
        UserController controller = new UserController(connector);
        UserDTO u = controller.selectOne(id);
        String msg;
        String oldpassword = u.getPassword();

        msg = "변경을 원하시면 비밀번호를 입력해주세요.";
        String passwordcheck = ScannerUtil.nextLine(scanner, msg);

        while (!passwordcheck.equals(oldpassword)){

            msg = "변경을 그만하시겠습니까? Y / N";
            String yesNo = ScannerUtil.nextLine(scanner,msg);

            msg = "잘못입력하셨습니다. 다시 입력해주세요.";
            passwordcheck = ScannerUtil.nextLine(scanner, msg);
            if (yesNo.equalsIgnoreCase("y")){
                break;
            }
        }

        if (oldpassword.equals(passwordcheck)) {
            msg = "새로운 닉네임을 입력해주세요.";
            u.setNickname(ScannerUtil.nextLine(scanner, msg));

            msg = "새로운 비밀번호를 입력해주세요.";
            u.setPassword(ScannerUtil.nextLine(scanner, msg));

            msg = "정말로 변경하시겠습니까? Y / N";
            String yesNo = ScannerUtil.nextLine(scanner, msg);
            if (yesNo.equalsIgnoreCase("y")) {
                controller.update(u);
                printuserOne(u);
            }
        }
        printuserOne(u);

    }

    private void userDelete(int id) {
        UserController controller = new UserController(connector);
        UserDTO u = controller.selectOne(id);
        String msg = "정말로 탈퇴하시겠습니까? Y / N";
        String yesNo = ScannerUtil.nextLine(scanner, msg);
        if (yesNo.equalsIgnoreCase("Y")){
            msg = "비밀번호를 입력해주세요.";
            String oldPassword = ScannerUtil.nextLine(scanner, msg);
            if (oldPassword.equals(u.getPassword())){
                controller.delete(id);
                controller.auth(null, null);
            }
        }
        printuserOne(u);
    }


}
