package day0617;

import util.ScannerUtil;

import java.util.ArrayList;
import java.util.Scanner;
public class BoardMain {
    // 전역 변수
    private static int nextBoardId = 1;
    private static int nextReplyId = 1;
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Board> boardList = new ArrayList<>();
    private static ArrayList<Reply> replyList = new ArrayList<>();

    public static void main(String[] args) {
        showMenu();

    }

    private static void showMenu() {
        String msg;


        while (true){
            msg = "1. 글 작성  2. 글 목록  3. 종료" ;
            int userChoice = ScannerUtil.nextInt(scanner, msg);
            if (userChoice == 1){
                writeBoard();
            }else if (userChoice == 2){
                printList();
            }else if (userChoice == 3){
                System.out.println("이용해주셔서 감사합니다.");
                break;
            }
        }

    }

    private static void writeBoard() {
        String msg;
        Board b = new Board();
        b.setId(nextBoardId++);
        msg = "제목을 입력해주세요";
        b.setTitle(ScannerUtil.nextLine(scanner, msg));
        msg = "작성자를 입력해주세요.";
        b.setWriter(ScannerUtil.nextLine(scanner, msg));
        msg = "내용을 입력해주세요.";
        b.setContent((ScannerUtil.nextLine(scanner, msg)));

        boardList.add(b);

    }

    private static void printList() {
        String msg;
        if (boardList.isEmpty()){
            System.out.println("아직 작성된 글이 없습니다.");
        }else {
            for (Board b: boardList) {
                System.out.printf("%d  %s\n",b.getId(),b.getTitle());

            }
        }
        msg = "상세보기할 글의 번호나 뒤로 가시려면 0을 입력해주세요.";
        int userChoice = ScannerUtil.nextInt(scanner, msg);
        while (userChoice != 0 && selectOne(userChoice) == null){
            System.out.println("잘못 입력하셨습니다.");
            userChoice = ScannerUtil.nextInt(scanner, msg);
        }
        if (userChoice != 0){
            printOne(userChoice);
        }
    }

    private static void printOne(int boardId) {
        String msg;
        Board b = selectOne(boardId);

        b.print();

        System.out.println("-------------------------");
        System.out.println("\t\t댓글");
        System.out.println("-------------------------");
        for (Reply r : replyList){
            if (r.getBoardId() == b.getId()){
                r.print();
            }
        }

        System.out.println("-------------------------");
        msg = "1. 수정  2. 삭제  3. 덧글등록  4. 뒤로가기";
        int userChoice = ScannerUtil.nextInt(scanner, msg);

        if (userChoice == 1){
            update(boardId);
        }else if (userChoice == 2){
            delete(boardId);
        }else if (userChoice == 3){
            writeReply(boardId);
        }else {
            printList();
        }

    }

    private static void update(int boardId) {
        Board b = new Board();
        Board original = selectOne(boardId);
        String msg;
        System.out.println("기존 제목 : " + original.getTitle());
        msg = "새로운 제목을 입력해주세요.";
        b.setTitle(ScannerUtil.nextLine(scanner, msg));
        System.out.println("기존 내용 : " + original.getContent());
        msg = "새로운 내용을 입력해주세요.";
        b.setContent((ScannerUtil.nextLine(scanner, msg)));
        msg = "정말로 수정하시겠습니까? Y / N";
        String yesNo = ScannerUtil.nextLine(scanner, msg);

        if (yesNo.equalsIgnoreCase("Y")){
            original.setTitle(b.getTitle());
            original.setContent(b.getContent());
        }

        printOne(boardId);
    }

    private static void delete(int boardId) {
        String msg = "정말로 삭제하시겠습니까? Y / N";
        String yesNo = ScannerUtil.nextLine(scanner, msg);
        if (yesNo.equalsIgnoreCase("Y")){
            boardList.remove(new Board(boardId));
            printList();
        }else {
            printOne(boardId);

        }

    }

    private static void writeReply(int boardId) {
        Reply r = new Reply();
        String msg;
        r.setId(nextReplyId++);
        r.setBoardId(boardId);
        msg = "덧글을 입력해주세요.";
        r.setContent(ScannerUtil.nextLine(scanner, msg));

        replyList.add(r);
        printOne(boardId);
    }

    private static Board selectOne(int boardId){
        Board b = new Board(boardId);
        if (boardList.contains(b)){

            return boardList.get(boardList.indexOf(b));
        }

        return null;
    }


}
