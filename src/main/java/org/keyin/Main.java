package org.keyin;

import org.keyin.user.User;
import org.keyin.user.UserService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        UserService userService = new UserService();

        User user = new User("Jordan","j_j@j.com","jordan1234","Commander","Science");

        userService.createNewUser(user);

    }
}