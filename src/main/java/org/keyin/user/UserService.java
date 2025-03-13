package org.keyin.user;

public class UserService {

    private UserDAO userDAO = new UserDAO();



    public void createNewUser(User user){
        userDAO.createNewUser(user);
        System.out.println("User created successfully");
    }


}
