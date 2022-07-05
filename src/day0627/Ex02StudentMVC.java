package day0627;

import connector.DBConnector;
import connector.MySqlConnector;
import viewer.StudentViewer;

import java.util.Scanner;

public class Ex02StudentMVC {
    public static void main(String[] args) {
        DBConnector connector = new MySqlConnector();
        Scanner scanner = new Scanner(System.in);

        StudentViewer viewer = new StudentViewer(scanner, connector);

        viewer.ShowMenu();
    }
}
