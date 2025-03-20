package org.keyin;

import org.keyin.mission.Mission;
import org.keyin.mission.MissionDAO;
import org.keyin.mission.MissionService;
import org.keyin.user.Engineer;
import org.keyin.user.User;
import org.keyin.user.UserService;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    static UserService userService = new UserService();
    static MissionService missionService = new MissionService();
    public static void main(String[] args) throws SQLException {


        //User user = new User("BillyBob3","b_b2@j.com","jordan1234","Commander","Science");
        Engineer engineer = new Engineer("BillyBob3", "b@bb.con", "jordan1234", "Science");
//        userService.createNewUser(engineer);

//        userService.printAllUsersInSystem();

        User user = userService.login("BillyBob3","jordan1234");

//        System.out.println(user.getRole());



        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while(true){
            displayMainMenu(scanner);
            choice = scanner.nextInt();

            switch(choice){
                case 1:
                    registerUser(scanner, userService);
                    break;

                case 2:
                    loginUser(scanner, userService);
                    break;

                default:
                    System.out.println("Invalid choice! Please select a valid option.");
            }
        }







    }

    private static void loginUser(Scanner scanner, UserService userService) throws SQLException {
        System.out.println("Enter username: ");
        String username = scanner.next();
        System.out.println("Enter password: ");
        String password = scanner.next();
        User user = userService.login(username, password);
        if(user != null){
            if(user.getRole().equalsIgnoreCase("commander")){
                showCommanderMenu(scanner,user);
            }
            if(user.getRole().equalsIgnoreCase("scientist")){
                System.out.println("Welcome scientist");
            }
            if(user.getRole().equalsIgnoreCase("engineer")){
                System.out.println("Welcome engineer");
            }
            System.out.println("User logged in successfully");
        }else{
            System.out.println("User not found");
        }
    }

    private static void showCommanderMenu(Scanner scanner,User user) throws SQLException {
        System.out.println("Welcome Commander " + user.getUsername());
        System.out.println("What would you like to do?");
        System.out.println("1. View all users with contact info");
        System.out.println("2. Create New Mission");

        int choice = scanner.nextInt();
        switch(choice){
            case 1:
                printAllUsersInSystem();
                break;
            case 2:
                createNewMissionMenu(scanner);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    private static void createNewMissionMenu(Scanner scanner) {
        System.out.println("Enter mission name: ");
        String missionName = scanner.next();
        System.out.println("Enter mission type: ");
        String missionType = scanner.next();
        System.out.println("Enter user id to assign mission to: ");
        int userId = scanner.nextInt();
        System.out.println("Enter mission status: ");
        String status = scanner.next();

        Mission mission = new Mission(missionName, missionType, userId, status);
        missionService.createMission(mission);


    }

    private static void printAllUsersInSystem() throws SQLException {
        userService.printAllUsersInSystem();

    }

    private static void registerUser(Scanner scanner, UserService userService) {
        System.out.println("Enter username: ");
        String username = scanner.next();
        System.out.println("Enter email: ");
        String email = scanner.next();
        System.out.println("Enter password: ");
        String password = scanner.next();
        System.out.println("Enter role: ");
        String role = scanner.next();
        System.out.println("Enter sector: ");
        String sector = scanner.next();

        User user = new User(username, email, password, role, sector);
        userService.createNewUser(user);
    }

    private static void displayMainMenu(Scanner scanner) {
        System.out.println("Welcome To The Space Crew System");
        System.out.println("What Would You Like To Do?");
        System.out.println("1. Create A New User");
        System.out.println("2. Login");
        System.out.println("3. Exit");
    }
}