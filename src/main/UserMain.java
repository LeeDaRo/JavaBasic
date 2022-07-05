package main;

import connector.DBConnector;
import connector.MySqlConnector;
import viewer.UserViewer;

import java.util.Scanner;

public class UserMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DBConnector connector = new MySqlConnector();

        UserViewer viewer = new UserViewer(scanner, connector);
        viewer.ShowMenu();
    }
}
