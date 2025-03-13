package org.keyin;

import org.keyin.user.User;
import org.keyin.user.UserService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        UserService userService = new UserService();
        User user = new User("BillyBob2","b_b2@j.com","jordan1234","Commander","Science");
        userService.createNewUser(user);

        userService.printAllUsersInSystem();


    }
}