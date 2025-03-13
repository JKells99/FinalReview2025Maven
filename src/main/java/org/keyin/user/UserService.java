package org.keyin.user;

import org.mindrot.jbcrypt.BCrypt;

import java.sql.SQLException;

public class UserService {

    private UserDAO userDAO = new UserDAO();



    public boolean createNewUser(User user){
        if( user.equals(null)){
            System.out.println("User is null please provide a valid user");
            return false;
        }
        String hashedPassword = BCrypt.hashpw(user.getPassword(),BCrypt.gensalt(8));

        user.setPassword(hashedPassword);

        userDAO.createNewUser(user);
        System.out.println("User created successfully");
        return true;
    }

    public void printAllUsersInSystem() throws SQLException {
        userDAO.getAllUsers();
    }


}
